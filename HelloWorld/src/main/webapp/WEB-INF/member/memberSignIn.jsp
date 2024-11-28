<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 27.
  Time: 오후 4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/memberRegister" method="post">
    <div>
        <input type="text" name="member_name" placeholder="이름">
    </div>
    <div>
        <input type="text" name="member_id" placeholder="아이디">
    </div>
    <div>
        <input type="text" name="member_password" placeholder="비밀번호">
    </div>
    <button type="submit">가입</button>
</form>
</body>
</html>
