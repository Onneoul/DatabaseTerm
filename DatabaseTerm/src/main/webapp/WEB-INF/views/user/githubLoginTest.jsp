<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
        <script type="text/javascript" src="resources/js/github.js"></script>
	</head>
	<body onload="getAccessToken1(${githubToken});">
		깃허브 연동 성공<br>
		${githubToken }
		<div onclick="githubUser(token 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);">
			<p onclick="githubUser(token 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);">연결 테스트</p>
		</div>
	</body>
</html>