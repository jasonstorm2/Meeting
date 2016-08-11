package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.sort.Sort;
import table.sort.SortHandle;

public class SortListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//如果调用父类方法，super就会出错。。。。为什么呢？？？
		
		SortHandle handle = new SortHandle();
		List<Sort> list = handle.getSorts();
		req.setAttribute("sortList", list);
		req.getRequestDispatcher("Affairs_add.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);

	}

}
