<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="/member/update" method="post">
		아이디: <input type="text" name="memberId"> <br> 
		수정할 비밀번호: <input type="password" name="memberPwd"> <br> 
		수정할 이메일: <input type="text" name="Email"> <br> 
		수정할 전화번호: <input type="text" name="Phone"><br> 
		수정할 주소: <input type="text" name="Address"> <br> 
		수정할 취미:<input type="text" name="Hobby"> <br> 
		<input type="submit" value="수정">
	</form>
</body>
</html>