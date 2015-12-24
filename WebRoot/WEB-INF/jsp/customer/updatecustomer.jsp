<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>simpleCRM-修改客户信息</title>
<%@ include file="/head.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ShowCalendar.js"></script>
</head>
<body style="background-color:#BBDEFB;font-family:Microsoft YaHei;">
	<form id="form"
		action="${pageContext.request.contextPath}/updateCustomer"
		method="post">
		<table border="2" width="50%" align="center">
			<input type="hidden" name="id" value="${customer.id }">
			<tr>
				<td>客户姓名</td>
				<td><input type="text" name="name" value="${customer.name} " /></td>
			</tr>
			<tr>
				<td>客户性别</td>
				<td><c:forEach var="gender" items="${genders}">
						<input type="radio" name="gender" value="${gender}"
							${customer.gender==gender?'checked':'' }> ${gender }				
				</c:forEach></td>
			</tr>
			<tr>
				<td>客户生日</td>
				<td><input type="text" name="birthday"
					onClick="showCalendar(this.id)" id="birthday"
					value="${customer.birthday}"></td>
			</tr>
			<tr>
				<td>客户手机</td>
				<td><input type="text" name="cellphone"
					value="${customer.cellphone} " /></td>
			</tr>
			<tr>
				<td>电子邮箱</td>
				<td><input type="text" name="email" value="${customer.email}" /></td>
			</tr>
			<tr>
				<td>客户类别</td>
				<td><c:forEach var="type" items="${types}">
						<input type="radio" name="type" value="${type }"
							${customer.type==type?'checked':'' }>${type }
				</c:forEach></td>
			</tr>
			<tr>
				<td>客户备注</td>
				<td><textarea rows="5" cols="60" name="description"> ${customer.description}
			</textarea></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置" /></td>
				<td><input type="submit" value="修改客户" /></td>
			</tr>
		</table>
	</form>
</body>
</html>