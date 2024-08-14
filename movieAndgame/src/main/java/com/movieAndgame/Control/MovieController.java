package com.movieAndgame.Control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.service.MovieMemberService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieMemberService movieMemberService;
	
	// "/"은 localhost/movie 매핑이다.
	@GetMapping("/index")
	public String Home(Model model) {
		
		return "movie/index";
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		
		model.addAttribute("member", new MovieMember());
		
		return "movie/member/login";
	}
	
	// 회원가입 페이지 요청
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("movieMember", new MovieMember());
		return "movie/member/join";
	}
	
	// 회원가입 작성 후 요청
	@PostMapping("/signUp")
	public String signUp(@Valid MovieMember movieMember,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println("유효하지 않은값이 입력되었습니다.");
			
			return "movie/member/join";
		}
		
		movieMemberService.signUpSave(movieMember);
		
		return "redirect:/movie/login";
	}


}
