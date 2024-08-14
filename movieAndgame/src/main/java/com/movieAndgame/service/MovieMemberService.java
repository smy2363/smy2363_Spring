package com.movieAndgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.MovieMemberDao;
import com.movieAndgame.Dto.MovieMember;

@Service
public class MovieMemberService {
	
	@Autowired
	private MovieMemberDao movieMemberDao;
	
	// 회원가입 데이터베이스 저장
	public void signUpSave(MovieMember movieMember) {
		movieMemberDao.insert(movieMember);
	}

}
