<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
    <head>
   		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    	<div id="eventCreateFromArea">
	        <form action="event.create" method="post" name="eventCreateForm" onsubmit="return eventCreateCheck();">
	            <input type="hidden" name="token" value="${token}">
	            <input type="hidden" name="code" value="${code }">
	            <div>
	                <table style="text-align: center">
	                    <tr>
	                        <td> <input type="text" class="input" name="title" autofocus placeholder="이벤트 타이틀" maxlength="45"></td>
	                    </tr>
	                    <tr>
	                        <td> <input type="textarea" class="input" name="content" placeholder="이벤트 내용"></td>
	                    </tr>
	                    <tr>
	                        <td> <input type="text" class="input" name="link" placeholder="이벤트 링크"></td>
	                    </tr>
	                    <tr>
	                    	<td><input type="date" class="dateInput" name="startDate" value="${now }"></td>
	                    	<td><input type="date" class="dateInput" name="endDate"></td>
	                    </tr>
	                    <tr>
	                        <td> <button type="submit" id="button1" onclick="eventCreate();" value="전송">작성</button> </td>
	                    </tr>
	                </table>
	            </div>
	        </form>
	    </div>
    </body>
</html>

