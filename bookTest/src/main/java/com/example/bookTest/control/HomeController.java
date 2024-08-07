package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.InfoDto;

@Controller
public class HomeController {
	
	//요청 주소와 메서드를 매핑(연결) 시켜준다.
	
	@GetMapping("/home")
	public String homeView() { //뷰 페이지만 제공하는경우에 페이지 이름만 넘긴다.
		return "home";
	}
	
	@GetMapping("/infoInput")
	public ModelAndView info(@ModelAttribute InfoDto infoDto) {
	// ModleAndView는 사용자에게 제공할 페이지와 데이터를 저장할 수 있는 클래스이다.
	// 사용자에게 제공할 페이지는 객체 생성시 입력하거나 setViewName메서드로 입력하면된다.
		ModelAndView mv = new ModelAndView("info");
	// mv.setViewName("info"); 메서드로 페이지입력
		int age=45;
		mv.addObject("ageData",age); // 뷰 페이지에 전달할 데이터 설정
		
		return mv;
	}

}
