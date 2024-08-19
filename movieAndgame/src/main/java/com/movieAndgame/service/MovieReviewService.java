package com.movieAndgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.MovieReviewDaoImpl;
import com.movieAndgame.Dto.MovieReviewDto;

@Service
public class MovieReviewService {
	
	@Autowired
	private MovieReviewDaoImpl movieReviewDao;
	
	//movie_review 테이블에서 데이터 가져와 컨트롤에 전달(목록 출력)
	public List<MovieReviewDto> reviewlist(){
		return movieReviewDao.findAll();
	}
	
	public void save(MovieReviewDto movieReviewDto) {
		movieReviewDao.reviewSave(movieReviewDto);
	}

	public MovieReviewDto findById(int id) {
		
		return movieReviewDao.findById(id);
		
	}


	
}
