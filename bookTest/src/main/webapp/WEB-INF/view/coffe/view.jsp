<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 도서정보 보기 </title>
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/info.css">
<script src="/javascript/coffe.js"></script>
</head>
<body>

	<div id="wrap">
		<a href="/coffe"> HOME </a>
		<table id="viewBox">
			<tr>
				<td class="fieldName">음료명</td>
				<td class="value">${coffe.itemName}</td>					
			</tr>
			<tr>
				<td class="fieldName">금액</td>
				<td class="value">
				<fmt:formatNumber value="${coffe.price}" pattern="#.###원"/>
				</td>					
			</tr>
			<tr>
				<td class="fieldName">디카페인여부</td>
				<td class="value">${coffe.decaffein}</td>					
			</tr>
			
			<tr>
				<td colspan="2">
					<button type="button" id="modify">수정</button>
					<button type="button" id="del" data-id="${coffe.coffeId}">삭제</button>
				</td>
			</tr>
			
		</table>
	</div>

</body>
</html>