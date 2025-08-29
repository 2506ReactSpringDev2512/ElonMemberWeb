<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<h1>회원 정보 등록</h1>
	<form action="/member/signup" method = "post">
		아이디: <input type="text" name="memberId"> <br>
		비밀번호: <input type="password" name="memberPwd"> <br>
		이름: <input type="text" name="memberName"> <br>
		성별: <label><input type="radio" name="Gender" value ='M'>남성</label>
			<label><input type="radio" name="Gender" value ='F'>여성</label><br>
		나이: <input type="number" name="Age"> <br>
		이메일: <input type="text" name="Email"> <br>
		전화번호: <input type="text" name="Phone"> <br>
		주소: <input type="text" name="Address"> <br>
		취미: <input type="text" name="Hobby"> <br>
		<input type="submit" value="등록">
	</form>
</body>
</html>