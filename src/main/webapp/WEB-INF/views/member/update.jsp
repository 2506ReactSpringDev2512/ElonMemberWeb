<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
body { text-align: center; }
table { margin: 20px auto; border-collapse: collapse; }
td { padding: 8px; text-align: left; }
td:first-child { text-align: right; padding-right: 15px; font-weight: bold; }
input[type="submit"] { margin-top: 10px; padding: 8px 20px; }
</style>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="/member/update" method="post">
		<table>
			<tr><td>아이디 :</td><td><input type="text" name="memberId"></td></tr>
			<tr><td>비밀번호 :</td><td><input type="password" name="memberPwd"></td></tr>
			<tr><td>이름 :</td><td><input type="text" name="memberName"></td></tr>
			<tr><td>성별 :</td><td>남<input type="radio" name="gender" value="M"> 여<input type="radio" name="gender" value="F"></td></tr>
			<tr><td>나이 :</td><td><input type="text" name="age"></td></tr>
			<tr><td>이메일 :</td><td><input type="text" name="email"></td></tr>
			<tr><td>전화번호 :</td><td><input type="text" name="phone"></td></tr>
			<tr><td>주소 :</td><td><input type="text" name="address"></td></tr>
			<tr><td>취미 :</td><td><input type="text" name="hobby"></td></tr>
			<tr><td colspan="2"><input type="submit" value="수정"></td></tr>
		</table>
	</form>
</body>
</html>