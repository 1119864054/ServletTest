<%--
  Created by IntelliJ IDEA.
  User: ZhouXiaoyu
  Date: 2018/5/18
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MianPage</title>
</head>
<body>
首页
<br><br>
<a href="permission.jsp">权限查看</a>
<br><br>
<%
    String flag = "";
    Object obj = session.getAttribute("flag");

    if(obj != null){
        flag = obj.toString();
    }
    if(flag.equals("login_success")){
%>
<a href="<%=request.getContextPath()%>/LogoutServlet">退出</a>
<%
    }else {
%>
<a href="<%=request.getContextPath()%>/login.jsp">登录</a>
<%
    }
%>
</body>
</html>
