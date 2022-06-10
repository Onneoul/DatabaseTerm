<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
    <head>
   		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="project.create" method="post" name="projectCreateForm" onsubmit="return projectCreateCheck();">
            <div>
                <table>
                    <tr>
                        <td> <input type="text" id="projectTitleInput" name="projectTitle" autofocus placeholder="프로젝트 타이틀"> 프로젝트 타이틀 </td>
                    </tr>
                    <tr>
                        <td> <input type="textarea" id="projectContentInput" name="projectContent" placeholder="프로젝트 내용"> 프로젝트 내용 </td>
                    </tr>
                    <tr>
                        <td> <input type="text" id="projectSubTitleInput" name="projectSubTitle" placeholder="프로젝트 부제"> 프로젝트 부제 </td>
                    </tr>
                    <tr>
                        <td> <input type="color" id="projectColorInput" name="projectColor"> 프로젝트 색깔 </td>
                    </tr>
                    <tr>
                        <td> <input type="submit"> 제출 </td>
                        <td> <button type="submit" id="button1" onclick="projectCreate" value="전송"></button> </td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>

submit 속성에 함께 쓸 수 있는 formenctype - 폼 데이터 해석 방식 = 확장자인가? 알아보고 적용 가능하면 적용하기
