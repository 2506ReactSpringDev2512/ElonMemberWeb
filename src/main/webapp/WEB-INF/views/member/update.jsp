<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<form action="/member/update" method = "post">
		정보를 수정할 회원 아이디 입력 : <input type="text" name="memberId"> <br>
		수정할 비밀번호 : <input type="text" name="memberPwd"> <br>
		수정할 이름 : <input type="text" name="memberName"> <br>
		수정할 이메일 : <input type="text" name="Email"> <br>
		수정할 전화번호 : <input type="text" name="Phone"> <br>
		수정할 주소 : <input type="text" name="Address"> <br>
		<input type="submit" value="수정">
	</form>
</body>
</html>