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
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main_login.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/movie_content.css">
	
<!-- TODO: 여기에 필요한 css 넣기 -->
<script src="${pageContext.request.contextPath }/js/jquery-3.6.1.js"></script>

<!-- TODO: 여기에 필요한 js 넣기 -->
<!-- 전체공통 -->
<style>
<title>메인페이지</title>
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
			</div>
		</div>
	</div>
</body>
</html>