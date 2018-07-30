<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="Js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="Js/userRegist.js"></script>
<script type="text/javascript" src="Js/userAjax.js"></script>
</head>
<body>
	<h1 align="center">欢迎注册WebShop账号：</h1>
	<form action="userRegister.do" method="post" >
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName" id="userName" onblur="checkUsername()"/></td>
				<td id="td_1"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" id="pwd1"/></td>
				<td id="td_2"></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="rePassword" id="pwd2" /><span id="errorMsg"></span></td>
				<td id="td_3"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册" id="submit"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
			<tr>
			<td colspan="2">
				<font color="red">
				${errorMsg}</font>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>