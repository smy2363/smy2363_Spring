package com.example.bookTest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.CoffeDto;
import com.example.bookTest.service.CoffeService;



@Controller
public class CoffeControl {
	
	@Autowired
	private CoffeService coffeService;
	
	@GetMapping("/coffe")
	public String home() {
		return "coffe/index";
	}
	
	@GetMapping("/coffeReg")
	public String CoffeView() {
				
		return "coffe/Coffe";

	}
	
	@GetMapping("/coffeSave")
	public String Coffe(@ModelAttribute CoffeDto coffeDto) {
		
		coffeService.coffeSave(coffeDto);
		
		return "redirect:/Coffe";
	}

}
