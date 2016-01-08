<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>simpleCRM-登录</title>
	<script src="${pageContext.request.contextPath}/js/countdown.js"></script>   
	
	<style type="text/css">
		body{
		background-color:#BBDEFB;
			}
	</style>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/message.css">
  </head>
  <body>

    <div class="myDiv">
    <p>${login_user_null}
    ${login_success}
    ${login_loginNameOrPassword_null }
    </p>  
    <div id="countdown"></div>  
    </div>
  </body>
</html>
