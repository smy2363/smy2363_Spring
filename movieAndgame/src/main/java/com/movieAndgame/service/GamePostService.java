package com.movieAndgame.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GamePostDaoImpl;
import com.movieAndgame.Dto.GamePostDto;

@Service
public class GamePostService {

	@Autowired
	private GamePostDaoImpl gamePostDao;
	
	//game_post 테이블에서 데이터 가져와 컨트롤에 전달(목록 출력)
	public List<GamePostDto> mlist(){
		return gamePostDao.findAll();
	}
	
	public void write(@Valid GamePostDto gamePostDto) {
		gamePostDao.save(gamePostDto);
		
	}

	public GamePostDto findById(int id) {
		
		return gamePostDao.findById(id);
	}

}