<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
    <head>
   		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="user.join" method="post" name="userCreateForm" onsubmit="return userCreateCheck();">
            <div>
            	<div>
                    <input type="text" id="userIDInput" name="id" value="${loginGitId }">
					<input type="text" id="userNameInput" name="name" value="${loginGitName }" >
					<input type="text" id="userLink" name="githubLink" value="${loginGitLink }">
                </div>
                
              		<input type="text" id="userPasswordInput" name="password" placeholder="비밀번호"> 비밀번호 <br>
                    <input type="text" id="userEMailInput" name="eMail" placeholder="이메일"> EMail <br>
                  	
                    <button type="submit" id="button1" value="전송">전송</button>
                   
            </div>
        </form>
    </body>
</html>
