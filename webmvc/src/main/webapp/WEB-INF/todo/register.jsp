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
      <form action="/todo/register" method="post">

          <input type = "text" name = "title" placeholder="제목 입력"><br>
          <input type="date" name = "date"><br>
          <button type = "reset">리셋</button>
          <button type="submit">글 등록 처리</button>
      </form>
</body>
</html>
