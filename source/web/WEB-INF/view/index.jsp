<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> 메인페이지 </title>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main_login.css">


<script src="${pageContext.request.contextPath }/js/jquery-3.6.1.js"></script>
<!-- 전체공통 -->
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

html, button, input, select, textarea, span, a, p {
	font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/   dotum,
		sans-serif;
}
.productsflex{
	display: flex;
    flex-wrap: wrap;
}
.productsflex > div{
	width: 400px;
}
.wrap{
	width: 100%;
}
</style>
</head>
<body>
<div class="wrap">
	<div>
		<%@ include file="/WEB-INF/view/header.jsp"%>
	</div>
	
	<div class="productsflex">
<c:choose>
	<c:when test="${empty list }">
		   <h2>상품이 준비중입니다.</h2>
	</c:when>
	<c:otherwise>
		<c:forEach items="${list }" var="a">
		<div style="border: 1px solid skyblue; margin-right: 2px"; margin-left=2px; margin-top=2px;>
			<!-- private int pocket;
			private String goodsName;
			private int price;
			private String productimg; -->
			<form action="/pocket.do" method="post">
				<div class="b">${a.pocket }</div>
				<div class="b">월 ${a.price }원x12</div>
				<div class="b"><img src="${a.productimg }" width="200" height="200"></div>
				<div class="b">${a.goodsName }</div>
				<%-- TODO --%>
				<div class="b"><button type="submit" name ="product"><img src= "${pageContext.request.contextPath }/images/장바구니로고_hover.svg"></button></div>
			</form>
		</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
	</div>
</div>
	
</body>
</html>