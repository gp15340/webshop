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
<c:when test="${empty booklist}">
	<p>还没有书籍...<a href="adminAddToBook.do">去添加书籍</a><p>
</c:when>
<c:otherwise>
<form action="adminSearchBookByName.do" method="post" >
名称:<input type="text" name="bookName"  />
<input type="submit" value="搜索" />
<table border="1">
	<tr>
		<th>ID</th>
		<th>预览</th>
		<th>名称</th>
		<th>作者</th>
		<th>出版社</th>
		<th>类型</th>
    	<th>单价</th>
	</tr>
	<c:forEach items="${booklist}" var="book">
	<tr>
		<td>${book.bookId}</td>
		<td><img src="${book.imgUrl}" alt="book" width="50" height="80"/></td>
   		<td>${book.bookName}</td>
   		<td>${book.author}</td>
   		<td>${book.publisher}</td>
   		<td>${book.bookType.typeName}</td>
		<td> 
		<span>￥</span><span class="price">${book.bookPrice}</span> 
		</td>
	</tr>
	</c:forEach>
	
</table>
	<font color="red" >${errmsg}</font>
</form>
</c:otherwise>       
</c:choose>
</body>
</html>