<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>�༶�����ѯ</title>
  </head>  
  
  <body>
    <div align="center">
    <img src="pic/delete.gif" width="25" height="25"><a href="query_title.jsp" >������ؼ��ֲ�ѯ</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="pic/modify.gif" width="25" height="25"><a href="query_time.jsp">��ʱ���ѯ</a>
    </div>
  </body>
</html>
