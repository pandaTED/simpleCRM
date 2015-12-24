package cn.panda.dao;

import java.util.List;

import cn.panda.domain.Customer.Customer;
import cn.panda.domain.User.RequestResult;

public interface CustomerDao {

	public void add(Customer c,String userId);
	
	public void update(Customer c);

	public void delete(String id);

	public Customer find(String id);

	public RequestResult getResult(int startindex, int itemPerPageNum,String customer_user_id);
	
	public List<Customer> customers_user(String customer_user_id);

}