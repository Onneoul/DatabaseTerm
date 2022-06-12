<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="project.update" method="post" name="projectCreateForm" onsubmit="return projectCreateCheck();">
            <div id="projectCreateArea">
                <input type="text" name="leader" value="${sessionScope.loginUser.code }">
                <div id="projectTitle">
                	<input type="text" class="projectInput" name="title" autofocus value="${projectDetail.title }">
                </div>
                <div id="projectContent">
                	<input type="text" id="contentInputBox" name="content" value="${projectDetail.content }">
                </div>
                <div id="projectLink">
                	<input type="text" class="projectInput" name="githubLink" value="${projectDetail.githubLink }">
                </div>
                <div id="projectLevel">
                	<select name="level">
                		<option value="1" selected="selected">스터디</option>
                		<option value="2">포트폴리오</option>
                		<option value="3">서비스</option>
                	</select>
                </div>
                <div>
                	<button type="submit" class="SiteButton" onclick="projectCreate" value="전송"></button>
                </div>
            </div>
        </form>
	</body>
</html>