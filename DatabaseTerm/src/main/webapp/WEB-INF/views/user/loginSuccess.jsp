<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
	</head>
	<body>
		<div>
			<div id="loginUserID">${sessionScope.loginUser.id }</div><br>
			<div id="loginUserName"><span>${sessionScope.loginUser.name }</span></div><br>
			<div onclick="logout();">로그아웃</div><br>
			<div>ForEach문으로 진행중인 프로젝트~</div><br>
		</div>
	</body>
</html>