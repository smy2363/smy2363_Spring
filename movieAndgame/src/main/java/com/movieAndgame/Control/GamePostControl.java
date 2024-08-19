package com.movieAndgame.Control;

import java.util.List;

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
import com.movieAndgame.Dto.GamePostDto;
import com.movieAndgame.service.GamePostService;


@Controller
@RequestMapping("/gamepost")
public class GamePostControl {

	@Autowired 	
	private GamePostService gamePostService;
	
	// 글 내용 작성후 저장 요청
	@PostMapping("/write")
	public String write(@Valid GamePostDto gamePostDto,
			BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) { 
			return "game/post/gamewrite";
		}
		gamePostService.write(gamePostDto);
		return "redirect:/gamepost/m";
	}

	
	// 첫페이지(리뷰목록)
	@GetMapping("/gamewrite")
	public String index(Model model) {
		List<GamePostDto> list=gamePostService.gamelist();
		model.addAttribute("gameList", list);
		
		return "game/post/index";
	}
	
	//리뷰 작성페이지 요청
	@GetMapping("/write")
	public String write(Model model,HttpSession session) {
		if(session.getAttribute("user") ==null) {// 로그인 상태가 아니면 로그인페이지이동
			return "redirect:/game/login";
		}
		
		GamePostDto dto = new GamePostDto();		
		String name = ((GameMember)session.getAttribute("user")).getNickName();
		dto.setWriter(name);
		
		model.addAttribute("gamePostDto",dto);
		
		return "game/post/gamewrite";
	}
	
}