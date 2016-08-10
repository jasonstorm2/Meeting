package table.affair;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.sort.Sort;
import table.sort.SortHandle;

public class AffairsMaintain extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ������ø��෽����super�ͻ����������Ϊʲô�أ�����
		SortHandle handle = new SortHandle();
		List<Sort> list = handle.getSorts();
		req.setAttribute("sortList", list);
		req.getRequestDispatcher("sorts_list.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
