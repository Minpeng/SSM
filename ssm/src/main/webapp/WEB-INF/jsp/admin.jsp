<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page language="java" import="org.apache.shiro.SecurityUtils"%>
<%@ page language="java" import="com.ssm.entity.ShiroUserEntity"%>
<html>
<head>
<title>后台登录成功</title>
</head>
<body>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
	//Subject currentUser = SecurityUtils.getSubject();
	ShiroUserEntity currentUser = (ShiroUserEntity) SecurityUtils.getSubject().getPrincipal(); 
	String username=currentUser.getUserName(  );
	int role=currentUser.getRoleId(  );
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
	
  <%-- 	UserName:<c:out value="${username}"></c:out>
 	RoleID:<c:out value="${role}"></c:out> --%>
	</h3>
</body>
</html>
