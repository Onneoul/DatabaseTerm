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
                    <hr>
                    <div>
                        <div>${userDetail.name}</div>
                    </div>
                    <hr>
                    <div>
                        <div>${userDetail.email}</div>
                    </div>
                    <c:if test="${loginUser.id } == ${userDetail.id }">
                    	<button onclick="toUserUpdate(${userDetail.code});" value="수정">수정</button>
                    </c:if>
                </div>
                <hr>
                <div id="userTechArea">
                    <c:forEach var="UT" items="${userDetail.userTechs }">
	                    <div class="userTechTags">${UT.techName }: 
	                    	<c:choose>
	                    		<c:when test="${UT.level == 1 }">레벨 1</c:when>
	                    		<c:when test="${UT.level == 2 }">레벨 2</c:when>
	                    		<c:when test="${UT.level == 3 }">레벨 3</c:when>
	                    	</c:choose>
	                    </div>
                    </c:forEach>
                </div>
            </div>
            <div id="githubProfile" align="left">
            	<div><a href="${userDetail.githubLink }">${userDetail.githubLink }</a></div>
				<hr>
               	<c:forEach var="UP" items="${userDetail.projects }">
               	<div onclick="location.href='project.detail?projectCode=${UP.code}'">
               		<div>
               			${UP.title }
						<c:choose>
							<c:when test="${UP.code == 1}">진행중</c:when>
							<c:when test="${UP.code == 2}">완료</c:when>
							<c:when test="${UP.code == 3}">중단</c:when>
						</c:choose>
					</div>
               	</div>
               	<hr>
               	</c:forEach>
            </div> 
        </div>
    </body>
</html>