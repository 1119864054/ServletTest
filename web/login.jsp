<%--
  Created by IntelliJ IDEA.
  User: ZhouXiaoyu
  Date: 2018/5/16
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
    <input type="text" name="uname"><br>
    <input type="password" name="upwd"><br>
    <input type="submit" name="submit">
    <input type="reset" name="reset">
</form>
<a href="reg/register.jsp">注册</a>
</body>
</html>
