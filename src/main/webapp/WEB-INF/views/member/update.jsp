<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="/member/update" method = "post">
	<table>	
		<tr>
			<th>이름</th>
			<td><input type = "text" name = "memberName">
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type = "text" name = "memberId">
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type = "password" name = "memberPw">
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type = "text" name = "email">
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type = "text" name = "phone">
		</tr>
		<tr>
			<th>주소</th>
			<td><input type = "text" name = "address">
		</tr>
		<tr>
			<th>취미</th>
			<td><input type = "text" name = "hobby">
		</tr>
	</table>
		<input type = "submit" value = "확인">
	</form>
</body>
</html>