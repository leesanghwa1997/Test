<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Food List</title>
</head>
<body>
<h1>전체조회</h1>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>음식이름: <a href="/food/read2?foodId=${dto.foodId}">${dto.foodName}</a> - 음식설명: ${dto.foodDescription} - 음식가격: ${dto.foodPrice}</li>
    </c:forEach>
</ul>
<h1>음식저장</h1>
<a href="/food/register2">음식 저장으로 이동</a>
</body>
</html>
