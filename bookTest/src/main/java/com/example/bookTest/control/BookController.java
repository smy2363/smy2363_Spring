package com.example.bookTest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

}
