<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색</title>
<style>
body { text-align: center; }
table { margin: 20px auto; border-collapse: collapse; border: 2px solid #333; }
th, td { padding: 10px; border: 1px solid #ccc; }
</style>
</head>
<body>
	<h1>회원 검색</h1>
	
	<form action="/member/search" method="post">
		검색할 아이디 입력 : <input type="text" name="memberId">
		<input type="submit" value="검색">
	</form>
	
	<c:if test="${member != null}">
		<h2>검색 결과</h2>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>연락처</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입일</th>
			</tr>
			<tr>
				<td>${member.memberId}</td>
				<td>${member.memberName}</td>
				<td>${member.gender}</td>
				<td>${member.age}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td>${member.address}</td>
				<td>${member.hobby}</td>
				<td>${member.enrollDate}</td>
			</tr>
		</table>
	</c:if>
</body>
</html>