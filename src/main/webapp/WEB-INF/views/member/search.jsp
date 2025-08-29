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
	<h1>회원 검색</h1>
		<form action="/member/search" method="post">
			아이디 :<input type="text" name="memberId"><br>
			비밀번호 :<input type="text" name="memberPw"><br>
			<input type="submit" value="검색"><br>
		</form>
	<h2>검색 결과</h2>
	<table>
		<thead>
			<tr>
				<th>회원 이름</th>
				<th>회원 성별</th>
				<th>회원 나이</th>
				<th>이메일</th>
				<th>주소</th>
				<th>휴대전화</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${member }" var="m">
			<tr>
				<td>${m.memberName }</td>
				<td>${m.gender }</td>
				<td>${m.age }</td>
				<td>${m.email }</td>
				<td>${m.address }</td>
				<td>${m.phone }</td>
				<td>${m.hobby }</td>
			</tr>			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>