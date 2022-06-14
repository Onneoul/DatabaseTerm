<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Title</title>
	</head>
	<body>
		<form action="user.update" method="post" name="userCreateForm" onsubmit="return userCreateCheck();">
            <div>
            	<div>
            		<input type="hidden" name="code" value="${userDetail.code }">
                    <input type="hidden" id="userIDInput" name="id" value="${userDetail.id}">
					<input type="text" id="userNameInput" name="name" value="${userDetail.name }"> 닉네임 <hr>
					<input type="hidden" id="userLink" name="githubLink" value="${userDetail.githubLink }">
                </div>
              		<input type="password" id="userPasswordInput" name="password" placeholder="비밀번호" value="${userDetail.password }"> 비밀번호 <hr>
                    <input type="text" id="userEMailInput" name="eMail" placeholder="이메일" value="${userDetail.email }"> EMail <hr>
                    <button type="submit" id="button1" value="전송">전송</button>
            </div>
        </form>
	</body>
</html>
