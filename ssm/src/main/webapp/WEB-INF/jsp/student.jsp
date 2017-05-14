<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="org.apache.shiro.subject.Subject" %><%--
  Created by IntelliJ IDEA.
  User: pengmin
  Date: 2017/5/14
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Subject currentUser = SecurityUtils.getSubject();
    String name =(String) currentUser.getPrincipal();
%>
<html>
<head>
    <title>学生页面</title>
</head>
<body>
<br>
这是学生页面
<br>
当前用户是：<%=name %>
</body>
</html>
