<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script> 
<script type="text/javascript" src="Js/addtoorder.js"> </script> 
<script language="JavaScript">
   function gogogo(){
      document.cartForm.action ="deleteCarts.do";
      document.cartForm.submit();
   }
</script>
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${empty cartlist}">
	<p>您的购物车空空...<a href="loadBookList.do">去添加商品</a><p>
</c:when>
<c:otherwise>
<form action="addToOrder.do" method="post" name="cartForm">
<table border="1">
	<tr>
		<th><input type="checkbox" id="allChecks"  />全选</th>
		<th></th>
		<th>名称</th>
    	<th>单价</th>
    	<th>数量</th>
    	<th>小计</th>
    	<th>操作</th>
	</tr>
	<c:forEach items="${cartlist}" var="shopping">
	<tr>
		<td><input type="checkbox" name="orderlist" value="${shopping.total};${shopping.shoppingId}" />
		
		</td>
		<td><img src="${shopping.bookImgUrl}" alt="book" width="50" height="80"/></td>
   	<td>${shopping.bookName}</td>
	<td> 
		<span>￥</span><span class="price">${shopping.bookPrice}</span> 
	</td>
	<td>
		
		<span >${shopping.number}</span> 
		
	</td>
	<td><span>￥</span><span class="priceTotal">${shopping.total}</span> </td>
	<td><a href="selectCart.do?shoppingId=${shopping.shoppingId}&bookId=${shopping.bookId}">修改</a>||<a href="deleteCart.do?shoppingId=${shopping.shoppingId}">删除</a></td>
	</tr>
	</c:forEach>
	<tr><td colspan="12" align="center">
			<a href="showCart.do?pageS=1">首页</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="showCart.do?pageS=${page.dpage-1}">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="showCart.do?pageS=${page.dpage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="showCart.do?pageS=${page.totalpage}">尾页</a>
		</td>
		</tr>

</table>
<span>总价格：￥</span><input name="totalPrice" id="totalPrice" readonly="readonly"  type="text" style="width:40px" value="0" />
	<input type="submit" value="提交订单" />
	<input type="button" onclick="gogogo()" value="删除">
	<font color="red" >${errmsg}</font>
</form>
</c:otherwise>       
</c:choose>
</body>
</html>