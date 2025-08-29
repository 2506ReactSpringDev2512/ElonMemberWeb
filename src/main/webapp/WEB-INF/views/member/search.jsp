<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색(아이디)</title>
</head>
<body>
	<h1>3. 회원 검색(아이디)</h1>
	<form action="/member/search" method="post">
		정보 검색할 회원 아이디 입력 : <input type="text" name="memberId">
		<input type="submit" value="검색">
	</form>
	<br><br><br>
	<a href="/">메인페이지로 이동</a>
</body>
</html>