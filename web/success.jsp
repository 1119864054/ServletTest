<%--
  Created by IntelliJ IDEA.
  User: ZhouXiaoyu
  Date: 2018/5/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
登陆成功
用户名：<%=request.getParameter("uname")%>
密码：<%=request.getParameter("upwd")%>
<a href="index.jsp">返回主页</a>
</body>
</html>
