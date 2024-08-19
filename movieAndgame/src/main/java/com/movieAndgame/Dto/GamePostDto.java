package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GamePostDto {
	private int post_id;
	private String writer;
	@NotBlank(message="제목은 필수입니다.")
	private String title;
	@NotBlank(message="게임 명 입력하세요")
	private String game_name;
	@NotBlank(message="내용은 필수입니다.")
	private String target_post;
	private LocalDateTime write_date;
}