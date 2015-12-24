package cn.panda.web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.dao.UserDao;
import cn.panda.dao.impl.UserDaoImpl;
import cn.panda.domain.User.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao ud = new UserDaoImpl();
		
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		
		if((loginName !=null & !loginName.equals("")) & (password !=null & !password.equals(""))){
			User user = ud.login(loginName, password);
		if(user!=null){
			request.getSession().setAttribute("userId", user.getId());
			request.setAttribute("userName", user.getName());
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}else{
			request.setAttribute("login_user_null", "你输入的登录名或者密码不正确，具体哪个不正确，那就不知道了。");	
			request.getRequestDispatcher("/WEB-INF/jsp/user/loginmessage.jsp").forward(request, response);	
		}
		}else{
			request.setAttribute("login_loginNameOrPassword_null", "喂喂喂，用户名或密码不能为空！");
			request.getRequestDispatcher("/WEB-INF/jsp/user/loginmessage.jsp").forward(request, response);	
		}
		
	}

}
