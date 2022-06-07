<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
    <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="profileMain">
            <div id="siteProfile">
                <table class="profile">
                    <tr>
                        <td>${ }</td>
                        <td>추천수</td>
                    </tr>
                    <tr>
                        <td>이메일주소</td>
                    </tr>
                    <tr>
                        <td>연락처</td>
                    </tr>
                    <tr>
                    	<td>스택</td>
                    </tr>
                </table>
            </div>
            <div id="githubProfile">
            	<div>${githubLink }</div><br>
                <div></div>
            </div>
        </div>
    </body>
</html>