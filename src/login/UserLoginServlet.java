package login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import table.affair.Affair;
import table.affair.AffairHandle;
import table.sort.Sort;
import table.sort.SortHandle;
import utils.util;


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
		String userName = util.getString(request.getParameter("userName"));
		String userPassword = util.getString(request.getParameter("userPassword"));
		
		//使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();
		//将数据存储到session中
		session.setAttribute("userName", userName);
		if(session.isNew()){
			System.out.println("这个session是新的！！！！");
		}else{
			System.out.println("已经创建过这个session啦。。。。。");
		}
		
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
	
		UserHandle userHandle = new UserHandle();
		user = userHandle.userLogin(user);
		
		if(user!=null){
			List<Affair> list = new AffairHandle().getAffairs();
			List<Sort> sortList = new SortHandle().getSorts();
			
			request.setAttribute("user", user);
			request.setAttribute("affairList", list);
			request.setAttribute("sortList", sortList);
			
			request.getRequestDispatcher("left.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login_fail.jsp").forward(request, response);
		}
	}

	public void init() throws ServletException {
		
	}

}
