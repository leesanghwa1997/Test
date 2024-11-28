<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>음식 정보</title>
</head>
<body>
<h1>${dto.foodName} 정보</h1>
<p>가격: ${dto.foodPrice}원</p>
<p>설명: ${dto.foodDescription}</p>
<div>
    <a href="/food/update?foodId=${dto.foodId}">수정/삭제</a>
</div>
</body>
</html>
