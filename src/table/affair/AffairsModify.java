package table.affair;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.sort.SortHandle;

public class AffairsModify extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		Integer id = Integer.valueOf(req.getParameter("affairId"));
		AffairHandle ah = new AffairHandle();
		Affair af = ah.getAffairById(id);
		req.setAttribute("affair", af);
		req.setAttribute("sortList", new SortHandle().getSorts());
		req.getRequestDispatcher("Affairs_modify.jsp").forward(req, resp);		
		
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
