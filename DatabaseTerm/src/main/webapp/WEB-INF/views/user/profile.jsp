<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
    <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="profileMain">
            <div id="siteProfile">
                <div class="profile">
                    <div>
                        <div>${userDetail.id} 추천수</div>
                    </div>
                    <div>
                        <div>${userDetail.name}</div>
                    </div>
                    <div>
                        <div>${userDetail.email}</div>
                    </div>
                    <c:if test="${loginUser.id } == ${userDetail.id }">
                    	<button onclick="toUserUpdate(${userDetail.code});" value="수정">수정</button>
                    </c:if>
                </div>
                <div id="userTechArea">
                    <c:forEach var="UT" items="${userDetail.userTechs }">
                    	<div>
	                    	<div class="techTags">${UT.techName }: ${UT.level }</div>
                    	</div>
                    </c:forEach>
                </div>
            </div>
            <div id="githubProfile">
            	<div><a href="${userDetail.githubLink }">${userDetail.githubLink }</a></div><br>
               	<c:forEach var="UP" items="${userDetail.projects }">
               	<div onclick="toProjectDetail(${UP.code});">
               		<div>${UP.title } ${UP.status }<c:if test="${UP.status } == 1"> 진행중</c:if><c:if test="${UP.status } == 2"> 종료</c:if></div>
               	</div>
               	</c:forEach>
            </div> 
        </div>
    </body>
</html>