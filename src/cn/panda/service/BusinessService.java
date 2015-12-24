package cn.panda.service;

import cn.panda.domain.Customer.Customer;
import cn.panda.domain.User.PageBean;
import cn.panda.domain.User.UserRequest;

public interface BusinessService {

	void addCustomer(Customer c,String userId);

	void updateCustomer(Customer c);

	void deleteCustomer(String id);

	Customer findCustomer(String id);

	PageBean getPageBean(UserRequest userRequest);

}