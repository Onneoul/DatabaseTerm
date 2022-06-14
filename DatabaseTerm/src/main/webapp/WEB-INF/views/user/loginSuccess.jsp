<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
	</head>
	<body>
		<div>
			<div id="loginUserID"><a href="user.detail.view?userCode=${sessionScope.loginUser.code}">${sessionScope.loginUser.id }</a></div>
			<hr>
			<div id="loginUserName"><a href="user.detail.view?userCode=${sessionScope.loginUser.code}">${sessionScope.loginUser.name }</a></div>
			<hr>
			<div id="Result"><span>${result }</span></div>
			<div onclick="logout();">로그아웃</div>
			<div>
				<c:forEach var="PP" items="${sessionScope.loginUser.projects }"></c:forEach>
			</div><br>
		</div>
	</body>
</html>