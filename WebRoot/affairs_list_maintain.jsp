<%@ page language="java" import="java.util.*" import="table.affair.*" import="java.text.SimpleDateFormat"
	contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<title>具体事务处理</title>
</head>

<body>
	<%
		String sortName = (String) request.getAttribute("sortName");
		List<Affair> list = (ArrayList<Affair>) request.getAttribute("affairList");
	%>
	<h1 align="center"><%=sortName%></h1>
	<table border="1px" cellspacing="0" cellpadding="10" align="center"
		width="90%">
		<tr bgcolor="#77A2E9">
			<td width="10%"><div align="center">事务编号</div></td>
			<td width="44%"><div align="center">事务标题</div></td>
			<td width="20%"><div align="center">发布时间</div></td>
			<td width="13%"><div align="center">编辑</div></td>
			<td width="13%"><div align="center">删除</div></td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
				Affair affair = (Affair) list.get(i);
				int num = i;
				num++;
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(affair.getFbTime());
				String str;
				str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar.getTime());
		%>
		<tr>
			<td><div align="center"><%=num%></div></td>
			<td><div align="center"><%=affair.getTitle()%></div></td>
			<td><div align="center"><%=str%></div></td>

			<td><div align="center">
					<img src="pic/delete.gif" width="30" height="30" />[<a 
					href="AffairsModify?affairId=<%=affair.getAffairId()%>">编辑</a>]
				</div></td>

			<td><div align="center">
					<img src="pic/modify.gif" width="18" height="18" />[<a
						onclick="return window.confirm('删除事务评论也将全部删除，您确定删除吗？');"
						href="AffairsDelete?affairId=<%=affair.getAffairId()%>&sortId=<%=affair.getSortId()%>">删除</a>]
				</div></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
