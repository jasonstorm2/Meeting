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

<title>ѡ��Ҫά��������</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
<p>
<%
		//  	��ò���
		Sort sort = new Sort();
		List<Sort> list = (ArrayList<Sort>) request.getAttribute("sortList");
	%>
	<table border="0px" cellspacing="0" cellpadding="10" align="center"
		width="90%" gbColor="#arE8EF">
		<!-- 		table row,tr,���е��� -->
		<tr>

			<%
				// 			��ҳ��ı���ѭ����ӡ����һ��Ԫ��һ����table data td��Ԫ��
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
