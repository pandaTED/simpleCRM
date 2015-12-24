package cn.panda.domain.User;

import java.util.List;

public class RequestResult {
	
	List customerList;				//要显示的用户信息
	private int itemNum; 			// 总计多少条数据
	
	public List getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List customerList) {
		this.customerList = customerList;
	}
	
	public int getItemNum() {
		return itemNum;
	}
	
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	
}
