<%--
  Created by IntelliJ IDEA.
  User: LiuXue
  Date: 2018/10/27
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <!-- 输出错误信息 -->
    <%
        if (request.getAttribute("err") != null) {
            out.println(request.getAttribute("err"));
        }
        if (request.getAttribute("tip") != null) {
            out.println(request.getAttribute("tip"));
        }
    %>
    <span>
        <!-- 登录表单-->
        <form action="login" method="post">
            用户名:<input type="text" name="username"><br>
            密码:<input type="password" name="pass">
            <input type="submit" value="登录">
        </form>
    </span>
</body>
</html>
