package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookDto;
import com.example.bookTest.Dto.BookInfoDto;

@Repository
public class BookDAO {

	private final JdbcTemplate jt;
	
	@Autowired
	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jt=jdbcTemplate;
	}
	
	// book테이블 전체 데이터 가져오기 - 첫화면에 목록으로 출력하기위해
	
	public List<BookInfoDto> select(){	
		String sql="select * from book";
		
		List<BookInfoDto> list = jt.query(sql, new BookDtoRowMapper());
		
		return list;
	}
	
	
	public void insert(BookInfoDto bookInfoDto) { //도서정보 데이터베이스에 저장
		String sql="insert into book(book_title, book_author, book_cost, "+
				"book_page, book_publisher) values(?,?,?,?,?)";
		
		jt.update(sql , bookInfoDto.getBookTitle(), bookInfoDto.getBookAuthor(), 
				bookInfoDto.getBookCost(), bookInfoDto.getBookPage(), bookInfoDto.getPublisher() );
	}
	
	
	public class BookDtoRowMapper implements RowMapper<BookInfoDto>{

		@Override
		public BookInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookInfoDto bookInfoDto = new BookInfoDto();
			bookInfoDto.setBookAuthor(rs.getString("book_author"));
			bookInfoDto.setBookCost(rs.getInt("book_cost"));
			bookInfoDto.setBookPage(rs.getInt("book_page"));
			bookInfoDto.setBookTitle(rs.getString("book_title"));
			bookInfoDto.setPublisher(rs.getString("book_publisher"));
			bookInfoDto.setBookId(rs.getInt("book_id"));
			return bookInfoDto;
		}
		
	}
	
}
