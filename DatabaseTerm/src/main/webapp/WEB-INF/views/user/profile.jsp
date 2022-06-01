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
                        <td>UserID</td>
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
                <table id="profile">
                    <tr>
                        <td onclick="seeUserProfile(userNumber);"> Github프로필 </td>
                        <td>ID</td>
                    </tr>
                    <tr colspan="2"> <!-- jsp로 반복문 써서 project 전부 뽑기 (DB에 저장되있어야겠지??) -->
                        <td>프로젝트1</td> <!-- onclick 메소드로 클릭시 해당 프로젝트 주소로 이동하기 -->
                        <td>프로젝트2</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>