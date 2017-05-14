<%@ page import="org.apache.shiro.subject.Subject" %>
<%@ page import="org.apache.shiro.SecurityUtils" %><%--
  Created by IntelliJ IDEA.
  User: pengmin
  Date: 2017/5/14
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>后台登录成功</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    Subject currentUser = SecurityUtils.getSubject();
    String name =(String) currentUser.getPrincipal();
    //这里查询产品吗？

    String test="测试jsp ...";
    //ShiroUserEntity currentUser = (ShiroUserEntity) SecurityUtils.getSubject().getPrincipal();
    //String username=currentUser.getUserName(  );
    //int role=currentUser.getRoleId(  );
%>
<shiro:hasRole name="admin">
    这是admin角色登录：
</shiro:hasRole>

<shiro:hasRole name="teacher">
    这是teacher角色登录：
</shiro:hasRole>

<shiro:hasRole name="user">
    这是user角色登录：
</shiro:hasRole>

<shiro:hasPermission name="user:create">
    有user:create权限信息
</shiro:hasPermission>

<shiro:hasPermission name="user:look">
    有user:look权限信息
</shiro:hasPermission>

<shiro:hasPermission name="teacher:create">
    有teacher:create权限信息
</shiro:hasPermission>
<br> 登录成功
<hr></hr>
<h3>

    <%--UserName:<c:out value="${currentUser}"></c:out>
   RoleID:<c:out value="${role}"></c:out>--%>
    <p><%=currentUser %></p>
    ${shiroUser.userName}
    ${shiroUser.userName}
    <p><%=name %></p>
    <p><%=test%></p>
</h3>

<br>
<br>
<a href="${pageContext.request.contextPath}/student" target="_blank">学生用户可访问的页面</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/teacher" target="_blank">教师用户可访问的页面</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/admin" target="_blank">管理员可访问的页面</a>
<br>

</body>
</html>

