<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: LiuXue
  Date: 2018/10/25
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
  <title>JSP基本语法</title>
</head>
<body>
<h1>
  1.jsp注释 :<%--jsp注释 --%>
</h1>
<%--JSP的注释格式 --%>

<h1>
  2.jsp声明：<%-- <%! 声明部分 %> --%>
</h1>
<%!
  // 声明一个整形变量
  public int count = 10;
  // 声明一个方法
  public int add(int count){
    return count++;
  }
%>
<% out.print(count++);%><br/>
<% out.print(add(count)); %>

<h1>
  3.jsp输出表达式  <%=1+2 %>
</h1>
<%=count %>
<%=add(count) %>

<h1>
  4.jsp小脚本
</h1>
<%
  for(int i = 0; i < 20; i++){
%>
<!-- 循环输出br标签10次 -->
<tr>
  <td>循环值：</td>
  <td><%=i %></td> <br/>
</tr>
<%
  }
%>
<h1>
    5.jsp错误界面的处理 errorPage=" .jsp"
    <%--<%= count/0%>--%>
</h1>

</body>
</html>

