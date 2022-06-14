<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Title</title>
	</head>
	<body>
	<p>프로젝트 리스트</p><br>
		<div id="projectListArea">
			<c:if test="${sessionScope.loginUser != null }">
				<button onclick="location.href='to.project.create'">프로젝트 작성</button>
			</c:if>
			<c:forEach var="pl" items="${projectList }">
				<div class="projectList" onclick="location.href='project.detail?projectCode=${pl.code}'">
					<div class="projectTitle">${pl.title }</div>
					<div class="projectStatus">
						<c:choose>
							<c:when test="${pl.status == 1}">
								진행중
							</c:when>
							<c:when test="${pl.status == 2}">
								종료
							</c:when>
							<c:when test="${pl.status == 3}">
								중지
							</c:when>
						</c:choose>
					</div>
					<div class="projectTechs">
						<c:forEach var="pt" items="${pl.techs }">
							${pt.techName }
						</c:forEach>
					</div>
				</div>
				<hr>
			</c:forEach>
			
		</div>
		<div class="Paging">
			<c:if test="${curPage != 1 }">
				<a id="pageL" href="project.page.change?page=${curPage - 1 }">이전페이지로</a>  
			</c:if>
		</div>
		<div class="Paging">
			<a class="PageNo" href="project.page.change?page=${curPage }">${curPage }Page</a>
			<c:if test="${curPage != pageCount }">
				<a id="pageR" href="project.page.change?page=${curPage + 1 }">다음페이지로</a>
			</c:if>			
		</div>
	</body>
</html>
