<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="table.affair.*"%>
<%@page import="table.sort.Sort"%>
<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>班级事务维护</title>
</head>


<style type = "text/css">
<!--
.STYLE2{
   font-family:"宋体";font-size:32px;font-weight:bold;
}
-->
</style>

<body>
<%  		
	Sort sort = new Sort();
	@SuppressWarnings("unchecked")
	List<Sort> list = (ArrayList<Sort>)request.getAttribute("sortList");
	Affair af = (Affair)request.getAttribute("affair"); 
	Integer sortId = af.getSortId();
	String sortName = list.get(sortId-1).getName();%>
	<br><div align="center">班级事务维护
	
	<form method ="post" action="AffairsUpdate" style="">
<!-- 	<form method ="post" action="AffairsUpdate?affair=<%= af.getAffairId()%>" style=""> -->
		<font size="2">事务标题：</font>&nbsp;
		<input type="hidden" name="affairId" value=<%= af.getAffairId()%>>
		<input type="text" size="40" name="title" value="<%= af.getTitle()%>" >&nbsp;	
		<font size="2">栏目：</font>&nbsp;
		<select name="sortPart" id="sortId">
		<option Selected value="<%= sortId%>"><%= sortName%></option>
		<% 
		int num = list.size();
		for(int i=0;i<num;i++){
		sort = list.get(i);			
		%>
		<option value=<%= String.valueOf(sort.getSortId()) %>>
		<%= sort.getName()%>
		</option>
		<%} %>
		</select>
		
		<p>
		<textarea cols="80" rows="15"name="content" > <%= af.getContent()%></textarea>
		<br><input type="submit" value="修改" name="xiugai">
		</p>

	</form>	
	</div>
</body>
</html>