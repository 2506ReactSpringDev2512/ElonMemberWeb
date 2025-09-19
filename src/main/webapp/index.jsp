<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로그램</title>
</head>
<body>
	<h1>회원관리 프로그램</h1>
	<c:if test="${memberId eq null }">
		<form action="/member/login" method="post">
			ID : <input type="text" name="memberId"> <br>
			PW : <input type="password" name="memberPwd"> <br>
			<input type="submit" value="로그인">
		</form>
		<a href="/member/signup">회원가입</a>
	</c:if>
	<c:if test="${sessionScope.memberId ne null }">
		<h3>${memberName }님 환영합니다. <a href="/member/logout">로그아웃</a></h3> 
		<ul>
			<li><a href="/member/signup">1. 회원가입</a></li>
			<c:if test="${memberId eq 'admin' }">
				<li><a href="/member/list">2. 회원 전체조회</a></li>
			</c:if>
			<li><a href="/member/search">3. 회원 검색(아이디)</a></li>
			<li><a href="/member/update">4. 회원 정보 수정</a></li>
			<li><a href="/member/delete">5. 회원 정보 삭제</a></li>
		</ul>
	</c:if>
</body>
</html>