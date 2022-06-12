<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
        <!--
            css파일이랑 js파일 전부 index에 넣으면 개별 파일에 넣을 필요가 없음
        -->
		<link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/mainTest.css">
        <link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/user.css">
        <link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/question.css">
        <script type="text/javascript" src="resources/js/siteMove.js"></script>
        <script type="text/javascript" src="resources/js/user.js"></script>
        <script type="text/javascript" src="resources/js/event.js"></script>
        <script type="text/javascript" src="resources/js/project.js"></script>
        <script type="text/javascript" src="resources/js/question.js"></script>
        <script type="text/javascript" src="resources/js/github.js"></script>
	</head>
	<body>
		<div id="container">
			<div class="SideBar">
				<div id="LeftSideBar">
						왼쪽 탭<br>
						<div><a href="/find">홈으로</a></div>
						<div class="menu">
							<a href="project.view">프로젝트 조회</a>
							<div onclick="toEventList()">이벤트 리스트로</div>
							<div onclick="toQuestionList()">질문 리스트로</div>
						</div>
				</div>
			</div>
				<div id="siteContent">
					<div align="center"><jsp:include page="${content }"></jsp:include></div>
				</div>
			<div class="SideBar">
				<div id="RightSideBar">
						RightSide<br>
						<div class="menu">
								<div align="center"><jsp:include page="${loginPage }"></jsp:include></div>
						</div>
				</div>
			</div>
		</div>
        <!--
            좌우 사이드바를 넣고 jsp include로 home 넣기
            js location.href 명령으로 백엔드단에 요청 보내서 컨트롤러에서 처리하기
        -->
	</body>
</html>
