<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
    <head>
   		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="event.create" method="post" name="eventCreateForm" onsubmit="return eventCreateCheck();" enctype="multipart/form-data">
            <input type="hidden" name="token" value="${token}">
            <input type="hidden" name="eventUser" value="${sessionScope.loginUser.userLevel}">
            <div>
                <table>
                    <tr>
                        <td> <input type="text" class="input" name="eventTitle" autofocus placeholder="이벤트 타이틀" maxlength="45"></td>
                    </tr>
                    <tr>
                        <td> <input type="textarea" class="input" name="eventContent" placeholder="이벤트 내용"></td>
                    </tr>
                    <tr>
                        <td> <input type="file" id="eventThumbnailInput" name="eventThumbnail" placeholder="이벤트 썸네일"></td>
                    </tr>
                    <tr>
                        <td> <input type="text" class="input" name="eventLink" placeholder="이벤트 링크"></td>
                    </tr>
                    <tr>
                        <td> <button type="submit" id="button1" onclick="eventCreate();" value="전송"></button> </td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
