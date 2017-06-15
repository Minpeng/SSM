<%@ page import="java.nio.file.Path"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zh">

<head>

	<meta charset="utf-8">
	<title>后台登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link href="../assets/css/login.css" rel="stylesheet"/>
</head>
<body>

<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>

			<form class="form" action="${pageContext.request.contextPath }/loginAdmin"
				  method="post">
				<input type="text" placeholder="Username" name="userName">
				<input type="password" placeholder="Password" name="password">
				<button type="submit" id="login-button">Login</button>
			</form>
		</div>

		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>
</body>
</html>