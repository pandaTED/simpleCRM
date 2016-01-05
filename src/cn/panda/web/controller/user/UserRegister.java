package cn.panda.web.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panda.dao.UserDao;
import cn.panda.dao.impl.UserDaoImpl;
import cn.panda.domain.User.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/userRegister")
public class UserRegister extends HttpServlet{
	private static final long serialVersionUID = 1L;
	UserDao ud = new UserDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();	
		try{
		String loginName = request.getParameter("loginName");
		if(loginName!=null && !loginName.equals("")){
			User user = ud.findUserByLoginName(loginName);
			if(user==null){
				out.println("<font color='green'>"+loginName+" 没人使用，可以注册！</font>");
			}else{
				out.println("<font color='red'>"+loginName+" 已经被注册，再想一个吧！</font>");	
			}
			}else{
			out.println("<font color='blue'>登录名不能为空！</font>");	
		}
		
		}finally{
			out.close();
		}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		if((loginName !=null & !loginName.equals(""))&(password !=null & !password.equals(""))&(email !=null & !email.equals(""))){
			User user = ud.findUserByLoginName(loginName);
			if(user == null){
				user =new User();
				user.setLoginName(loginName);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
				ud.addUser(user);
				request.setAttribute("register_success","注册成功，现在你是我的了。" );
			}else{
				request.setAttribute("register_loginNameExist","登录名已存在，换一个呗~" );
			}
		}else{	
				request.setAttribute("register_null","注册的时候请认真一点，要不然，你怎么对得起我。");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/user/registermessage.jsp").forward(request, response);
		}
}
