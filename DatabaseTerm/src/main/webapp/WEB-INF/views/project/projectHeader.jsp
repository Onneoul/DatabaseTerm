<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
        <script>
			function toFeedBackDelete(projectcode, feedBackcode) {
				var ok = confirm("정말 이 글을 삭제하시겠습니까?");
				if (ok) {
					location.href = "project.feedback.delete?projectCode="+ projectcode + "&feedBackCode=" + feedBackcode;
					alert("삭제되었습니다.");
				} else {
					alert("삭제를 취소하셨습니다.");
				}
			}
		</script>
	</head>
	<body>
		<div id="projectDetailContainer">
			<div>
			</div>
			<div id="projectContentPage">
				<jsp:include page="${detailBody }"></jsp:include>
			</div>
			<hr>
			<c:if test="${sessionScope.loginUser.code == projectDetail.leader}">
				<div id="offerArea">
					<c:forEach var="O" items="${projectDetail.offers }">
						<div><a href="user.detail.view?userCode=${O.userCode }">${O.userName }</a></div>
						<div>${O.comment }</div>
						<button onclick="location.href='project.join.accept?projectCode=${projectDetail.code }&offerNumber=${O.number}&userCode=${O.userCode }'">참가 수락</button>
						<button onclick="location.href='project.join.denied?projectCode=${projectDetail.code }&offerNumber=${O.number}&userCode=${O.userCode }'">참가 거절</button>
					</c:forEach>
				</div>
			<hr>
			</c:if>
			<p><strong>팀원 목록</strong></p>
			<c:forEach var="pm" items="${projectDetail.members }">
				<div onclick="location.href='user.detail.view?userCode=${pm.code}'">${pm.name }</div>
			</c:forEach>
			<hr>
			<c:if test="${sessionScope.loginUser != null && sessionScope.loginUser.code != projectDetail.code}">
				<div id="joinForm">
					<form action="project.join?projectCode=${projectDetail.code }" method="GET">
						<input type="text" name="projectCode" value="${projectDetail.code }">
						<input type="text" name="userCode" value="${sessionScope.loginUser.code }">
						<input type="text" name="comment" class="textInput" placeholder="Comment">
						<button>참가신청</button>
					</form>
				</div>
				<hr>
			</c:if>
			<div id="feedBackArea">
				<div id="feddBackWrite">
					<c:if test="${sessionScope.loginUser != null}">
						<form action="project.feedback.create" method="POST">
							<input type="hidden" name="projectCode" value="${projectDetail.code }">
							<input type="hidden" name="writer" value="${sessionScope.loginUser.code }">
							<input type="text" name="content" placeholder="코멘트 입력">
							<button>작성 완료</button>
						</form>
					<hr>
					</c:if>
				</div>
				<div id="feedBackList">
					<c:forEach var="feedBack" items="${projectDetail.feedbacks }">
						<div class="projectFeedbackWriter" onclick="toUserDetail(${feedBack.writer})">${feedBack.writerName } ${feedBack.writeDate }</div>
						<div class="projectFeedbackContent">${feedBack.content }</div>
						<c:if test="${sessionScope.loginUser.code == feedBack.writer }">
							<div onclick="toFeedBackDelete(${projectDetail.code }, ${feedBack.feedBackCode});" class="SiteButton">삭제</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</body>
</html>