<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Title</title>
	</head>
	<body>
		<form action="question.create" name="questionCreateForm" id="questionCreateForm" method="post" >
			<div><input type="text" name="writer" value="${sessionScope.loginUser.code }"></div>
			<div><input type="text" class="questionInput" name="title" placeholder="질문 제목"> </div>
			<div><input type="text" class="questionInput" name="content" placeholder="질문 내용"> </div>
			<button>작성 완료</button>
		</form>
	</body>
</html>
