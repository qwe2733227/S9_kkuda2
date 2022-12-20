<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main_share_section.css">
    <script src="${pageContext.request.contextPath }/js/jquery-3.6.1.js"></script>
    <script src="${pageContext.request.contextPath }/js/main_share_scroll_action.js"></script>
    <script src="${pageContext.request.contextPath }/js/main_header.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">

    <title>로그인 - 컬리</title>
    <style>
        #section {
            width: 100%;
        }
        html{
            scroll-behavior: smooth;
        }
    </style>
    <!-- 전체공통 -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
        html, button, input, select, textarea, span, a, p {
            font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/dotum, sans-serif;
        }
    </style>
</head>
<body>
	<form action="./login.do" method="post">
		<div class="input_area">
			<input type="text" id="input_ID" name="id" placeholder="아이디를 입력해주세요">
			<input type="password" id="input_PW" name="passwd"
				placeholder="비밀번호를 입력해주세요">
		</div>
		<div id="search_user_account">
			<a href="#">아이디 찾기</a> <span></span> <a href="#">비밀번호 찾기</a>
		</div>
		<div id="submit_area">
			<button type="submit" id="login_btn">
				<span>로그인</span>
			</button>
			<button type="button" id="join_btn"
				onclick="location.href='./join.html'">
				<span>회원가입</span>
			</button>
		</div>
	</form>
</body>
</html>