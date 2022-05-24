<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home</title>
		<!-- <link rel="stylesheet" type="text/css" href="../../resource/css/main.css"> -->
		<link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/main.css">
	</head>
	<body>
		<div id="wrap">
			<div class="SideBar">
				왼쪽 탭<br>
				<table class="menu">
					<tr>
						<td><a href="/Project/select.jsp" target="_parent">프로젝트 조회</a></td>
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
			<div id="Content">
				가운데
				<iframe id="innerPage" src="../project/select.jsp" width="100%" height="100%">
				<!-- <a href="" target="_parent" or "_top" 
					parent는 링크 내용을 부모 프레임에 표시
					top은 프레임에서 벗어나 링크 내용을 전체 화면에 표시
				-->
				</iframe> 
			</div>
			<div class="SideBar">
				RightSide<br>
				<table class="menu">
					<tr>
						<td>로그인</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
