<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header">
	<div class="h_first">
		<div class="h_f_1">
			<div>
				<c:choose>
					<c:when test="${empty loginSsInfo}">
						<a href="${pageContext.request.contextPath }/join">회원가입</a>
						<div>|</div>
						<a href="${pageContext.request.contextPath }/login">로그인</a>
						<div>|</div>
					</c:when>
					<c:otherwise>
						<a href="#">${loginSsInfo.name }</a>
						<div>|</div>
						<a href="${pageContext.request.contextPath }/logout.do">로그아웃</a>
						<div>|</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="h_f_2">
			<div id="main_logo"
				onclick="location.href='${pageContext.request.contextPath }/main';">
				<button type="button">꾸다</button>
			</div>
			<div id="search">
				<input type="text" placeholder="검색어를 입력해주세요.">
				<button type="button">
					<img
						src="${pageContext.request.contextPath }/images/search_logo.svg">
				</button>
			</div>
			<div id="buttons">
				<a href="${pageContext.request.contextPath }/pocket"><img src="${pageContext.request.contextPath }/images/장바구니로고_hover.svg"></a>
			</div>
		</div>
	</div>

</div>