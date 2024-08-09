package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.CoffeDto;
import com.example.bookTest.service.CoffeService;



@Controller
public class CoffeControl {
	
	@Autowired
	private CoffeService coffeService;
	

	
	@GetMapping("/coffe")
	public ModelAndView home() {
		ModelAndView m = new ModelAndView("coffe/index");
		
		List<CoffeDto> li = coffeService.selectAll();
		m.addObject("list", li);
		
		return m;
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
	
	@GetMapping("/coffe/view")
	public ModelAndView view(@RequestParam(value="id",
			required=false, defaultValue="0")int id) {
		
		CoffeDto data = coffeService.getCoffe(id);
		
		if(data == null) data = new CoffeDto();
		
		return new ModelAndView("coffe/view").addObject("coffe", data);
	}
	
	@GetMapping("/coffe/delete")
	public String coffeRemove(@RequestParam("id")int del) {
		coffeService.remo(del);
		return "redirect:/coffe";
	}
	

}
