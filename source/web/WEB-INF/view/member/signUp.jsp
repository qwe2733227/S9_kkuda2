<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<!-- TODO: 여기에 필요한 css 넣기 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/signup.css">

<script src="${pageContext.request.contextPath }/js/jquery-3.6.1.js"></script>
<!-- TODO: 여기에 필요한 js 넣기 -->
<!-- 전체공통 -->
<style>
<title>SignUp</title>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

html, button, input, select, textarea, span, a, p {
	font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/ dotum,
		sans-serif;
}
</style>
</head>
<body>
	<div>
	<%@ include file="/WEB-INF/view/header.jsp" %>
		<div id="section">
			<div class="main_section">
<!-- TODO: 여기에 필요한 HTML -->
<h1 align="center">회원가입 창</h1>
	<hr>
	<form action="<%=request.getContextPath() %>/join.do" method="post">
		<div>
			<b class="name">UserID</b><br> <input class="text" type="text"
				name="id" placeholder="아이디"><br> <br>
		</div>
		<div>
			<b class="name">PW</b><br> <input class="text" type="password"
				name="passwd" placeholder="패스워드"><br> <br>
		</div>
		<div>
			<b class="name">이름</b><br> <input class="text" type="text"
				name="name" placeholder="이름"><br> <br> <br>
		</div>
		<div>
			<b class="tel">전화번호</b><br> <input class="tel" type="tel"
				name="tel" placeholder="000-0000-0000"><br> <br> <br>
		</div>
		<div>
			<b class="tel">생년월일</b><br> <input class="text" type="text"
				name="brithday" placeholder="생년월일6자리"><br> <br> <br>
		</div>
		<div>
			<input type="radio" name="gender" value="M">남
			<input type="radio" name="gender" value="W">여 
		</div>
		<div>
			<button class="sign_up" type="summit">회원가입</button>
		</div>
	</form>

			</div>
		</div>
	</div>
</body>
</html>
