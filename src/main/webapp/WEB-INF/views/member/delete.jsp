<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 삭제</title>
</head>
<body>
	<h1>회원 정보 삭제</h1>
	<form action="/member/delete" method="post">
		<input type="hidden" name="memberId" value="${member.memberId }" >
		"${member.memberId }" 아이디를 삭제할까요?<input type="submit" value="삭제">
	</form>
</body>
</html>