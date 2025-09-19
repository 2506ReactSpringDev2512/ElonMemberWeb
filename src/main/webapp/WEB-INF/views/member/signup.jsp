<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<h1>회원가입</h1>
	<form action="/member/signup" method="post">
		아이디 : <input type="text" name="memberId"> <br>
		비밀번호 : <input type="password" name="memberPwd"> <br>
		이름 : <input type="text" name="memberName"> <br>
		성별 : 남<input type="radio" name="gender" value="M"> 
				여 <input type="radio" name="gender" value="F"> <br>
		나이 : <input type="text" name="age"> <br>
		이메일 : <input type="text" name="email"> <br>
		전화번호 : <input type="text" name="phone"> <br>
<!-- 		<input type="text" name="address"> -->
		주소 : <input type="text" id="postcode" placeholder="우편번호"> 
				<button type="button" onclick="openPostCode();">우편번호 찾기</button> <br>
				<input type="text" id="roadAddress" placeholder="도로명주소"> 
				<input type="text" id="detailAddress" placeholder="상세 주소"> <br>
		취미 : <input type="text" name="hobby"> <br>
		<input type="submit" value="가입">
	</form>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function openPostCode() {
			new daum.Postcode({
				oncomplete: function(data) {
					document.querySelector("#postcode").value = data.zonecode;
					document.querySelector("#roadAddress").value = data.roadAddress;
				}
			}).open();
		}
	</script>
</body>
</html>