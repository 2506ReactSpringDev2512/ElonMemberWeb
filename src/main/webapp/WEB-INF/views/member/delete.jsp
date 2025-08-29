<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 삭제</title>
</head>
<body>
	<h1>5. 회원 정보 삭제</h1>
	<form action="/member/delete" method="post">
		삭제할 이름 ID 입력 : <input type="text" name="memberId">
		<input type="submit" value="삭제">
	</form>
	<br><br><br>
	<a href="/">메인페이지로 이동</a>
</body>
</html>