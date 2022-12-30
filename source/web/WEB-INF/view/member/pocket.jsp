<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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

</head>
<body>
<div class="wrap">
	<div>
		<%@ include file="/WEB-INF/view/header.jsp"%>
	</div>
	
	<div class="productsflex">
<c:choose>
	<c:when test="${empty loginSsInfo }">
		   <h2>로그인을 해주세요.</h2>
	</c:when>
	<c:otherwise>
		<c:forEach items="${pocketlist }" var="c">
		<div style="border: 1px solid skyblue; margin-right: 2px"; margin-left=2px; margin-top=2px;>
			<!-- private int pocket;
			private String goodsName;
			private int price;
			private String productimg; -->
			<div class="b">${a.pocket }</div>
			<div class="b">월 ${a.price }원x12</div>
			<div class="b"><img src="${a.productimg }" width="200" height="200"></div>
			<div class="b">${a.goodsName }</div>
		</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
	</div>
</div>
</body>
</html>