package table.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import table.affair.Affair;
import table.affair.AffairHandle;

public class CommentAdd extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CommentHandle ch = new CommentHandle();
		Comment cm = new Comment();
		req.setCharacterEncoding("gb2312");
		
		Integer affairId = Integer.valueOf(req.getParameter("affairId").trim());
		HttpSession session = req.getSession();
		//将数据存储到session中
		String userName = (String) session.getAttribute("userName");
		
		String sortName = req.getParameter("sortName");
		String content = req.getParameter("content");
		
		cm.setCommentId(ch.recordCount());
		cm.setContent(content);
		cm.setAuthor(userName);
		cm.setAffairId(affairId);
		
		Affair affair = new AffairHandle().getAffairById(affairId);	
		
		if(ch.save(cm)){
			
			req.setAttribute("affair", affair);
			req.setAttribute("sortName", sortName);
			req.setAttribute("commentList", new CommentHandle().getCommentByAffairId(affairId));
			req.getRequestDispatcher("affair_detail.jsp").forward(req, resp);
		}else{
			req.setAttribute("re", "添加记录失败");			
			req.getRequestDispatcher("result.jsp").forward(req, resp);
		}		
		
	}

}
