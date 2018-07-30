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
<form action="updateBook.do"method="post" enctype="multipart/form-data" > 
<input type="hidden"  name="bookId" value="${book.bookId}"/>
<input type="hidden"  name="imgUrl" value="${book.imgUrl}"/>
		<img src="${book.imgUrl}" alt="book" width="200" height="240"/>
	</br>    
		书名：<input type="text"  name="bookName" value="${book.bookName}"/>
		<br/>
		价格：<input type="text"  name="bookPrice" value="${book.bookPrice}"/>
		<br/>
		作者：<input type="text" name="author" value="${book.author}"/>
		<br/>
		出版社:<input type="text" name="publisher" value="${book.publisher}" />
		<br/>
		类型:
	<c:forEach items="${typelist}" var="type">
	<c:if test="${book.bookType.typeId==type.typeId}" >
		<input type="radio" name="typeId" value="${type.typeId}" checked="checked" />
		<span>${type.typeName}</span>
	</c:if>
	<c:if test="${book.bookType.typeId!=type.typeId}" >
		<input type="radio" name="typeId" value="${type.typeId}" />
		<span>${type.typeName}</span>
	</c:if>
</c:forEach>
	<br>
	
	
	
		<br/>
		简介：<input type="text"  name="bookDetail" value="${book.bookDetail}"/>
		<br/>
		替换图片：<input type="file" name="file"/>
		<br/>
		<input type="submit" value="修改"/>
		<input type="reset" value="重置"/>



</form>
</body>
</html>