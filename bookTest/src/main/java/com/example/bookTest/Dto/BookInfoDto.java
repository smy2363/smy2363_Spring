package com.example.bookTest.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInfoDto {
	private String bookTitle; //책 제목
	private String bookAuthor; // 저자
	private String bookCost; // 가격
	private String bookPage; // 페이지수
	private String piblisher; // 출판사

}
