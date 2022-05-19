<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
	<head>
        <!--
            css파일이랑 js파일 전부 index에 넣으면 개별 파일에 넣을 필요가 없음
        -->
	</head>
	<body>
		<jsp:include page="${content }"></jsp:include>
        <!--
            좌우 사이드바를 넣고 jsp include로 home 넣기
            js location.href 명령으로 백엔드단에 요청 보내서 컨트롤러에서 처리하기
        -->
	</body>
</html>
