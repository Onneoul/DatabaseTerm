<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
	</head>
	<body style="text-align=center">
		<div id="eventWrap">
			<div>
				<c:if test="${sessionScope.loginUser.userLevel} >= 1">
					<button onclick="toEventCreate();">작성</button><br>
				</c:if>
				<input type="hidden" name="eventUser" value="${sessionScope.loginUser.userLevel}">
				<button onclick="toEventCreate();">작성</button><br>
			</div>
			<p>공지 리스트</p><br>
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
	
			
			<c:forEach var="eS" items="${eS }">
				<table class="eventThumbnail" onclick="toEventDetail(${eS.code});">
					<tr class="eventViewTitle">
						<td>${eS.title}</td>
					</tr>
					<tr>
						<td>시작 일자: ${eS.startDate }</td>
						<td>종료 일자: ${eS.endDate }</td>
					</tr>
					<c:if test="${sessionScope.loginUser.userLevel} >= 2">
						<tr>
							<td onclick="toEventUpdate(${eS.code});">수정</td>
							<td onclick="toEventDelete(${eS.code});">삭제</td>
						</tr>
					</c:if>
				</table>
			</c:forEach>
			
			<div class="eventPaging">
				<c:if test="${curPage != 1 }">
					<a id="eventL" href="event.page.change?page=${curPage - 1 }">이전페이지로</a>
				</c:if>
			</div>
				<div class="eventPaging">
					<a class="eventPageNo" href="event.page.change?page=${curPage }">${curPage }Page</a>
				<c:if test="${curPage != pageCount }">
					<a id="eventR" href="event.page.change?page=${curPage + 1 }">다음페이지로</a>
				</c:if>			
			</div>
		</div>
	</body>
</html>