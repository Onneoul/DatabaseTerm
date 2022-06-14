<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/project.js"></script>
	</head>
	<body>
		<div id="projectDetailHeaderArea">
			<div id="projectCurrentTab">프로젝트 정보</div>
			<!-- <div id="projectTab">ReadMe</div> -->
			<div>
			<!--  
				<c:forEach var="member" items="${projectDetail.members }">
					<c:if test="${sessionScope.loginUser.code == member.code }">
						TODO List
					</c:if>
				</c:forEach>
			-->
			</div>
		</div>
		<hr>
		<div id="projectDetailArea">
			<div id="projectDetailTitle">
				${projectDetail.title }
			</div>
			<hr>
			<c:if test="${sessionScope.loginUser.code == projectDetail.leader}">
				<div id="projectButtonArea">
					<button onclick="location.href='to.project.update?projectCode=${projectDetail.code}';" id="updateButton">수정</button>
					<script>
						function toProjectDelete(code) {
							var ok = confirm("정말 이 글을 삭제하시겠습니까?");
							if (ok) {
								location.href = "project.delete?projectCode=" + code;
								alert("삭제되었습니다.");
							} else {
								alert("삭제를 취소하셨습니다.");
							}
						}
					</script>
					<button onclick="toProjectDelete(${projectDetail.code})" id="deleteButton">삭제</button>
					<hr>
				</div>
			</c:if>
			
			<div id="projectDetailContent">
				${projectDetail.content }
			</div>
			
			<div id="projectDetailTagArea">
				<c:forEach var="techs" items="${projectDetail.techs }">
					<div class="SiteTags">
						${techs.techName } 
					</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>