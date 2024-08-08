<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<link rel="stylesheet" href="/css/default.css">
</head>
<body>

	<a href="/coffeReg">커피등록</a>
	
	<!--
	클래스명 
		컨트롤 : CoffeControl
		서비스 : CoffeService
		DTO   : CoffeDto
		DAO  : CoffeDao
		
	 -->
	
	<div id="wrap">
		<h2> 도서관리 </h2>
		<div id="mainTitle">
			<h3> 등록 도서 목록 </h3>
			<a href="/bookWrite" id="enroll">도서등록</a>
		</div>
		<div id="bookListWrap">
			<ul id="bookList">
				<li class="blist">
					<span class="title">자바의 기초</span>
					<span class="auth">이모모</span>
					<span class="bookCode">E4469</span>
					<span class="category">컴퓨터</span>
				</li>
				<li class="blist">
					<span class="title">고양이 키우기</span>
					<span class="auth">뭉크</span>
					<span class="bookCode">C9182</span>
					<span class="category">애완동물</span>
				</li>
				<li class="blist">
					<span class="title">고양이 행동알기</span>
					<span class="auth">치즈</span>
					<span class="bookCode">C8132</span>
					<span class="category">애완동물</span>
				</li>
				<li class="blist">
					<span class="title">떠나자 파리로</span>
					<span class="auth">린선생</span>
					<span class="bookCode">B7489</span>
					<span class="category">여행</span>
				</li>
				<li class="blist">
					<span class="title">치즈치즈 사진첩</span>
					<span class="auth">왕치즈</span>
					<span class="bookCode">C4445</span>
					<span class="category">애완동물</span>
				</li>
				
			</ul>
		</div>	
	</div>
	


</body>
</html>