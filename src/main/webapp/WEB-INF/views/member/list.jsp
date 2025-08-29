<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체조회</title>
</head>
<body>
	<h1>회원 전체조회</h1>
	<table>
		<colgroup>
			<col style = "wigth: 10%;">
			<col style = "wigth: 10%;">
			<col style = "wigth: 8%;">
			<col style = "wigth: 8%;">
			<col style = "wigth: 15%;">
			<col style = "wigth: 13%;">
			<col style = "wigth: auto%;">
			<col style = "wigth: 20%;">
			<col style = "wigth: 15%;">
		</colgroup>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mList }" var = "member">
				<tr>
					<td>${member.memberId }</td>
					<td>${member.memberName }</td>
					<td>${member.gender }</td>
					<td>${member.age }</td>
					<td>${member.email }</td>
					<td>${member.phone }</td>
					<td>${member.address }</td>
					<td>${member.hobby }</td>
					<td>${member.enrollDate }</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
</body>
</html>