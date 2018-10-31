<%--
  Created by IntelliJ IDEA.
  User: LiuXue
  Date: 2018/10/29
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
    <%
        session = request.getSession();
        out.println(session.getAttribute("name") + "欢迎您！");
    %>
</body>
</html>
