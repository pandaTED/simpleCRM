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

@WebServlet("/updateCustomer")
public class UpdateCustomer extends HttpServlet {

	// 获取要修改的客户信息
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("genders", Globals.genders);
		request.setAttribute("types", Globals.types);

		String id = request.getParameter("id");
		BusinessService service = new BusinessServiceImpl();
		Customer customer = service.findCustomer(id);
		// 把查询到的客户封装到page域中
		request.setAttribute("customer", customer);
		// 跳转到视图
		request.getRequestDispatcher("/WEB-INF/jsp/customer/updatecustomer.jsp")
				.forward(request, response);

	}

	// 处理用户的更新请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 把表单封装到customer对象中
			request.setCharacterEncoding("utf-8");
			Customer customer = WebUtils.request2bean(request, Customer.class);
			// c.setId(WebUtils.generateID());
			BusinessService service = new BusinessServiceImpl();
			service.updateCustomer(customer);
			request.setAttribute("message", "修改成功！");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "修改失败！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
