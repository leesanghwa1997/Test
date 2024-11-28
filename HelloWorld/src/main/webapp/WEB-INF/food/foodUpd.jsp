<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 27.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h1>음식수정</h1>
<form action="/food/update?foodId=${dto.foodId}" method="post">
  <div>
    <input type="text" name="foodName" value="${dto.foodName}">
  </div>
  <div>
    <input type="text" name="foodDescription" value="${dto.foodDescription}">
  </div>
  <div>
    <input type="text" name="foodPrice" value="${dto.foodPrice}">
  </div>
  <div>
    <button type="submit">수정하기</button>
  </div>
</form>
<form action="/food/delete?foodId=${dto.foodId}" method="post">
  <button type="submit">삭제하기</button>
</form>
<a href="/food/list2">목록가기</a>
</body>
</html>
