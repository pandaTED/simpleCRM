# simpleCRM
一个功能简单的客户关系管理系统。
本项目实例部署于阿里云ECS，地址如下：
[simpleCRM](http://101.200.146.66/simpleCRM)
##功能简介
	1.用户的注册与登录
	2.客户关系的录入，查看，修改
##技术实现
###用到的库
	1.数据源采用c3p0连接池，版本号0.9.5.1，需要mchange包，版本号0.2.10
	2.前台数据封装采用beanutils，版本号1.8.0，需要common-logging包
	3.需要jstl包
	4.数据库采用mysql，版本号5.1.7，需要数据库的jdbc驱动mysql-connector-java
###用到的技术
	1.本CRM用java写成，利用的技术主要是JSP与servlet
	2.利用servlet的filter功能，设置全局的request编码为utf-8
##部署时请注意
	请在c3p0-config.xml内设置自己的数据库信息
