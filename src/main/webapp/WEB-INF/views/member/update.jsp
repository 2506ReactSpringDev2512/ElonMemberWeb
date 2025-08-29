<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<form action="/member/update" method="get">
		아이디 입력 : <input type="text" name="memberId"> 
		<input type="submit" value="입력"> <br>
	</form>
	<c:if test= "${member != null }">
	<form action="/member/update" method="post">
		<table>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="memberId" value="${member.memberId }" readonly>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="memberPwd" value="${member.memberPwd }">
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="memberName" value="${member.memberName }">
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${member.email }">
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" value="${member.phone }">
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" value="${member.address }">
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정" value="${member.memberId }">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</c:if>
	<a href = "/">메인페이지로 이동</a>
</body>
</html>