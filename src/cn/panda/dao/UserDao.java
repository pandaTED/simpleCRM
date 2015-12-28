package cn.panda.dao;

import java.util.List;

import cn.panda.domain.User.User;

public interface UserDao {
	//增删改查
	//增 //注册用户
	void addUser(User user);
	//删 //删除用户
	 void deleteUser(String id);
	//改 //修改密码   //用户名不能修改
	 void updateUser(User user);
	//查 //验证密码
	 User findUser(String id);
	//列出所有用户，方便管理员管理
	List<User> listUser();
	//验证用户名和密码
	 User login(String loginName,String password);
	 //查  //注册时登录名去重
	User findUserByLoginName(String loginName);
}	
