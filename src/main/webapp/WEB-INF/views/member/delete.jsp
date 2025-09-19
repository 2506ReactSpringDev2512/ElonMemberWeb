<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 삭제</title>
</head>
<body>
	<h1>나는 헤더에요</h1>
	<h1>회원 정보 삭제</h1>
	<form action="/member/delete" method="post">
		아이디 입력 : <input type="text" name="memberId"> 
		<input type="submit" value="삭제">
	</form>
	<h1>나는 푸터에요</h1>
</body>
</html>