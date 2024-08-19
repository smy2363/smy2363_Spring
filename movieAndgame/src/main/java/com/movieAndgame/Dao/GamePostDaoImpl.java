package com.movieAndgame.Dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GamePostDto;

@Mapper
public interface GamePostDaoImpl {

	public int save(GamePostDto gamePostDto);
	
	//전체 데이터 가져오기 - 목록 출력
	public List<GamePostDto> findAll();

}
