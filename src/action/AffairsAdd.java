package action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.affair.Affair;
import table.affair.AffairHandle;

public class AffairsAdd extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 		//post to database
		req.setCharacterEncoding("gb2312");				//设置编码类型，放置中文乱码		
		Affair a = new Affair();
		AffairHandle ah = new AffairHandle();
		int sortId = Integer.parseInt(req.getParameter("sort"));

		String title = req.getParameter("title");
		String content = req.getParameter("content");		
		int affairId = ah.recordCount() +1;		
		
		a.setTitle(title);
		a.setAffairId(affairId);
		a.setContent(content);		
		a.setFbTime(System.currentTimeMillis());		
		a.setSortId(sortId);

		
		if(ah.save(a)){
			req.setAttribute("re","添加记录成功");
		}else{
			req.setAttribute("re", "添加记录失败");
		}
		req.getRequestDispatcher("result.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

}
