<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: LiuXue
  Date: 2018/10/31
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String user = request.getParameter("user");
%>
<head>
    <title><%=user%>的个人信息</title>
</head>
<body>
    <%

        out.println(new Date());
        out.println("用户名：" + user);
    %>
</body>
</html>
