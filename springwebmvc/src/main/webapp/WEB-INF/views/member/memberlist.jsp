<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-28
  Time: 오후 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MemberList</title>
</head>
<body>

<ul>
    <c:forEach var="dto" items="${memberDTOList} ">
        <li>${dto}</li>
    </c:forEach>
</ul>
</body>
</html>
