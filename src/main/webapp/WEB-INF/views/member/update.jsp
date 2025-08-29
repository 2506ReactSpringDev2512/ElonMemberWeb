<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action = "/member/update" method = "get">
		아이디 입력 : <input type = "text" name = "memberId">
		<input type = "submit" value = "입력 ">
	</form>
	<c:if test="${noDataFound != null }">
		<h1>데이터가 존재하지 않습니다.</h1>
	</c:if>
	<c:if test="${member != null }">
		<form action = "/member/update" method="post">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type = "text" name = "memberId" value="${member.memberId }" readonly></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type = "text" name = "memberPw" value="${member.memberPw }"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type = "text" name = "email" value="${member.email }" ></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type = "text" name = "phone" value="${member.phone }"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type = "text" name = "address" value="${member.address }"></td>
					</tr>
					<tr>
						<th>취미</th>
						<td><input type = "text" name = "hobby" value="${member.hobby }"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type = "submit" value  ="수정"> 
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</c:if>
</body>
</html>