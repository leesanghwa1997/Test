<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 27.
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 정보 수정</title>
</head>
<body>
<h1>회원 정보 수정</h1>
<form action="/member/update?member_num=${dto.member_num}" method="post">
    <div>
        <input type="text" name="member_name" value="${dto.member_name}">
    </div>
    <div>
        <input type="text" name="member_id" value="${dto.member_id}">
    </div>
    <div>
        <input type="text" name="member_password" value="${dto.member_password}">
    </div>
    <div>
        <button type="submit">수정하기</button>
    </div>
</form>
<form action="/member/delete?member_num=${dto.member_num}" method="post">
    <button type="submit">삭제하기</button>
</form>
<a href="/food/list">목록가기</a>
</body>
</body>
</html>
