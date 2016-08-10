package table.affair;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.sort.Sort;
import table.sort.SortHandle;

public class AffairsListMaintain extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer sortId = Integer.valueOf(req.getParameter("sortId"));
		SortHandle sh = new SortHandle();
		Sort sort = sh.getSortInfo(sortId);
		String sortName = sort.getName();
		AffairHandle ah = new AffairHandle();
		List<Affair> list = ah.affairsList(sortId);
		
		req.setAttribute("affairList", list);
		req.setAttribute("sortName", sortName);
		req.getRequestDispatcher("affairs_list_maintain.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
