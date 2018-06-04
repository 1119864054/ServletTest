<%--
  Created by IntelliJ IDEA.
  User: ZhouXiaoyu
  Date: 2018/5/18
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="/RegisterServlet" method="post">
    用户名：<input type="text" name="userName"><br>
    密  码：<input type="text" name="password"><br>
    邮  箱：<input type="text" name="email"><br>
    <input type="submit" value="complete">
    <input type="reset" value="reset">
</form>
</body>
</html>
