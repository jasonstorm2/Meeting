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
		String defCode = req.getCharacterEncoding();	//一开始为null,很多浏览器没有设置编码类型
		req.setCharacterEncoding("gb2312");				//设置编码类型，放置中文乱码
		String changeCode = req.getCharacterEncoding();
		Affair a = new Affair();
		AffairHandle ah = new AffairHandle();
		int num = ah.recordCount();


		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		int sortId = Integer.parseInt(req.getParameter("sort"));
		
		a.setTitle(title);
		a.setAffairId(++num);
		a.setContent(content);		
		a.setFbTime(System.currentTimeMillis());		
		a.setSortId(sortId);
		System.out.println("标题："+a.getTitle());

		System.out.println("内容："+a.getContent());
		
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
