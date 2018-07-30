<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script> 
<script type="text/javascript" src="Js/addtocart.js"> </script> 
<title>Insert title here</title>
</head>
<body>
<form action="addToCart.do?bookId=${book.bookId}" method="post">
<table id="tab"> 
	<img src="${book.imgUrl}" alt="book" width="200" height="240"/>
	</br>    
    <h3>书名：${book.bookName}</h3>
    </br>
    <p class="book_inline">简介：${book.bookDetail}</p>
    </br>
  <tr> 
	<td> 
		<span>单价:</span><span id="price">${book.bookPrice}</span> 
		<input class="min" name="" type="button" value="-" /> 
		<input id="quantity" name="number" type="text" value="1"  style="width:30px"/> 
		<input class="add" name="" type="button" value="+" /> 
	</td> 
	</tr> 
</table>
	<p>总价：<input name="total" id="totalPrice" readonly="readonly"  type="text" style="width:40px" value="${book.bookPrice}" /></p>
  	<input type="submit" value="添加到购物车" />
</form>
</body>
</html>