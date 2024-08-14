package com.movieAndgame.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieMember {
	
	@NotEmpty(message="이메일을 입력하세요")
	private String email;
	
	@Size(min=4, max=12, message="비밀번호는 4~12 자리로 입력하세요")
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="영어 대소문자와 숫자만 입력하세요")
	private String password;
	private String name;
	private int birthYear;
	private int birthMonth;
	
	@NotNull(message="연락처는 필수 입니다.")
	private String tel;
	
}

/*
 
	validation 데이터 유효성 검증
	
	Annotation 종류
	@NotEmpty : null, 빈 문자열 불가
	@NtoNull : null 불가 (빈 문자열, 공백 허용)
	@Null : null만 허용
	@NotBlank : null, 빈 문자열, 공백 불가
	
	@Min(value=) : value 이하의 값만 허용
		@Min(value=1-, message="10이하만 입력하세요")
		private int num;
	@Max(value= ) : value 이상 값만 허용
		@Max(value=5, message="5이상만 입력하세요")
		praivate int num;
	@Size(min= , max= ) : 길이를 제한 할때 사용
		@Size(min=10, max=20, message="10자 이상 20자 이하만 입력")
		private String title;
	@Positive : 양수값만 허용
	@PositiveOrZero : 양수와 0만 허용
	@Negative : 음수만 허용
	@NegativeOrZero : 음수왕 0만 허용
	
	@Email : 이메일 형식검사, 빈문자열은 패스
	@Pattern( regexp= ) : 정규식 검사



*/
