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
<c:choose>
<c:when test="${empty userlist}">
	<p>还没有用户注册...<p>
</c:when>
<c:otherwise>
<form action="searchUserById.do" method="post">
用户ID:
<input type="text" name="userId"  />
<input type="submit" value="搜索" />
<table border="1">
	<tr>
		<th>ID</th>
		<th>头像</th>
		<th>用户名</th>
		<th>密码</th>
		<th>邮箱</th>
		<th>操作</th>
    	
	</tr>
	<c:forEach items="${userlist}" var="user">
	<tr>
		<td>${user.userId}</td>
		<td><img src="${user.avatarUrl}" alt="头像" width="30" height="30"/></td>
   		<td>${user.userName}</td>
   		<td>${user.password}</td>
   		<td>${user.email}</td>
   		<td><a href="adminUpdateUser.do?userId=${user.userId}">修改</a>||<a href="deleteUser.do?userId=${user.userId}">删除</a></td>
		
	</tr>
	</c:forEach>
	<tr><td colspan="12" align="center">
			<a href="showAllUser.do?pageS=1">首页</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="showAllUser.do?pageS=${page.dpage-1}">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="showAllUser.do?pageS=${page.dpage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="showAllUser.do?pageS=${page.totalpage}">尾页</a>
		</td>
		</tr>
	
</table>
	<font color="red" >${errmsg}</font>
</form>
</c:otherwise>       
</c:choose>
</body>
</html>