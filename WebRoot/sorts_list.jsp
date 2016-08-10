<%@ page language="java" import="java.util.*" pageEncoding="GB2312"
	import="table.sort.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>选择要维护的事务</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
<p>
<%
		//  	获得参数
		Sort sort = new Sort();
		List<Sort> list = (ArrayList<Sort>) request.getAttribute("sortList");
	%>
	<table border="0px" cellspacing="0" cellpadding="10" align="center"
		width="90%" gbColor="#arE8EF">
		<!-- 		table row,tr,表中的行 -->
		<tr>

			<%
				// 			在页面的表中循环打印出来一个元素一个，table data td单元格
				for (int i = 0; i < list.size(); i++) {
					sort = (Sort) list.get(i);
			%>
			<td><a href="AffairsListMaintain?sortId=<%=sort.getSortId()%>"
					target="mainFrame"><%=sort.getName()%></a></td>
			<%
				}
			%>
		</tr>
	</table>	
	</p>
</body>
</html>
