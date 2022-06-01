<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
    <head>
   		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="user.create" method="post" name="userCreateForm" onsubmit="return userCreateCheck();">
            <div>
                <table>
                    <tr>
                        <td> <input type="text" id="userIDInput" name="userID" autofocus placeholder="사용자 ID"> ID </td>
                    </tr>
                    <tr>
                        <td> <input type="textarea" id="userPasswordInput" name="userPassword" placeholder="비밀번호"> 비밀번호 </td>
                    </tr>
                    <tr>
                        <td> <input type="text" id="userEMailInput" name="userEMail" placeholder="이메일"> EMail </td>
                    </tr>
                    <tr>
                        <td> <input type="text" id="GithubIDInput" name="GithubID"> GithubID </td>
                    </tr>
                    <tr>
                        <td> <input type="submit"> 제출 </td>
                        <td> <button type="submit" id="button1" onclick="userJoin();" value="전송"></button> </td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
