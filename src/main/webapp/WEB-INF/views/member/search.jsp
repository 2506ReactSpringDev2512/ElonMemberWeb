<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 검색 페이지</title>
</head>
<body>
	<h1>회원 정보 검색</h1>
	<form action = "/member/search" method="post">
		검색할 회원 아이디 입력 : <input type = "text" name = "memberId">
		<input type = "submit" value = "검색">
	</form>
	
	<c:if test = "${member != null }">
		<table>
			<tbody>
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
						<c:if test="${member.gender eq 'M' }">
							남자 
						</c:if>
						<c:if test="${member.gender eq 'F' }">
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
				<tr>
					<th>전화번호</th>
					<td>${member.phone }</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${member.address }</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>${member.hobby }</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${member.enrollDate }</td>
				</tr>
				
			</tbody>
		</table>
	
	
	</c:if>
</body>
</html>