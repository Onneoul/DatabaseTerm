<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>${projectDetail.title }프로젝트</title>
	</head>
	<body>
		프로젝트 디테일
		<div id="projectDetailArea">
			<div>
				${projectDetail.title }
			</div>
			<div>
				${projectDetail.content }
			</div>
			<div>
				${projectDetail.title }
			</div>
		</div>
	</body>
</html>