package com.example.bookTest.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInfoDto {
	private String bookTitle; //책 제목
	private String bookAuthor; // 저자
	private int bookCost; // 가격
	private int bookPage; // 페이지수
	private String publisher; // 출판사

}
