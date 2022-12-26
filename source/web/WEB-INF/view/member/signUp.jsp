<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href=".../css/signup.css">
<title>SignUp</title>
</head>
<body>
	<h1 align="center">회원가입 창</h1>
	<hr>
	<div>
		<b class="name">UserID</b><br> <input class="text" type="text"
			name="UserID" placeholder="아이디"><br>
		<br>
	</div>
	<div>
		<b class="name">PW</b><br> <input class="text" type="password"
			name="PW" placeholder="패스워드"><br>
		<br>
	</div>
	<div>
		<b class="name">PW 확인</b><br> <input class="text" type="password"
			name="PW" placeholder="패스워드확인"><br>
		<br>
	</div>
	<div>
		<b class="name">email</b><br> <input class="text" type="email"
			name="email" placeholder="E-mail"><br>
		<br>
		<br>
	</div>
	<div>
		<input type="checkbox"> email 수신 동의
	</div>
	<div>
		<button class="sign_up" type="button">Sign up</button>
	</div>
</body>
</html>