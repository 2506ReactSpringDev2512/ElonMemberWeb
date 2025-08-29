<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보삭제</h1>
	<p>삭제할 아이디를 입력해주세요.</p>
	<form action="/member/delete" method="post">
		아이디 : <input type="text" name="memberId">
		<input type="submit" value="삭제">
	</form>
</body>
</html>