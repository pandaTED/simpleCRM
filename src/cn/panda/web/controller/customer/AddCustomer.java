package cn.panda.web.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.Customer.Customer;
import cn.panda.service.BusinessService;
import cn.panda.service.impl.BusinessServiceImpl;
import cn.panda.utils.Globals;
import cn.panda.utils.WebUtils;

@WebServlet("/addCustomer")
public class AddCustomer extends HttpServlet {

	// 给用户提供一个添加界面
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("genders", Globals.genders);
		request.setAttribute("types", Globals.types);
		System.out.println("执行了");
		// 跳转到视图
		request.getRequestDispatcher("/WEB-INF/jsp/customer/addcustomer.jsp").forward(
				request, response);
	}

	// 处理用户的添加请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 表单校验
			// 把表单封装到customer对象中
			Customer c = WebUtils.request2bean(request, Customer.class);
			BusinessService service = new BusinessServiceImpl();
			String userId = (String) request.getSession().getAttribute("userId");
			service.addCustomer(c,userId);
			request.setAttribute("message", "添加成功！");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
