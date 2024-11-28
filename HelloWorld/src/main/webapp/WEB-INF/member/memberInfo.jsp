<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 27.
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 정보</title>
</head>
<body>
<h1>${dto.member_name}의 정보</h1>
<p>아이디: ${dto.member_id}</p>
<p>비밀번호: ${dto.member_password}</p>
<div>
    <a href="/member/update?member_num=${dto.member_num}">수정/삭제</a>
</div>
</body>
</html>
