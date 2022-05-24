<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="false" %>
<html>
	<head>
		이너페이지
	</head>
        <table>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <select size="3" id="projectLevel">
                        <option value="study">스터디</option>
                        <option value="potpol">포트폴리오</option>
                        <option value="service">서비스구축</option>
                    </select>
                </td>
            </tr>
        </table>
	<body>
	</body>
</html>

select / option 구문에서 option 항목들은 optgroup 태그를 통해 그룹으로 묶을 수 있다.
상위 기술을 optgroup으로 설정하면 option 들을 구분하기 쉽게 묶을 수 있을 듯