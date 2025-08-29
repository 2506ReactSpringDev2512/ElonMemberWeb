<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원 검색</title>
</head>
<body>
	<h1>회원 정보 검색</h1>
	<form action="/member/search" method="post">
		아이디: <input type="text" name="memberId"> <input type="submit"
			value="검색">
	</form>

	<c:forEach items="${mList }" var="member">
	아이디: ${member.memberId } <br>
	이름: ${member.memberName } <br>
	이메일: ${member.email } <br>
	전화번호: ${member.phone } <br>
	주소: ${member.address } <br>
	</c:forEach>
</body>
</html>