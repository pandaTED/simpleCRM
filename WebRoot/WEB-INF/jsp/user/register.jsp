<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>simpleCRM-注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body style="background-color:#B2DFDB;text-align: center;">
	<div id="body"
		style="margin-left: auto;margin-right: auto;max-width: 960px;min-height: 99%;">
		<br />
		<h1 style="color: ;font-size: 60px;font-family:Microsoft YaHei;">Simple
			CRM</h1>
		<h1 style="color: ;font-size: 20px;font-family:Microsoft YaHei;">Driven
			by servlet</h1>
		<br />
		<h1 style="color: ;font-size: 30px;font-family:Microsoft YaHei;">注册</h1>
		<br /> <br />
		<form action="${pageContext.request.contextPath}/userRegister" method="post">
			<table
				style="font-family:Microsoft YaHei;font-size: 25px;text-align: center;margin: auto;">
				<tr>
					<td style="color: #212121;">登录名：</td>
					<td><input type="text" name="loginName" "/></td>
				</tr>
				<tr>
				<tr>
					<td style="color: #212121;">密码：</td>
					<td><input type="password" name="password"  /></td>
				</tr>
				<tr>
					<td style="color: #212121;">姓名：</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td style="color: #212121;">电子邮件：</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="确认" /></td>
					<td><input type="reset" value="重填" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
