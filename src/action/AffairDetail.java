package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.affair.Affair;
import table.affair.AffairHandle;
import table.comment.CommentHandle;
import table.sort.SortHandle;

public class AffairDetail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer affairId = Integer.valueOf(req.getParameter("affairId"));
		Affair affair = new AffairHandle().getAffairById(affairId);		
		String sortName = new SortHandle().getSortInfo(affair.getSortId()).getName();
		
		req.setAttribute("affair", affair);
		req.setAttribute("sortName", sortName);
		req.setAttribute("commentList", new CommentHandle().getCommentByAffairId(affairId));		
		
		req.getRequestDispatcher("affair_detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
