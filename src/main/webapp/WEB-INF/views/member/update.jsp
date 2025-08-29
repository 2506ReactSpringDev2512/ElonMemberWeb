<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
body { text-align: center; }
table { margin: 20px auto; }
td { padding: 10px; }
</style>
<!--input { text-align: left;}-->
</head>
<body>
	<h1>수정할 회원 아이디</h1>
	<form action="/member/update" method="get">
		아이디 입력 : <input type="text" name="memberId">
		<input type="submit" value="조회"> 
	</form>
	
	<c:if test="${member != null}">
		<h2>회원 정보 수정</h2>
		<form action="/member/update" method="post">
		<table>
            <tr><td>아이디 :</td><td><input type="text" name="memberId" value="${member.memberId}" readonly></td></tr>
            <tr><td>비밀번호 :</td><td><input type="password" name="memberPwd" value="${member.memberPwd}"></td></tr>
            <tr><td>이름 :</td><td><input type="text" name="memberName" value="${member.memberName}"></td></tr>
            <tr><td>성별 :</td><td>남<input type="radio" name="gender" value="M" ${member.gender == 'M' ? 'checked' : ''}> 여<input type="radio" name="gender" value="F" ${member.gender == 'F' ? 'checked' : ''}></td></tr>
            <tr><td>나이 :</td><td><input type="text" name="age" value="${member.age}"></td></tr>
            <tr><td>이메일 :</td><td><input type="text" name="email" value="${member.email}"></td></tr>
            <tr><td>전화번호 :</td><td><input type="text" name="phone" value="${member.phone}"></td></tr>
            <tr><td>주소 :</td><td><input type="text" name="address" value="${member.address}"></td></tr>
            <tr><td>취미 :</td><td><input type="text" name="hobby" value="${member.hobby}"></td></tr>
            
            <tr><td colspan="2"><input type="submit" value="수정"></td></tr>
         </table>
		</form>
	</c:if>
</body>
</html>