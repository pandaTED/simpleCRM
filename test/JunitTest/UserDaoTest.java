package JunitTest;

import java.util.List;

import org.junit.Test;

import cn.panda.dao.UserDao;
import cn.panda.dao.impl.UserDaoImpl;
import cn.panda.domain.User.User;

public class UserDaoTest {
	
	@Test
	public void UserDaoTest(){
		User user = new User();
		user.setName("黄000瓜");
		user.setLoginName("00000st");
		user.setPassword("1234511116");
		user.setEmail("east@gmail.com");
		
		UserDao ud = new UserDaoImpl();
		ud.addUser(user);
	}
	
	@Test
	public void UserDaoDelete(){
		UserDao ud = new UserDaoImpl();	
		ud.deleteUser("4ea7673f-2ee0-4500-8002-614e3406ab9d");	
	}
	
	@Test
	public void UserDaofind(){
		UserDao ud = new UserDaoImpl();	
		User user = ud.findUser("a7adbaeb-b46b-46ee-aa60-66e0d0ceff8f");
		System.out.println(user.getLoginName());
		System.out.println(user.getRegisterDate());
	}
	
	@Test
	public void UserDaolist(){
		UserDao ud = new UserDaoImpl();	
		List list = ud.listUser();
		for(int i=0;i<list.size();i++){
		User user = (User) list.get(i)	;
		System.out.println(user.getLoginName());	
		}
	}
	

}
