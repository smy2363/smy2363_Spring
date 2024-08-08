package com.example.bookTest.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookInfoDto;

@Repository
public class BookDAO {

	private final JdbcTemplate jt;
	
	@Autowired
	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jt=jdbcTemplate;
	}
	
	public void insert(BookInfoDto bookInfoDto) { //도서정보 데이터베이스에 저장
		String sql="insert into book(book_title, book_author, book_cost, "+
				"book_page, book_publisher) values(?,?,?,?,?)";
		
		jt.update(sql , bookInfoDto.getBookTitle(), bookInfoDto.getBookAuthor(), 
				bookInfoDto.getBookCost(), bookInfoDto.getBookPage(), bookInfoDto.getPublisher() );
	}
	
}
