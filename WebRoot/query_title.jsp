<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>�ؼ��ֲ�ѯ</title>
</head>

<body>
	<br>
	<div align="center">
		<h3>�༶�����ѯ</h3>
		<br>
		<form action="QueryTitle" method="post">
			<p></p>
			������ؼ���:<input type="text" size="40" name="keyTitle"><input type="submit" value="��ѯ">
		</form>
	</div>
</body>
</html>
