<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-23
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type = "text" value = "${dto.tno}" readonly> <br>
    <input type = "text" value = "${dto.title}" readonly><br>
    <input type = "date" value = "${dto.dueDate}" readonly><br>

    <a href="${pageContext.request.contextPath}/todo/modify?tno=${dto.tno}">
        <button type="button">수정/삭제</button>
    </a>
    <form action ="/todo/list" method="get">
        <button type="submit">목록 돌아가기</button>
    </form>

</body>
</html>
