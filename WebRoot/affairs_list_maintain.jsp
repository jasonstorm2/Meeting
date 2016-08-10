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
<title>����������</title>
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
			<td width="10%"><div align="center">������</div></td>
			<td width="44%"><div align="center">�������</div></td>
			<td width="20%"><div align="center">����ʱ��</div></td>
			<td width="13%"><div align="center">�༭</div></td>
			<td width="13%"><div align="center">ɾ��</div></td>
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
					href="AffairsModify?affairId=<%=affair.getAffairId()%>">�༭</a>]
				</div></td>

			<td><div align="center">
					<img src="pic/modify.gif" width="18" height="18" />[<a
						onclick="return window.confirm('ɾ����������Ҳ��ȫ��ɾ������ȷ��ɾ����');"
						href="AffairsDelete?affairId=<%=affair.getAffairId()%>&sortId=<%=affair.getSortId()%>">ɾ��</a>]
				</div></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
