<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Title</title>
        <link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/question.css">
        <script type="text/javascript" src="resources/js/question.js"></script>
        
	</head>
	<body>
	<div id="questionContainer">
		<div id="questionArea">
			<div id="questionDetailTitle">
				<div> ${questionDetail.title }</div>
			</div>
			<div id="buttonArea">
			<c:if test="${sessionScope.loginUser.code == questionDetail.writer}">
				<button onclick="location.href='to.question.update?questionCode=${questionDetail.code}';" id="updateButton">수정</button>
				<button onclick="toQuestionDelete(${questionDetail.code});" id=deleteButton>삭제</button><br>
			</c:if>
			</div>
			<div id="questionDetailContent">
				<div> ${questionDetail.content }</div>
			</div>
			<div id="questionDetailTechsArea">
				<c:forEach var="QT" items="${questionDetail.questionTechs }">
					<div class="techTags" onclick="toTechSearch(${QT.techCode})">${QT.techName } </div>
				</c:forEach>
			</div>
		</div>
		<div id="answerArea">
			<c:forEach var="AN" items="${questionDetail.answers }">
			<div class="answers">
				<div class="answerWriter">
					${AN.writer }
				</div>
				<div class="answerDate">
					${AN.date }
				</div>
				<div class="answerContent">
					${AN.content }
				</div>
				<div class="answerRecommend">
					${AN.recommendation }
				</div>
			</div>
			</c:forEach>
		</div>
		<div id="answerWriteArea">
			<c:if test="${sessionScope.loginUser != null }">
				<form action="answer.create" method="get" name="answerCreateForm">
					<div><input type="text" value="${loginUser.code }" name="writer">코드</div>
					<div><input type="text" value="${questionDetail.code }" name="questionCode"> </div>
					<div id="answerContent">
						<input type="text" placeholder="답변 내용" name="content">
					</div>
					<button class="SiteButton">작성하기</button>
				</form>
			</c:if>
		</div>
	</div>
	</body>
</html>
