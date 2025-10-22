<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-22
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입 결과</title>
</head>
<body>
<c:choose>
  <c:when test="${not empty user_id}">
    <h2>${fn:escapeXml(user_id)}님 회원가입 성공하셨습니다.</h2>
  </c:when>
  <c:otherwise>
    <h2>회원가입 실패</h2>
  </c:otherwise>
</c:choose>

<p><a href="<c:url value='/register'/>">메인으로</a></p>
</body>
</html>


