<%@page import="entity.comment"%>
<%@ page language="java" import="java.util.*" import="table.affair.*" import="java.text.SimpleDateFormat"
	import="table.comment.Comment" pageEncoding="GB2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
Affair affair = (Affair) request.getAttribute("affair");
 %>
<html>
<head>
<title><%=affair.getTitle() %></title>
</head>
<body>
	<%
		
		String sortName = (String) request.getAttribute("sortName");
		List<Comment> commentList = (List<Comment>) request.getAttribute("commentList");
		String userName = (String) request.getAttribute("userName");
	%>
	<table border="0px" cellspacing="0" cellpadding="10" align="center"
		width="70%" noborder>
		<tr bgcolor="#77A2E9">
			<td nowrap="nowrap"><center><h3>事务标题：<%= affair.getTitle()%></h3></center>
			</td>
		</tr>

		<tr>
			<td><br>
				<center>
				<%
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(affair.getFbTime());
				String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar.getTime()); %>
					所属类别：<%=sortName%>&nbsp;&nbsp;&nbsp;发布日期<%= str%>
				</center></td>
		</tr>
		<tr><td> <hr width="100%"><br> <%= affair.getContent()%>  </td></tr>
	</table>
	
	<font size="2" color ="#ff0000">读者评论</font>
	<% if(commentList.size()>0){
	
		for(int i=0;i<commentList.size();i++){
		 Comment com = (Comment)commentList.get(i);	
		 Calendar calendar2 = Calendar.getInstance();
		 calendar2.setTimeInMillis(com.getPlTime());
		 String str2 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar2.getTime());	
	%>
	<hr align="left" width="80%">
	<font size="2" color="000ff"> <%= com.getAuthor()%> 评论 &nbsp; &nbsp; &nbsp;评论日期：<%= str2%></font>
	<p>
	<font size="2"><%= com.getContent() %></font>
	<% }}%>
	
	<hr align = "middle" width="100%">
	<form method="post" align = "left" action="CommentAdd?affairId= <%= affair.getAffairId()%>">
		<input type="hidden" name="sortName" value=<%= sortName%>>
	
		<font size="2">发表评论</font>
		
		<p><textarea cols="60" rows="4" name="content"></textarea></p>
		
<!-- 		<p><font size="2"><br>发布者：</font>  -->
<!-- 		<input type="text" size="30" name="author" >  -->
		<input type="submit" value="发表评论" name="comment">
		</p>
		
	</form>
</body>
</html>
