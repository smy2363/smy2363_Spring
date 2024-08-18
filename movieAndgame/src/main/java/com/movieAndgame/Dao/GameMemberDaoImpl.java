package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.GameMemberLogin;

@Mapper
public interface GameMemberDaoImpl {
	public int insert(GameMember gameMemberDto);
	public GameMember login(GameMemberLogin gameMemberLogin);// 로그인
}