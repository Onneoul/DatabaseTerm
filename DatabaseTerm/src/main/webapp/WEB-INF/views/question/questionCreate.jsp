<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
		<meta name="description" content="Tagify">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="viewport" content="width=device-width">
  		<meta name="author" content="Yair Even Or">
  		
		<title>Title</title>
		
		<style>
	    .tagifyinput{
	      display: block !important;
	      position: static !important;
	      transform: none !important;
	      width: 100%;
	      margin-top: 1em;
	      padding: .5em;
	    }
	  </style>
	  
	</head>
	<body>
		<form action="question.create" name="questionCreateForm" id="questionCreateForm" method="post" >
			<div><input type="hidden" name="writer" value="${sessionScope.loginUser.code }"></div>
			<div><input type="text" class="questionInput" name="title" placeholder="질문 제목"> </div>
			<div><input type="text" class="questionInput" name="content" placeholder="질문 내용"> </div>
			<div><input class="tagifyinput" name="tags" placeholder="java" value="java"></div>
			<button>작성 완료</button>
		</form>
	</body>
</html>
