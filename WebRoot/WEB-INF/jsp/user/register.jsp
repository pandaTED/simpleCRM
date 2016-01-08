<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<title>simpleCRM-注册</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body>
	<div class="header">
	<h1 class="title">Simple CRM</h1>
	<h1 class="slogan">Driven by servlet</h1>
	</div>
	<div class="body">
		<div class="main" style="float:left;margin-left: 40%">
		<form action="${pageContext.request.contextPath}/userRegister" method="post">
			<table>
				<tr>
					<td>登录名：</td>
					<td><input id="loginName" type="text" name="loginName" onblur="hadLoginName(this.value)" /></td>
				</tr>

				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"  /></td>
					</tr>
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>电子邮件：</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="确认" /></td>
					<td><input type="reset" value="重填" /></td>
				</tr>
			</table>
		</form>
		</div>
		<div style="float: left;margin-top: 1%;margin-left: 2%">
		<span id = "loginNameExist" style="font-size: 10px;" ></span>
	</div>
	</div>
</body>
</html>
