<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="org.apache.shiro.subject.Subject" %>
<%--
  Created by IntelliJ IDEA.
  User: pengmin
  Date: 2017/5/14
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	Subject currentUser = SecurityUtils.getSubject();
	String name =(String) currentUser.getPrincipal();
%>
<html>
<head>
	<title>admin管理页面</title>
	<br>
	当前用户是：<%=name %>
</head>
<body>

</body>
</html>
