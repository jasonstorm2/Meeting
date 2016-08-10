package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.affair.Affair;
import table.affair.AffairHandle;

public class QueryTitle extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		String str2 = (String)req.getParameter("keyTitle");
		List<Affair> list = new AffairHandle().queryByTitle(str2);
		req.setAttribute("affairList", list);
		req.setAttribute("sortName", "您查询的结果如下");
		req.getRequestDispatcher("affairs_list_view.jsp").forward(req, resp);
	}
}
