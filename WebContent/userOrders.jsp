<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script> 
<script type="text/javascript" src="Js/addtoorder.js"> </script> 
</head>
<body>
<c:choose>
<c:when test="${empty orderlist}">
	<p>您还没有订单...<a href="showCart.do">去提交订单</a><p>
</c:when>
<c:otherwise>
<form action="" method="post">
<table border="1">
	<tr>
		<th>订单号</th>
		<th>商品名称</th>
    	<th>单价</th>
    	<th>数量</th>
    	<th>小计</th>
    	<th>收货地址</th>
    	<th>下单时间</th>
    	<th>订单状态</th>
    	<th>操作</th>
	</tr>
	<c:forEach items="${orderlist}" var="order">
	<tr>
		<td>${order.orderId}</td>
   	<td>${order.bookName}</td>
	<td> 
		<span>￥</span><span class="price">${order.bookPrice}</span> 
	</td>
	<td>
		
		<span >${order.number}</span> 
		
	</td>
	<td><span>￥</span><span class="priceTotal">${order.total}</span> </td>
	<td>${order.address}</td>
	<td>${order.orderTime}</td>
	<td>${order.orderStatus}</td>
	<td>
	<c:if test="${order.orderStatus=='待付款'}">
	<a href="payOrder.do?orderId=${order.orderId}">去支付</a>||<a href="deleteOrder.do?orderId=${order.orderId}">取消订单</a>
	</c:if>
	<c:if test="${order.orderStatus=='已付款'}">
	<a href="sendOrder.do?orderId=${order.orderId}">提醒发货</a>
	</c:if>
	<c:if test="${order.orderStatus=='已发货'}">
	<a href="#">查看物流</a>||<a href="receiveOrder.do?orderId=${order.orderId}">确认收货</a>
	</c:if>
	<c:if test="${order.orderStatus=='已签收'}">
	<a href="#">去评价</a>||<a href="deleteOrder.do?orderId=${order.orderId}">删除</a>
	</c:if>
	</td>
	</tr>
	</c:forEach>
	


</table>
</form>
</c:otherwise>       
</c:choose>
</body>
</html>