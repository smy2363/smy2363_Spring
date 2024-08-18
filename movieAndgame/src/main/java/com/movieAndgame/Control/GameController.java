package com.movieAndgame.Control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.GameMemberLogin;
import com.movieAndgame.service.GameMemberService;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameMemberService gameMemberService;
	
	// localhost/game/index 매핑
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
	
	//로그인
	@PostMapping("/signIn")
	public String signIn(@Valid GameMemberLogin gameMemberLogin,
			BindingResult bind , Model model , HttpSession session) {
		
		GameMember user = gameMemberService.login(gameMemberLogin);
		if(user == null) {
			bind.rejectValue("password","error.password","이메일 또는 비밀번호가 잘못 되었습니다.");
		}
		if(bind.hasErrors())
			return "game/member/login";
		
		// 로그인 성공시 로그인 화면 이전 방문 페이지 이동
		String preUri = (String)session.getAttribute("preUri");
		session.setAttribute("user", user);
		return "redirect:"+preUri;//"redirect:/game/index";
	}
}
