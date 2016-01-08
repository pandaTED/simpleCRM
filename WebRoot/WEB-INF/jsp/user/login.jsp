<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>simpleCRM-登录</title>
	<script type="text/javascript">
			function go(){	
			window.location="${pageContext.request.contextPath}/userRegisterUI";
			}
	</script>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body>
	<div class="header">
	<h1 class="title">Simple CRM</h1>
	<h1 class="slogan">Driven by servlet</h1>
	</div>
	<div class="body">
	<form action="${pageContext.request.contextPath}/userLogin" method="post">
		<table>
			<tr>
				<td>登录名：</td>
				<td><input type="text" name="loginName" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><br></td>
				<td><br></td>
			</tr>
			<tr>
				<td ><input type="submit" value="登录"/></td>
				<td ><input type="button" onclick="go()" value="注册"/></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
