<%@ page import="java.nio.file.Path"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zh" class="no-js">

<head>
<meta charset="utf-8">
<title>后台登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginAdmin.do"
		method="post">
		<input type="text" name="userName" placeholder="Username"
			autocomplete="off" /> <input type="password" name="password"
			placeholder="Password" oncontextmenu="return false"
			onpaste="return false" />
		<button id="submit" type="submit">Sign in</button>
	</form>
</body>
</html>