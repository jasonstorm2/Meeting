package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.affair.Affair;
import table.affair.AffairHandle;

public class QueryTime extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String year = (String)req.getParameter("year");
		String month = (String)req.getParameter("month");
		AffairHandle ah = new AffairHandle();
		List<Affair> list = ah.queryByTime(year, month);
		
		req.setAttribute("affairList", list);
		req.setAttribute("sortName", "您的查询结果如下");
		
		req.getRequestDispatcher("").forward(req, resp);
		
		
	}

}
