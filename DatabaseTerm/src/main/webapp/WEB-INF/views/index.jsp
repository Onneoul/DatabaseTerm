<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
	<head>
        <!--
            css파일이랑 js파일 전부 index에 넣으면 개별 파일에 넣을 필요가 없음
        -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainTest.css">
        <link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/user.css">
        <link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/question.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/project.css">
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/project.js"></script>
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tagify.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="//code.jquery.com/jquery.min.js"></script>
        <script src="jQuery.tagify.js"></script>
        
        
        <script src="https://unpkg.com/@yaireo/tagify"></script>
		<script src="https://unpkg.com/@yaireo/tagify/dist/tagify.polyfills.min.js"></script>
		<link href="https://unpkg.com/@yaireo/tagify/dist/tagify.css" rel="stylesheet" type="text/css" />
		
        
        <script type="text/javascript" src="resources/js/siteMove.js"></script>
        <script type="text/javascript" src="resources/js/user.js"></script>
        <script type="text/javascript" src="resources/js/event.js"></script>
        <script type="text/javascript" src="resources/js/project.js"></script>
        <script type="text/javascript" src="resources/js/question.js"></script>
        <script type="text/javascript" src="resources/js/github.js"></script>
        
        
	  
	</head>
	<body>
		<div id="container">
				<div id="LeftSideBar">
						<div><a href="/find">홈으로</a></div>
						<hr>
						<div class="menu">
							<a href="project.list">프로젝트 조회</a>
							<hr>
							<div onclick="toEventList()">이벤트 리스트로</div>
							<hr>
							<div onclick="toQuestionList()">질문 리스트로</div>
						</div>
				</div>
				<div id="siteContent">
					<div align="center"><jsp:include page="${content }"></jsp:include></div>
				</div>
				<div id="RightSideBar">
						<div class="menu">
								<div align="center"><jsp:include page="${loginPage }"></jsp:include></div>
						</div>
				</div>
		</div>
        <!--
            좌우 사이드바를 넣고 jsp include로 home 넣기
            js location.href 명령으로 백엔드단에 요청 보내서 컨트롤러에서 처리하기
        -->
	</body>
</html>
