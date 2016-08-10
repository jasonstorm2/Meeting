package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.affair.Affair;
import table.affair.AffairHandle;

public class AffairsUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		req.setCharacterEncoding("GB2312");
		Affair a = new Affair();
		AffairHandle ah = new AffairHandle();	
		int sortId = Integer.parseInt(req.getParameter("sortPart"));
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Integer affairId = Integer.valueOf(req.getParameter("affairId"));
		
		a.setAffairId(affairId.intValue());
		a.setTitle(title);
		a.setContent(content);
		a.setFbTime(System.currentTimeMillis());
		a.setSortId(sortId);

		if(ah.update(a)){
			req.setAttribute("re","修改记录成功");
		}else{
			req.setAttribute("re", "修改记录失败");
		}
		req.getRequestDispatcher("result.jsp").forward(req, resp);
		
	}

}
