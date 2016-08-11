<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="login.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.4/jquery.mobile-1.4.4.min.css">
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.4/jquery.mobile-1.4.4.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Login Success</title>
</head>
	<body>
		<%
			String userName = request.getParameter("userName");
		%>
		<%
			User user = (User)request.getAttribute("user");
		%>
		欢迎
		<%=userName%>
		,你成功登录！
		<br>
		这是Login_Demo_javaBean项目
		<table data-role="table" id="table-1" data-mode="columntoggle"
			class="ui-body-a ui-responsive">
			<thead>
				<tr class="ui-bar-a">
					<th>用户名</th>
					<th data-priority="1"><%=user.getUserName()%>></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>真实姓名</td>
					<td><%=user.getUserNameTrue() %>></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><%=user.getGender() %>></td>
				</tr>
				<tr>
					<td>email地址</td>
					<td><%=user.getEmail()%>></td>
				</tr>
			</tbody>
		</table>
	</body>
</html>