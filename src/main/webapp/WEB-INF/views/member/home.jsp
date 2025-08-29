<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로그램</title>
</head>
<body>
	<c:forEach items="${mList }" var="member">
	<h1>${member.memberName } 님 환영합니다.</h1>
	</c:forEach>
	<ul>
		<c:forEach items="${mList }" var="member">
		<li><a href="/member/delete?memberId=${member.memberId}">1. 회원 정보 삭제</a></li>
		<li><a href="/member/update?memberId=${member.memberId}">2. 회원 정보 수정</a></li>
		</c:forEach>
		<li><a href="/">3. 로그아웃</a></li>		
	</ul>
</body>
</html>