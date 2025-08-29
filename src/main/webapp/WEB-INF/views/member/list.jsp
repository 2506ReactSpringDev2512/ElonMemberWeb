<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원 정보</title>
</head>
<body>
	<h1>회원 전체 정보 출력</h1>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mList }" var="member">
				<tr>
					<td>${member.memberId }</td>
					<td>${member.memberName }</td>
					<td>${member.email }</td>
					<td>${member.phone }</td>
					<td>${member.address }</td>
				</tr>

			</c:forEach>

		</tbody>
	</table>
</body>
</html>