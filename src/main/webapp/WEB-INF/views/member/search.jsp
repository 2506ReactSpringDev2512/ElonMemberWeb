<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디로 회원정보 검색</title>
</head>
<body>
	<h1>아이디로 회원정보 검색</h1>
	<form action="/member/search" method ="post">
		<input type = "text" name = "memberId">
		<input type = "submit" value = "검색">
	</form>
	<c:if test = "${member != null }">
		<table>
			<tr>
				<th>아이디</th>
				<td>${member.memberId }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${member.memberName }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<c:if test = "${member.gender eq 'M' }">
					남자
				</c:if>
				<c:if test = "${member.gender eq 'F' }">
					여자
				</c:if>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${member.age }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${member.email }</td>
			</tr>
		</table>
	</c:if>
	
</body>
</html>