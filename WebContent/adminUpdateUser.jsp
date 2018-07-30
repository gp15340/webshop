<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="userUpdateByAdmin.do"method="post" enctype="multipart/form-data" > 
<input type="hidden"  name="userId" value="${user.userId}"/>
<input type="hidden"  name="avatarUrl" value="${user.avatarUrl}"/>
		<img src="${user.avatarUrl}" alt="头像" width="200" height="240"/>
	</br>    
		用户名：<input type="text"  name="userName" value="${user.userName}"/>
		<br/>
		密码：<input type="text"  name="password" value="${user.password}"/>
		<br/>
		邮箱：<input type="text" name="email" value="${user.email}"/>
		<br/>
	
		<br/>
		更换头像：<input type="file" name="file"/>
		<br/>
		<input type="submit" value="修改"/>
		<input type="reset" value="重置"/>



</form>
</body>
</html>