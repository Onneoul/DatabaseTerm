<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
    <head>
   		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    	<div id="eventCreateFromArea">
	        <form action="teammate.eventUpdate" method="post" name="eventUpdateForm" onsubmit="return eventCreateCheck();">
	            <input type="hidden" name="token" value="${token}">
	            <!-- <input type="hidden" name="code" value="${eventDetail.code }">  -->
	            <input type="text" name="code" value="${eventDetail.code }">
	            <div>
	                <table style="text-align: center">
	                    <tr>
	                        <td> <input type="text" class="inputTitle" name="title" autofocus value="${eventDetail.title }" maxlength="45"></td>
	                    </tr>
	                    <tr>
	                        <td> <input type="text" class="inputContent" name="content" value="${eventDetail.content }"></td>
	                    </tr>
	                    <tr>
	                        <td> <input type="text" class="input" name="link" value="${eventDetail.link }"></td>
	                    </tr>
	                    <tr>
	                    	<td><input type="date" class="dateInput" name="startDate" value="${eventDetail.startDate }"></td>
	                    	<td><input type="date" class="dateInput" name="endDate" value="${eventDetail.endDate }"></td>
	                    </tr>
	                    <tr>
	                        <td> <button type="submit" id="button1" value="전송">수정 완료</button> </td>
	                    </tr>
	                </table>
	            </div>
	        </form>
	    </div>
    </body>
</html>
