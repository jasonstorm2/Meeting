<%@ page language="java" contentType="text/html; charset=gb2312" 
	pageEncoding="gb2312" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; gb2312">
<title>登陆</title>
</head>
<body>
  <div align = "center">用户登录<br>
  <hr width = "30%" size = "3" style = "background:rgb(64,0,0);">
  <br>
  <form method = "post" name = "login1" action="UserLoginServlet">
  
  
    <p>用户名:   <input type="text" size="15" name="userName"></p>
    <p>密&nbsp;码:
      <input type="password" size="15" name="userPassword"><br>
    </p>
    
    
    
    <p>
    	<input type="submit" value="登录" name="submit">
    </p>
  </form>  
  <a href="http://www.baidu.com" rel = "external nofollow" class = "url">百度一下</a>
  </div>

</body>
</html>