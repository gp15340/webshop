<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="userUpdate.do"  method="post" enctype="multipart/form-data">
		<img src="${user.avatarUrl}" width="100" height="100"  />
		<br>
		<input type="hidden"  name="userId" value="${user.userId}" />
		<input type="hidden"  name="avatarUrl" value="${user.avatarUrl}" />
		用户名：<input type="text"  name="userName" value="${user.userName}" />
		<br/>
		密码：<input type="password" name="password" value="${user.password}"/>
		<br/>
		邮箱地址:<input type="text" name="email" value="${user.email}"/>
		<br/>
		更换头像：<input type="file" name="file"/>
		<br/>
		<input type="submit" value="保存"/>
		<input type="reset" value="取消"/>
</form>

<br/>
<br/>
<a href="showCart.do" target="_blank">我的购物车</a>
<br/>
<a href="showOrders.do" target="_blank">我的订单</a>

</body>
</html>