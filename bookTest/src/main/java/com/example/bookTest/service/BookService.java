package com.example.bookTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.BookDAO;
import com.example.bookTest.Dto.BookInfoDto;

@Service
public class BookService {
	
	private final BookDAO bookDao;
	
	@Autowired
	public BookService(BookDAO bookDAO) {
		this.bookDao=bookDAO;
	}
	
	// 도서정보 저장
	public void bookSave(BookInfoDto bookInfoDto) {
		
		if(bookInfoDto != null) {
			// 도서 코드가 이미 데이터베이스에 저장되어있는지 확인 후 저장
			bookDao.insert(bookInfoDto); //DAO 클래스의 insert메서드 실행해서 저장
		}
	}

		
		
	
	
}
