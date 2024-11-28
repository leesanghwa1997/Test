<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 26.
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>음식추가하기</h1>
  <form action="/food/register2" method="post">
      <div>
          <input type="text" name="food_name" placeholder="음식이름">
      </div>
      <div>
          <input type="text" name="food_description" placeholder="음식설명">
      </div>
      <div>
          <input type="text" name="food_price" placeholder="음식가격">
      </div>
      <button type="reset">초기화</button>
      <button type="submit">등록</button>
  </form>
  </body>
</html>
