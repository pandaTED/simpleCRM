package cn.panda.web.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.service.BusinessService;
import cn.panda.service.impl.BusinessServiceImpl;

@WebServlet("/deleteCustomer")
public class DeleteCustomer extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			BusinessService service = new BusinessServiceImpl();
			service.deleteCustomer(id);
			request.setAttribute("message", "删除成功！");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "删除失败！");
		}	
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
