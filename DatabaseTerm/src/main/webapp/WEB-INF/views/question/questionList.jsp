<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
	</head>
	<body style="text-align=center">
		<div id="eventWrap">
		<c:if test="${sessionScope.loginUser != null }">
			<div>
				<button onclick="toQuestionCreate();">작성</button>
			</div>
		</c:if>
			<p>질문 리스트</p>
			<hr>
			<!-- 
				<form action="event.search" method="get">
					<table>
						<tr>
							<td><input type="date" name="eventStartDate" placeholder="시작 일자"> ~ </td>
							<td><input type="date" name="eventEndDate" placeholder="종료 일자"></td>
							<td><input type="text" name="eventSearch" placeholder="검색어 입력"></td>
						</tr>
					</table>
				</form>
			 -->
	
			
			<c:forEach var="QL" items="${questionList }">
				<div class="eventThumbnail" onclick="toQuestionDetail(${QL.code});">
					<div id="questionViewTitle">제목:  ${QL.title} </div>
					<div> 작성일: ${QL.reportDate } 작성자 : ${QL.writerName } </div>
					<div id="questionTechArea">
						<c:forEach var="techs" items="${QL.questionTechs }">
							<div class="tag">${techs.techName }</div>
						</c:forEach>
					</div>
				</div>
				<hr>
			</c:forEach>
			
			<div class="Paging">
				<c:if test="${curPage != 1 }">
					<a id="pageL" href="question.page.change?page=${curPage - 1 }">이전페이지로</a>  
				</c:if>
			</div>
				<div class="Paging">
					<a class="PageNo" href="question.page.change?page=${curPage }">${curPage }Page</a>
				<c:if test="${curPage != pageCount }">
					<a id="pageR" href="question.page.change?page=${curPage + 1 }">다음페이지로</a>
				</c:if>			
			</div>
		</div>
	</body>
</html>