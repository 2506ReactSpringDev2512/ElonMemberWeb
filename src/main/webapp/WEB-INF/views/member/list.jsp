<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 정보</title>
</head>
<body>
	<h1>회원 전체정보</h1>
	<table>
		<colgroup>
			<col style="width: 10%;">
			<col style="width: 8%;">
			<col style="width: 6%;">
			<col style="width: 6%;">
			<col style="width: 14%;">
			<col style="width: 12%;">
			<col style="width: auto;">
			<col style="width: 11%;">
			<col style="width: 12%;">
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
				<%-- 버튼을 위한 '관리' 컬럼 헤더 추가 --%>
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
						<button>수정</button>
						<button>삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<%-- 테이블 하단 검색창 --%>
	<div id="search-box" style="text-align: center;">
		<form action="search.do" method="get">
			<select name="searchCondition">
				<option value="id">아이디</option>
				<option value="name">이름</option>
			</select>
			<input type="text" name="searchValue" placeholder="검색어를 입력하세요">
			<button type="submit">검색</button>
		</form>
	</div>
</body>
</html>