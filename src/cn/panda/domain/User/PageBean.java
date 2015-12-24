package cn.panda.domain.User;

import java.util.List;

import cn.panda.domain.Customer.Customer;

public class PageBean {
	
	List customerList;				//要显示的用户信息
	private int itemNum; 			// 总计多少条数据
	private int itemPerPageNum; 	// 每页显示多少条
	private int pageNum; 			// 总计多少页
	private int currentPage; 		// 当前页数
	private int previousPage;		//这是计算出来的 		currentPage-1;
	private int	nextPage;			//这是计算出来的		currentPage+1;
	private int[] pagebar;			//页码数字		
	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public int getItemPerPageNum() {
		return itemPerPageNum;
	}
	public void setItemPerPageNum(int itemPerPageNum) {
		this.itemPerPageNum = itemPerPageNum;
	}
	public int getPageNum() {					//总页数是计算出来的
		
		if(this.itemNum%this.itemPerPageNum==0){
			this.pageNum=this.itemNum/this.itemPerPageNum;
		}else{
			this.pageNum=(this.itemNum/this.itemPerPageNum)+1;
		}
		return pageNum;
	}
	
	public int getCurrentPage() {				
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPreviousPage() {				//下一页的页码是计算出来的		
		if(this.currentPage<=1){
		this.previousPage=1;
		}else{
		this.previousPage=this.currentPage-1;
		}
		return previousPage;
	}

	public int getNextPage() {					//上一页的页码是计算出来的
		
		if(this.currentPage>=pageNum){
			this.nextPage=this.currentPage;
			}else{
			this.nextPage=this.currentPage+1;
			}
		return nextPage;
	}

	public int[] getPagebar() {
		
		//1,页数大于10时，显示startpage = this.currentPage-4  endpage=this.currentPage+5
		//	当前页数与最大页数相差不大于5时，startpage = this.pageNum-9 endpage = pageNum;
		//2,页数小于10时      startpage = 1; endpage = this.currentPage;
		/*int startpage=1;
		int endpage=pageNum ;
		
		if(pageNum<=10){
			startpage = 1;
			endpage =this.pageNum;
		}else if(pageNum>10){
			if(currentPage<=10){
				startpage = 1;
				endpage = 10;
			}else if(this.currentPage+5>=this.pageNum){
				startpage = this.pageNum-9;
				endpage = this.pageNum;
			}else{
				startpage = this.currentPage-4;
				endpage = this.currentPage+5;
			}
		}
		
		int pagebarlong = endpage-startpage+1;
		int[] pagebar = new int [pagebarlong];
		for(int i=0;i<pagebarlong;i++){
			pagebar[i]=startpage++;	
		}
		
		return pagebar;*/
		
		
		/*int[] pagebar = new int[pageNum];
		for(int i=1;i<=this.pageNum;i++){
			pagebar[i-1]= i;
		}
		this.pagebar = pagebar;
		return pagebar;*/
		
		int startpage;
		int endpage;
		int pagebar[] = null;
		if(this.pageNum<=10){
			pagebar = new int[this.pageNum];
			startpage = 1;
			endpage = this.pageNum;
		}else{
			pagebar = new int[10];
			startpage = this.currentPage - 4;
			endpage = this.currentPage + 5;
			
			//总页数=30      3    -1
			//总页数=30      29   34   21   30
			if(startpage<1){
				startpage = 1;
				endpage = 10;
			}
			
			if(endpage>this.pageNum){
				endpage = this.pageNum;
				startpage = this.pageNum - 9;
			}
		}
		
		int index = 0;
		for(int i=startpage;i<=endpage;i++){
			pagebar[index++] = i;
		}
		
		this.pagebar = pagebar;
		return this.pagebar;
		
		
		
	}

	
	
	
	
}
