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
		��ӭ
		<%=userName%>
		,��ɹ���¼��
		<br>
		����Login_Demo_javaBean��Ŀ
		<table data-role="table" id="table-1" data-mode="columntoggle"
			class="ui-body-a ui-responsive">
			<thead>
				<tr class="ui-bar-a">
					<th>�û���</th>
					<th data-priority="1"><%=user.getUserName()%>></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>��ʵ����</td>
					<td><%=user.getUserNameTrue() %>></td>
				</tr>
				<tr>
					<td>�Ա�</td>
					<td><%=user.getGender() %>></td>
				</tr>
				<tr>
					<td>email��ַ</td>
					<td><%=user.getEmail()%>></td>
				</tr>
			</tbody>
		</table>
	</body>
</html>