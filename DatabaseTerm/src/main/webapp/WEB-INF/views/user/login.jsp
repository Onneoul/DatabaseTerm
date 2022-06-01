<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
	</head>
	<body>
		<form action="user.login" method="post" id="userLogin" name="userLoginForm" onsubmit="return userLoginCheck();">
			<div>
				<div><input class="input" name="userId" placeholder="아이디"></div>
				<div><input class="input" name="userpw" placeholder="비밀번호" autocomplete="name"></div>
				<div><button type="submit" id="button1" onclick="login();" value="로그인"></button></div>
			</div>	
		</form>
	</body>
</html>