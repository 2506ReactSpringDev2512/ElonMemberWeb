<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 전체 출력</h1>
	<table>
		<thead>
			<tr>
				<th>회원 이름</th>
				<th>회원 성별</th>
				<th>회원 나이</th>
				<th>회원 취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mList }" var="member">
			<tr>
				<td>${member.memberName }</td>
				<td>${member.gender }</td>
				<td>${member.age }</td>
				<td>${member.hobby }</td>
			</tr>			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>