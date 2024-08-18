package com.movieAndgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDaoImpl;
import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.GameMemberLogin;

@Service
public class GameMemberService {
	@Autowired
	private GameMemberDaoImpl gameMemberDaoImpl;
	
	//로그인
	public GameMember login(GameMemberLogin gameMemberLogin) {
		return gameMemberDaoImpl.login(gameMemberLogin);
	}
	
	//회원 가입
	public void joinSave(GameMember gameMemberDto) {
		gameMemberDaoImpl.insert(gameMemberDto);
	}
}