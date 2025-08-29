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
	<form action="/member/update" method="post">
		<table>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="memberId">
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="memberPwd">
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email">
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone">
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address">
				</tr>
				<tr>
					<th>취미</th>
					<td><input type="text" name="hobby">
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<br><br><br>
	<a href="/">메인페이지로 이동</a>
</body>
</html>