<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="userLogin.do"  method="post">
		用户名：<input type="text"  name="userName"/>
		<br/>
		密码：<input type="password" name="password"/>
		<br/>
		
		<input type="submit" value="登录"/>
		<input type="reset" value="重置"/>
</form>
<br>
还没有账户？<a href="userRegister.jsp">点击这里去注册</a>
</body>
</html>