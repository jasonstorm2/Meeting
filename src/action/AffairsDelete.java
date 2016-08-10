package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;

import table.affair.Affair;
import table.affair.AffairHandle;
import table.comment.CommentHandle;
import table.sort.Sort;
import table.sort.SortHandle;

public class AffairsDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int affairId = Integer.parseInt(req.getParameter("affairId"));
		boolean re = new AffairHandle().delete(affairId);	//内容删除
		boolean comRe = new CommentHandle().delete(affairId);//评论删除		
		
		Integer sortId = Integer.valueOf(req.getParameter("sortId"));//为了方便显示，必须获得id
		SortHandle sh = new SortHandle();
		Sort sort = sh.getSortInfo(sortId);
		String sortName = sort.getName();
		AffairHandle ah = new AffairHandle();
		List<Affair> list = ah.affairsList(sortId);		
		
		if(re && comRe){
			ah.reSorting(affairId);//重新排序
			req.setAttribute("affairList", list);
			req.setAttribute("sortName", sortName);
			req.getRequestDispatcher("affairs_list_maintain.jsp").forward(req, resp);
		}else{
			req.setAttribute("re", "修改记录失败");
			req.getRequestDispatcher("result.jsp").forward(req, resp);
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
