<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>simpleCRM-注册</title>
<script src="${pageContext.request.contextPath}/js/countdown.js"></script>  
<style type="text/css">
		body{
		background-color:#BBDEFB;
		}
	</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/message.css">
  </head>
  <body>
     <div class="myDiv">  
    <p> ${register_null}
   		${register_success}
    	${register_unkonw}
    	${register_loginNameExist}
    	</p>  
        <div id="countdown"></div>  
    </div>  
  </body>
</html>
