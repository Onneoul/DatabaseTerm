<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Title</title>
	</head>
	<body>
		<div>
			<div class="projectMenu">기획</div>
			<div class="projectMenu">Github Readme</div>
			<div class="projectMenu"></div>
			<div class="projectMenu"></div>
			<c:if test="">
				<div class="projectMenu">TODO List</div>
			</c:if>
			<br>
			<div id="projectContentPage">
				<jsp:include page="${projectContent }">
					
				</jsp:include>
			</div> <br>
			<div id="tagArea">
				<c:forEach var="tech" items="${techs }">
					<div class="techTag">${techs.techName }</div>
				</c:forEach>
			</div>
			<div id="">
				<c:forEach var="feedBack" items="${feedBacks }">
					<div class="projectFeedback">${ }</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>
