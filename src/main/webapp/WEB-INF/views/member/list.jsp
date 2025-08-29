<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 정보</title>
<style>
body { text-align: center; }
table { margin: 0 auto; border-collapse: collapse; }
</style>
</head>
<body>
	<h1>회원 전체정보</h1>
	<table>
		<colgroup>
			<col style="width: 10%;">
			<col style="width: 8%;">
			<col style="width: 6%;">
			<col style="width: 6%;">
			<col style="width: 20%;">
			<col style="width: 13%;">
			<col style="width: auto;">
			<col style="width: 11%;">
			<col style="width: 12%;">
		</colgroup>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입일</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mList }" var="member">
				<tr>
					<td>${member.memberId }</td>
					<td>${member.memberName }</td>
					<td>${member.gender }</td>
					<td>${member.age }</td>
					<td>${member.email }</td>
					<td>${member.phone }</td>
					<td>${member.address }</td>
					<td>${member.hobby }</td>
					<td>${member.enrollDate }</td>
					<td>
						<button onclick="location.href='/member/update?memberId=${member.memberId}'">수정</button> 
						<button onclick="if(confirm('${member.memberId}를 삭제하시겠습니까?')) location.href='/member/delete'">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>