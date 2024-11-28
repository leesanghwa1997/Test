<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 27.
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h1>로그인 화면</h1>

<%--만약, 로그인시 예외가 발생하면, 서버에서, 키:result, 값: error 넘어온, 쿼리스트링으로 --%>
<%--화면에서, jstl 라이브러리 이용해서, 조건문으로, 만약 error가 넘어오면, --%>
<%--로그인인 잘못된 내용 표기하기.--%>
<c:if test="${param.result == 'error'}">
    <h1>로그인 실패</h1>
</c:if>

<form action="/memberLogin" method="post">
    <input type="text" name="member_id">
    <input type="text" name="member_password">
    <button type="submit">로그인</button>
</form>
<a href="/memberRegister">회원가입</a>
</body>
</html>
