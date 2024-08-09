package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BookInfoDto;
import com.example.bookTest.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private  BookService bookService;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		
		List<BookInfoDto> list = bookService.selectAll();
		mv.addObject("list", list);
	
		return mv;
	}
	
	@GetMapping("/bookWrite")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView("book/bookForm");
		mv.addObject("count", 5);
		
		return mv;
	}
	
	@PostMapping("/enroll")
	public String write(@ModelAttribute BookInfoDto bookInfoDto) {
		// form태그안에 입력한 값은 BookDto클래스의 객체에 저장되어있다.
		// 데이터베이스에 저장하려면 BookDto객체를 DAO에 넘겨서 저장하면된다.
		// 컨트롤 -> service -> DAO
		bookService.bookSave(bookInfoDto);
		
		return "index";
	}
	
	@GetMapping("/book/view")
	public ModelAndView view(@RequestParam(value="id", 
			required=false, defaultValue="0")int id) {
		
		BookInfoDto data = bookService.getBook(id);

		if(data == null) data = new BookInfoDto(); // getBook메서드의 반환값으로 null 저장 된다면
												   // view.jsp에서 변수의 값이 null이기때문에
												   // get 메서드 호출이 안되어 오류가 발생한다.
												   // 오류가 발생되지 않게 하기위해 빈 값이 있는 객체 할당
		return new ModelAndView("book/view").addObject("book",data);
	}
	
	
	@GetMapping("/book/delete")
	public String bookRemove(@RequestParam("id")int bid) {
		
		bookService.remove(bid);
		
		return "redirect:/";
	
	}

}
