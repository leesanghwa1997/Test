<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 20.
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login/result" method="post">
    <h1>미니 실습 로그인</h1>
    <label>ID:<input type="text" name="id"></label>
    <label>Password:<input type="text" name="password"></label>
    <button type="submit">로그인</button>
</form>
</body>
</html>
