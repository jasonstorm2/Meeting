<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>班级事务</title>
</head>


<style type = "text/css">
<!--
.STYLE2{
   font-family:"宋体";font-size:32px;font-weight:bold;
}
-->
</style>
<!-- 通过超链接 传递任意参数,不能有空格
-->
<body>
	<table>
	<tr> <td height="30"><div align="center"><a href="SortListServlet" target="mainFrame">班级事务发布</a></div></td></tr>
	<tr> <td height="30"><div align="center"><a href="" target="mainFrame">班级事务维护</a></div></td></tr>
	<tr> <td height="100">班级事务浏览
	<p align="center" class="STYLE1"><a href="studyServlet?sortId=1" target="mainFrame">学习竞赛</a></p>
	<p align="center" class="STYLE1"><a href="studyServlet?sortId=2" target="mainFrame">文体活动</a></p>
	<p align="center" class="STYLE1"><a href="studyServlet?sortId=3" target="mainFrame">社会事务</a></p>
	<p align="center" class="STYLE1"><a href="studyServlet?sortId=4" target="mainFrame">各类补助</a></p>
	</tr>
	<tr><td height="30"><div align="center"><a href="#">班级事务查询</a></div></td></tr>
	
	</table>
</body>
</html>