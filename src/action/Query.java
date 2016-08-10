package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.affair.AffairHandle;

public class Query extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AffairHandle ah = new AffairHandle();
		List<String> list1 = ah.getYears();
		List<String> list2 = new ArrayList<String>();
		list2.add("全部");
		list2.add("春季学期");
		list2.add("秋季学期");
		
		req.setAttribute("yearList", list1);
		req.setAttribute("monthList", list2);
		req.getRequestDispatcher("query_time.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
