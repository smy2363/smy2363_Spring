<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${ageData}</h1>

	<h2> 그냥 html, css, js로 구성되어있는 페이지만 제공한다면 </h2>
	<div> ModelAndView를 사용하지 않아도 된다. </div>
	<p> 아무리 form에 입력하고 버튼 클릭해서 form데이터 받는 Mapping을<p>
	<h3> 만들었어도 그다음 보여줄 페이지에 데이터 제공 하지 않을꺼라면
	그냥 페이지만 넘겨주면 된다.</h3>

	<h1>이름 : ${Name}</h1>
	<h1>생년월일 : ${Birth}</h1>
</body>
</html>