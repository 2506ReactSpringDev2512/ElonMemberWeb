<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<h1>회원 정보 삭제</h1>
	<form action="/member/delete" method="post">
		삭제할 아이디 입력 : <input type="text" name="memberId">
		<input type="submit" value="삭제">
	</form>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>