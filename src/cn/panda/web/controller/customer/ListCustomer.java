package cn.panda.web.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.domain.User.PageBean;
import cn.panda.domain.User.UserRequest;
import cn.panda.service.BusinessService;
import cn.panda.service.impl.BusinessServiceImpl;
import cn.panda.utils.WebUtils;

//处理分页请求
@WebServlet("/listCustomer")
public class ListCustomer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserRequest userRequest = WebUtils.request2bean(request,
					UserRequest.class);
			String userId = (String) request.getSession().getAttribute("userId");
			userRequest.setUserId(userId);
			BusinessService service = new BusinessServiceImpl();
			PageBean pageBean = service.getPageBean(userRequest);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher(
					"/WEB-INF/jsp/customer/listcustomer.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "查看客户失败");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
