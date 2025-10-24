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
    <title>Todo Register Page </title>
</head>
<body>
<form action="/todo/modify" method="post">

    <input type="text" name="tno" value="${dto.tno}"/> <br>
    <input type="text"   name="title" value="${dto.title}" /> <br>
    <input type="date"   name="date"  value="${dto.dueDate}" /> <br>
    <button type="submit">Modify</button>
</form>


<form action="/todo/remove" method="post">
    <input type="hidden" name="tno" value="${dto.tno}" />
    <button type = "submit">Remove</button>
</form>
</body>
</html>
