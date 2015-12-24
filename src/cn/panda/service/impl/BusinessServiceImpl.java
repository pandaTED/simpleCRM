package cn.panda.service.impl;

import java.util.List;

import cn.panda.dao.CustomerDao;
import cn.panda.dao.impl.CustomerDaoImpl;
import cn.panda.domain.Customer.Customer;
import cn.panda.domain.User.PageBean;
import cn.panda.domain.User.RequestResult;
import cn.panda.domain.User.UserRequest;
import cn.panda.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

	CustomerDao dao = new CustomerDaoImpl();

	public void addCustomer(Customer c,String userId) {
		dao.add(c, userId);
	}

	public void updateCustomer(Customer c) {
		dao.update(c);
	}

	public void deleteCustomer(String id) {
		dao.delete(id);
	}

	public Customer findCustomer(String id) {
		return dao.find(id);
	}
	
	
	public List<Customer> findAllCustomer(String userId) {
		return dao.customers_user(userId);
	}

	@SuppressWarnings("unchecked")
	public PageBean getPageBean(UserRequest userRequest) {
		
		//调用dao获取页面数据
		RequestResult requestResult = dao.getResult(userRequest.getStartindex(), userRequest.getItemPerPageNum(), userRequest.getUserId());
		PageBean pageBean = new PageBean();
		pageBean.setItemPerPageNum(userRequest.getItemPerPageNum());  	//每页显示多少条
		pageBean.setItemNum(requestResult.getItemNum());				//总计多少条
		pageBean.setCustomerList(requestResult.getCustomerList());		//客户数据
		pageBean.setCurrentPage(userRequest.getCurrentPage());			//当前页
		
		return pageBean;
	}

}
