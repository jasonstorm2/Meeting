<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>按时间查询</title>
</head>

<body>
	<%
  	List<String> list1 = (ArrayList<String>)request.getAttribute("yearList");
  	List<String> list2 = (ArrayList<String>)request.getAttribute("monthList");
   %>
	<div align="center">
		<br>
		<h3>按时间段查询班级事务</h3>
		<form method="post" action="QueryTime">
			<br> <br> <font size="">请选择年份:</font> 
			<select name="year">
				<%
				if(list1!=null&&!list1.isEmpty()){
				for(int i=0;i<list1.size();i++){%>
				<option value="<%= list1.get(i)%>">
					<%=list1.get(i) %></option>
				<%}}%>
			</select> 
			
			<font size="">请选择时间:</font> 
			
			<select name="month">
				<%
				if(list2!=null&&!list2.isEmpty()){				
                for(int i=0;i<list2.size();i++){%>
				<option value="<%= i%>">	<%=list2.get(i) %></option>
				<%}} %>
			</select> <br>
			
			<br> <input type="submit" value="提交" name="query">
		</form>
	</div>

</body>
</html>
