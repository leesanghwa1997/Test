<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 27.
  Time: 오후 4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인화면</title>
</head>
<body>
<h1>회원정보</h1>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>이름: <a href="/member/info?member_num=${dto.member_num}">${dto.member_name}</a> - 아이디: ${dto.member_id} - 가입일: ${dto.created_at}</li>
    </c:forEach>
</ul>
</body>
</html>
