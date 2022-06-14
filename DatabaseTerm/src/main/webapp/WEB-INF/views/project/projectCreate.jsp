 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
    <head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="viewport" content="width=device-width">
  		<meta name="author" content="Yair Even Or">
    </head>
    <body>
        <form action="project.create" method="post" name="projectCreateForm" onsubmit="return projectCreateCheck();">
            <div id="projectCreateArea">
                <input type="hidden" name="leader" value="${sessionScope.loginUser.code }">
                <div id="projectTitle">
                	<input type="text" class="projectInput" name="title" autofocus placeholder="프로젝트 타이틀" maxlength="50" >
                </div>
                <div id="projectContent">
               		<textarea id="projectContentInput" name="content">프로젝트 내용</textarea>
                </div>
                <div id="projectLink">
                	<input type="text" class="projectInput" name="githubLink" placeholder="깃허브 링크">
                </div>
                <div id="projectTag">
                	<input class="tagifyinput" name="tags" placeholder="java" value="java">
                </div>
                <div id="projectLevel">
                	<select name="level">
                		<option value="1" selected="selected">스터디</option>
                		<option value="2">포트폴리오</option>
                		<option value="3">서비스</option>
                	</select>
                </div>
                <div id="projectSubmit">
                	<button type="submit" class="SiteButton" onclick="projectCreate" value="전송">작성 완료</button>
                </div>
            </div>
        </form>
    </body>
</html>

