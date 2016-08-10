<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>关键字查询</title>
</head>

<body>
	<br>
	<div align="center">
		<h3>班级事务查询</h3>
		<br>
		<form action="QueryTitle" method="post">
			<p></p>
			请输入关键字:<input type="text" size="40" name="keyTitle"><input type="submit" value="查询">
		</form>
	</div>
</body>
</html>
