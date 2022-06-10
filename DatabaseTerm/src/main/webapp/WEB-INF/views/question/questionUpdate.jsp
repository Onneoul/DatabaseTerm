<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Title</title>
	</head>
	<body>
		<div id="questionDetail">
			<form action="question.update" method="post" name="questionUpdateForm">
				<input type="hidden" name="token" value="${token }">
				<input type="text" name="code" value="${questionDetail.code }">
				<div><input type="text" id="inputTitle" name="title" autofocus="autofocus" value="${questionDetail.title }"></div>
				<div><input type="text" id="inputContent" name="content" value="${questionDetail.content }"> </div>
				<div>태그입력창</div>
				<div><button type="submit" id="button1" value="전송">수정 완료</button></div>
			</form>
		</div>
	</body>
</html>
