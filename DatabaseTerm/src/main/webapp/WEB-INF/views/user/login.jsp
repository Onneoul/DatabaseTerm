<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
		<script type="text/javascript" src="resources/js/github.js"></script>
	</head>
	<body>
		<form action="user.login" method="post" id="userLogin" name="userLoginForm" onsubmit="return userLoginCheck();">
			<div>
				<div><input class="inputText" name="id" placeholder="아이디"></div><br>
				<div><input class="inputText" name="password" placeholder="비밀번호" autocomplete="name"></div><br>
				<div><button type="submit" id="button1" value="로그인">로그인</button></div>
				<p onclick="getToken();">GitHub 아이디로 로그인</p>
			</div>
		</form>
		<hr>
		<div><button id="toUserJoin" onclick="toUserJoin();" value="회원 가입">회원 가입</button></div>
	</body>
</html>