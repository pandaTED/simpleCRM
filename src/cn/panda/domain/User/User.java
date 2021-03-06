package cn.panda.domain.User;

import java.util.Date;

/**
 * 用户应该具有属性
 * String id;					//id
 * String name;				//姓名
 * String loginName;		//登录名
 * String password;			//密码
 * String email;			//电子邮件
 * Date registerDate; 		//注册日期
 * @author panda	
 *
 */

public class User {
	
		private String id;					//id
		private String name;				//姓名
		private String loginName;		//登录名
		private String password;			//密码
		private String email;			//电子邮件
		private Date registerDate; 		//注册日期
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getRegisterDate() {
			return registerDate;
		}
		public void setRegisterDate(Date registerDate) {
			this.registerDate = registerDate;
		}
		
}
