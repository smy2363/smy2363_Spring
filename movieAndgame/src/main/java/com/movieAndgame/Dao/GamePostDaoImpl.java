package com.movieAndgame.Dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GamePostDto;

@Mapper
public interface GamePostDaoImpl {

	public int save(GamePostDto gamePostDto);
	
	//전체 데이터 가져오기 - 목록 출력
	public List<GamePostDto> findAll();
	
	// 글 상세 보기 - 데이터 베이스에서 가져오기 review_id
	public GamePostDto findById(int id);

}
