<%@ page language="java" import="java.util.*" import="table.affair.*" import="java.text.SimpleDateFormat"
	contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>事务详情</title>
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
					href="AffairDetail?affairId=<%=affair.getAffairId()%>">详情</a>]
				</div></td>
		</tr>
		<%
			}
		%>
	</table>
  </body>
</html>
