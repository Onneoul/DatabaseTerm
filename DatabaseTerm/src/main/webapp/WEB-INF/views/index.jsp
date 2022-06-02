<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
	<head>
        <!--
            css파일이랑 js파일 전부 index에 넣으면 개별 파일에 넣을 필요가 없음
        -->
		<link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/main.css">
        <link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/user.css">
        <script type="text/javascript" src="resources/js/siteMove.js"></script>
        <script type="text/javascript" src="resources/js/user.js"></script>
        <script type="text/javascript" src="resources/js/event.js"></script>
        <script type="text/javascript" src="resources/js/project.js"></script>
	</head>
	<body>
		<div id="wrap">
			<div class="SideBar">
					왼쪽 탭<br>
					<table class="menu">
						<tr>
							<td onclick="toProjectView()">프로젝트 조회</td>
						</tr>
						<tr>
							<td><a href="">프로젝트 검색</a></td>
						</tr>
						<tr>
							<td onclick="toEventList()">이벤트 리스트로</td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</table>
			</div>
				<div id="siteContent">
					<table>
						<tr><td align="center"><jsp:include page="home.jsp"></jsp:include></td></tr>
					</table>>
				</div>
			<div class="SideBar">
					RightSide<br>
					<table class="menu">
						<tr>
							<td align="center"><jsp:include page="${loginCheck }"></jsp:include></td>
						</tr>
					</table>
			</div>
		</div>
        <!--
            좌우 사이드바를 넣고 jsp include로 home 넣기
            js location.href 명령으로 백엔드단에 요청 보내서 컨트롤러에서 처리하기
        -->
	</body>
</html>
