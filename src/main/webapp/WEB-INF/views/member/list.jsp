<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 정보</title>
</head>
<body>
	<h1>회원 전체 정보</h1>
	<table>
		<colgroup>
			<col style="width: 10%;">
			<col style="width: 8%;">
			<col style="width: 6%;">
			<col style="width: 6%;">
			<col style="width: 20%;">
			<col style="width: 13%;">
			<col style="width: auto;">
			<col style="width: 11%;">
			<col style="width: 12%;">
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
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mList }" var="member">
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
	<br><br><br>
	<a href="/">메인페이지로 이동</a>
</body>
</html>