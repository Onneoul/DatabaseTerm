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
							<td><a href=""></a></td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</table>
			</div>
			<table id="siteContent">
				<tr>
					<td align="center"><jsp:include page="project/insert.jsp"></jsp:include></td>
				</tr>
			</table>
			<div class="SideBar">
					RightSide<br>
					<table class="menu">
						<tr>
							<td><a href="유저 로그인"></a>로그인</td>
						</tr>
						<tr>
							<td onclick="toProjectInsert()">프로젝트 작성</td>
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