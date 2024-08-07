package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
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

}
