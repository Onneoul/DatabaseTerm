<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<table>
				<!--  
					<c:if test="${sessionScope.loginUser.userLevel} >= 1">
						<tr>
							<td onclick="updateEvent(${eventDetail.code}, '${eventDetail.title }', '${eventDetail.content }', '${eventDetail.link }', ${eventDetail.startDate }, ${eventDetail.endDate }, ${curPage });">수정</td>
							<td onclick="deleteEvent(${eventDetail.code});">삭제</td>
						</tr>
					</c:if>
				-->
				<tr>
					<td>
						${eventDetail.title }<hr>
					</td>
				</tr>
				<tr>
					<td>
						${eventDetail.startDate } ~ ${eventDetail.endDate }<hr>
					</td>
				</tr>
				<tr>
					<td>
						${eventDetail.content }<hr>
					</td>
				</tr>
				<tr>
					<td><a href="${eventDetail.link }">${eventDetail.link }</a><hr></td>
				</tr>
			</table>
			<div align="center">
				<a href="teammate.toEventUpdate?code=${eventDetail.code }"></a>
				<button onclick="toEventUpdate(${eventDetail.code});" class="SiteButton">수정</button>
				<button onclick="toEventDelete(${eventDetail.code});" class="SiteButton">삭제</button>
			</div>
		</div>
	</body>
</html>