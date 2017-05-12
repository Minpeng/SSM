<%@ page import="java.nio.file.Path"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<title>后台登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
</head>

<body oncontextmenu="return false">
	<h1>Login</h1>
	<form action="${pageContext.request.contextPath }/loginAdmin"
		method="post">
		<div>
			<input type="text" name="userName" class="username"
				placeholder="Username" autocomplete="off" />
		</div>
		<div>
			<input type="password" name="password" class="password"
				placeholder="Password" oncontextmenu="return false"
				onpaste="return false" />
		</div>
		<button id="submit" type="submit">Sign in</button>
	</form>
	<h1> ${error}</h1>
</body>

</html>
