<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page language="java" import="org.apache.shiro.SecurityUtils"%>
<%@ page language="java" import="com.ssm.dao.ShiroUserDaoMapper"%>
<%@ page language="java" import="org.apache.shiro.subject.Subject"%>
<%@ page import="java.util.Set" %>
<html>
<head>
<title>后台登录成功</title>
</head>
<body>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
	ShiroUserDaoMapper shiroUserDaoMapper=null;
	Subject currentUser = SecurityUtils.getSubject();
	Object name =currentUser.getPrincipal();
	//这里查询产品吗？
	if(name!=null){
		Set<String> permissions = shiroUserDaoMapper.findPermissions( (String) name );
	}

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
</body>
</html>
