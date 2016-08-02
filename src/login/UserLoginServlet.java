package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserLoginServlet extends HttpServlet {

	public UserLoginServlet() {		
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log

	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)//登陆表单 post 传到 sevrlet对象
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
	
		UserHandle userHandle = new UserHandle();
		user = userHandle.userLogin(user);
		
		if(user!=null){
			request.setAttribute("user", user);
			request.getRequestDispatcher("left.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login_fail.jsp").forward(request, response);
		}
	}

	public void init() throws ServletException {
		
	}

}
