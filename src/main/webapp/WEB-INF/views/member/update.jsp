<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
</head>
<body>
	<c:forEach items="${mList }" var="member">
		<h1>${member.memberName } 님의 회원 정보 수정</h1>
	<form action="/member/update" method="post">
		<input type="hidden" name="memberId" value="${member.memberId}">
		수정할 비밀번호: <input type="password" name="memberPwd" placeholder="새 비밀번호 입력"> <br> 
		수정할 이메일: <input type="text" name="email" value="${member.email}"> <br> 
		수정할 전화번호: <input type="text" name="phone" value="${member.phone}"><br> 
		수정할 주소: <input type="text" name="address" value="${member.address}"> <br> 
		수정할 취미:<input type="text" name="hobby" value="${member.hobby}"> <br> 
		<input type="submit" value="수정">
	</form>
	</c:forEach>
</body>
</html>