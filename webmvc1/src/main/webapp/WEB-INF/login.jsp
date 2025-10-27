<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-24
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>

    <c:if test="${param.result == 'error'}">
        <h2> 로그인 에러</h2>
    </c:if>

<form action="/login" method ="post">
    <input type="text" name = "mid">
    <input type="password" name="mpw">
    <button type = "submit">로그인</button>
</form>


</body>
</html>
