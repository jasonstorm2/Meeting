<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="table.sort.Sort"%>
<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>


<style type = "text/css">
<!--
.STYLE2{
   font-family:"宋体";font-size:32px;font-weight:bold;
}
-->
</style>

<body>
<%  Sort sort = new Sort();
	@SuppressWarnings("unchecked")
	List<Sort> list = (ArrayList<Sort>)request.getAttribute("sortList"); %>
	<br><div align="center">班级事务发布
	<form method ="post" action="AffairsAdd" style="">
		<font size="2">事务标题：</font>&nbsp;
		<input type="text" size="60" name="title">&nbsp;
		<font size="2">栏目：</font>&nbsp;
		<select name="sort">
				<%
		int num = list.size();
		for(int i=0;i< num;i++){
		sort = (Sort)list.get(i);		
		 %>
		 <option value=<%=String.valueOf(sort.getSortId())%>>
		 <%=sort.getName() %></option>
		 <% } %>
		</select>
		<p>
		<textarea cols="80" rows="15"name="content"></textarea>
		<br><input type="submit" value="事务发布" name="fabu">
		</p>	
	</form>	
	</div>
</body>
</html>