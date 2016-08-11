<%@ page language="java" 
import="java.util.*" 
import="table.affair.*" 
import="java.text.SimpleDateFormat"
import="table.sort.*"
	contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�༶����</title>
</head>


<style type="text/css">
div#header {background-color:#99bbbb;}
div#container{width:1500px}
div#menu {height:200px;width:150px;float:left;}
div#content {width:1000px;float:left;}
h1 {background-color:#359FF3 margin-bottom:10;font-size:40px;}
</style>
<!-- ͨ�������� �����������,�����пո�
-->
<body>
<div id="header"><h1 align="center">��ӭ��������11����ӻ�����</h1></div>
<div id="container">
<div id="menu">
	<table width="169" height="300" >
	<tr> <td height="100"><div align="center">�༶�������
	<%List<Sort> sortList = (ArrayList<Sort>) request.getAttribute("sortList");

	for(int i=0;i < sortList.size(); i++){
	  int sortId = sortList.get(i).getSortId();
	  String sortName = sortList.get(i).getName();	 
	 %>
	<p align="center" class="STYLE1"><a href="AffairListView?sortId=<%= sortId%>" target="mainFrame"><%= sortName %></a></p>
	<%} %>

	</div></td></tr>
	
	<tr><td height="30"><div align="center"><a href="query_pattern.jsp" target="mainFrame">�༶�����ѯ</a></div></td></tr>	
	</table>
	</div>
	
	
	<div id="content">

	<table border="1px"  align="center" width="">
		<tr bgcolor="#77A2E9">
			<td width="10%"><div align="center">������</div></td>
			<td width="44%"><div align="center">�������</div></td>
			<td width="20%"><div align="center">����ʱ��</div></td>
			<td width="13%"><div align="center">�༭</div></td>			
		</tr>
		<%
	    String sortName = (String) request.getAttribute("sortName");
	    List<Affair> list = (ArrayList<Affair>) request.getAttribute("affairList");
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
					href="AffairDetail?affairId=<%=affair.getAffairId()%>">����</a>]
				</div></td>
		</tr>
		<%}%>
	</table>
	</div>
</div>
</body>
</html>