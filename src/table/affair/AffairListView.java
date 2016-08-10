package table.affair;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.sort.Sort;
import table.sort.SortHandle;

public class AffairListView extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer sortId = Integer.valueOf(req.getParameter("sortId"));
		List<Affair> affairList = new AffairHandle().affairsList(sortId);		
		String sortName = new SortHandle().getSortInfo(sortId).getName();
		
		req.setAttribute("sortName",sortName);
		req.setAttribute("affairList", affairList);
		
		req.getRequestDispatcher("affairs_list_view.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
