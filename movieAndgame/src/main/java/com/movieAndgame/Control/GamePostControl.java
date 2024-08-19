package com.movieAndgame.Control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.GamePostDto;
import com.movieAndgame.service.GamePostService;


@Controller
@RequestMapping("/gamepost")
public class GamePostControl {

	@Autowired
	private GamePostService gamePostService;
	
	//게임 리뷰 첫페이지(목록)
	@GetMapping("/m")
	public String index(Model model) {
		
		model.addAttribute("mList",gamePostService.mlist());
		
		return "game/post/index";
	}
	
	//작성페이지 요청
	@GetMapping("/write")
	public String write(Model model,HttpSession session) {
		if(session.getAttribute("user") ==null) {// 로그인 상태가 아니면 로그인페이지이동
			return "redirect:/game/login";
		}
		
		GamePostDto dto = new GamePostDto();		
		String name = ((GameMember)session.getAttribute("user")).getNick_name();
		dto.setWriter(name);
		
		model.addAttribute("gamePostDto",dto);
		
		return "game/post/gamewrite";
	}
	
	
	@PostMapping("/write")
	public String write(@Valid GamePostDto gamePostDto,
			BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "game/post/gamewrite";
		}
		gamePostService.write(gamePostDto);
		return "redirect:/game/post/m";
	}
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id")int id, Model model) {
		GamePostDto dto=gamePostService.findById(id);
		model.addAttribute("gamePostDto",dto);
		return "game/post/detail";
	}
}