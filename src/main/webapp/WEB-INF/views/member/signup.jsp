<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/member/signup" method="post">
		아이디 : <input type="text" name="memberId"> <br>
		비밀번호 : <input type="text" name="memberPw"><br>
		이름 : <input type="text" name="memberName"><br>
 		성별 :<label for="gender">남<input type="radio" name="gender" value="M"></label><br>
			 <label for="gender">여<input type="radio" name="gender" value="F"></label><br>
<!-- 
 		성별 :<input type="text" name= gender>
 -->
		나이 : <input type="number" name="age"><br>
		이메일 : <input type="text" name="email"><br>
		휴대전화 : <input type="text" name="phone"><br>
		주소 : <input type="text" name="address"><br>
		취미 : <input type="text" name="hobby"><br>
		<input type="submit" value="등록"><br>
	</form>
</body>
</html>