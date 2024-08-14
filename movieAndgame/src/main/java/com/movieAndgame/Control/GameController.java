package com.movieAndgame.Control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.service.GameMemberService;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameMemberService gameMemberService;
	
	@GetMapping("/index")
	public String gameHome(Model model) {
	
		return "game/index";
	}
	
	@GetMapping("/login")
	public String gameLogin(Model model) {
		
		model.addAttribute("login", new GameMember());
		return "game/member/login";
	}
	
	//회원가입 페이지 요청
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("gameMember", new GameMember());
		return "game/member/join";
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid GameMember gameMember,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "game/member/join";
		}
		gameMemberService.joinSave(gameMember);
		return "redirect:/game/login";
	}

}
