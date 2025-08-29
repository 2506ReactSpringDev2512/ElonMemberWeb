<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 정보 출력</title>
</head>
<body>
	<h1>회원 전체 정보</h1>
	<table>
		<colgroup>
			<col style="width: 10%;">
			<col style="width: 15%;">
			<col style="width: 10%;">
			<col style="width: 6%;">
			<col style="width: 10%;">
			<col style="width: 13%;">
			<col style="width: auto;">
			<col style="width: 10%;">
			<col style="width: 12%;">
		</colgroup>
		<thead>
			<tr>
				<th>회원 아이디</th>
				<th>회원 비밀번호</th>
				<th>회원 이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>등록날짜</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mList }" var="member">
				<tr>
					<td>${member.memberId }</td>
					<td>******</td>
					<td>${member.memberName }</td>
					<td>${member.gender }</td>
					<td>${member.age }</td>
					<td>${member.email }</td>
					<td>${member.phone }</td>
					<td>${member.address }</td>
					<td>${member.hobby }</td>
					<td>${member.enrollDate }</td>
					<td>
					<form action="/member/delete" method="post">
						<input type="hidden" name="memberId" value="${member.memberId }" >
						<input type="submit" value="삭제">
					</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href = "/">메인페이지로 이동</a>
</body>
</html>