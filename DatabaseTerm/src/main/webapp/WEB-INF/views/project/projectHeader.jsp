<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
	
			<div id="projectContentPage">
				<jsp:include page="${detailBody }"></jsp:include>
			</div>
			<div id="tagArea">
				<c:forEach var="tech" items="${techs }">
					<div class="techTag">${techs.techName }</div>
				</c:forEach>
			</div>
			<div id="feedBackArea">
				<c:forEach var="feedBack" items="${feedBacks }">
					<div class="projectFeedback">${content }</div>
					<div class="projectFeedback">${writeDate }</div>
				</c:forEach>
			</div>
	</body>
</html>