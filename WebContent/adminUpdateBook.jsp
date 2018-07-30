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
<form action="adminUpdateBookById.do" method="post" >
ID:<input type="text" name="bookId"  />
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
    	<th>操作</th>
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
		<td><a href="updateBookShow.do?bookId=${book.bookId}" >修改</a>||<a href="deleteBook.do?bookId=${book.bookId}">删除</a></td>
	</tr>
	</c:forEach>
	<tr><td colspan="12" align="center">
			<a href="adminUpdateBook.do?pageS=1">首页</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="adminUpdateBook.do?pageS=${page.dpage-1}">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="adminUpdateBook.do?pageS=${page.dpage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="adminUpdateBook.do?pageS=${page.totalpage}">尾页</a>
		</td>
		</tr>
	
</table>
	<font color="red" >${errmsg}</font>
</form>
</c:otherwise>       
</c:choose>
</body>
</html>