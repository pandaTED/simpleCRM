package JunitTest;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.panda.dao.CustomerDao;
import cn.panda.dao.UserDao;
import cn.panda.dao.impl.CustomerDaoImpl;
import cn.panda.dao.impl.UserDaoImpl;
import cn.panda.domain.Customer.Customer;
import cn.panda.domain.User.RequestResult;
import cn.panda.domain.User.User;


public class CustomerDaoTest {
	
	CustomerDao cd = new CustomerDaoImpl();
	UserDao ud = new UserDaoImpl();
	User user = new User();
	Customer customer = new Customer();
	
	@Test
	public void Test1(){
		System.out.println(user.getName());
		customer.setName("西瓜111121");
		customer.setUser(user);
		customer.setBirthday(new Date());
		customer.setCellphone("387641121212100");
		customer.setDescription("大西1212瓜");
		customer.setEmail("wosc@gma1212il.com");
		customer.setGender("女");
		customer.setType("VIP");
		cd.add(customer, "99de99e9-de58-4a26-8b7d-b8e8bac6f97e");
	}
	
	@Test
	public void Test2(){
		cd.delete("248fad16-fbc7-4891-ae46-20f1a3f5dfaa");
		
		
	}
	@Test
	public void Test3(){
		
		customer = cd.find("7bdf472a-4178-4bf3-8667-438c75b68a88");

		System.out.println(customer.getCellphone());
		System.out.println(customer.getUser().getName());
		customer.setCellphone("18325485600");
		cd.update(customer);
		customer = cd.find("7bdf472a-4178-4bf3-8667-438c75b68a88");
		System.out.println(customer.getCellphone());
	}
	
	@Test
	public void Test4(){
		List<Customer> list = cd.customers_user("99de99e9-de58-4a26-8b7d-b8e8bac6f97e");
		for(int i =0;i<list.size();i++){
			customer = list.get(i);
			System.out.println(customer.getName());
	
		}
		
	}
	
	
	@Test
	public void Test5(){
		RequestResult list1 = cd.getResult(0, 5, "99de99e9-de58-4a26-8b7d-b8e8bac6f97e");
		System.out.println(list1.getItemNum());
		List list = list1.getCustomerList();
		
		for(int i =0;i<list.size();i++){
			customer = (Customer) list.get(i);
			System.out.println(customer.getName());
	
		}
		
	}
	
	
}
