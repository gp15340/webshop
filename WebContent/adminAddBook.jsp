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
<form action="addBook.do"method="post" enctype="multipart/form-data" > 
		书名：<input type="text"  name="bookName"/>
		<br/>
		价格：<input type="text"  name="bookPrice"/>
		<br/>
		作者：<input type="text" name="author"/>
		<br/>
		出版社:<input type="text" name="publisher"/>
		<br/>
		类型:
<c:forEach items="${typelist}" var="type">
		<input type="radio" name="typeId" value="${type.typeId}" />
		<span>${type.typeName}</span>
</c:forEach>
	<br>
	<a href="adminAddBookType.jsp">添加新的类型</a>
		<br/>
		简介：<input type="text"  name="bookDetail"/>
		<br/>
		图片：<input type="file" name="file"/>
		<br/>
		<input type="submit" value="添加"/>
		<input type="reset" value="重置"/>



</form>
</body>
</html>