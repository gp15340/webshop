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
	<p>还没有用户订单...<p>
</c:when>
<c:otherwise>
<form action="searchOrderById.do" method="post">
订单号:
<input type="text" name="orderId"  />
<input type="submit" value="搜索" />
<table border="1">
	<tr>
		<th>订单号</th>
		<th>用户名</th>
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
		<td>${order.user.userName}</td>
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
	<a href="adminDeleteOrder.do?orderId=${order.orderId}">取消订单</a>
	</c:if>
	<c:if test="${order.orderStatus=='已付款'}">
	<a href="adminSendOrder.do?orderId=${order.orderId}">发货</a>||<a href="adminDeleteOrder.do?orderId=${order.orderId}">退款</a>
	</c:if>
	<c:if test="${order.orderStatus=='已发货'}">
	<a href="#">查看物流</a>||<a href="adminReceiveOrder.do?orderId=${order.orderId}">提醒收货</a>
	</c:if>
	<c:if test="${order.orderStatus=='已签收'}">
	<a href="#">提醒评价</a>||<a href="adminDeleteOrder.do?orderId=${order.orderId}">删除</a>
	</c:if>
	</td>
	</tr>
	</c:forEach>
	<tr><td colspan="12" align="center">
			<a href="showAllOrder.do?pageS=1">首页</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="showAllOrder.do?pageS=${page.dpage-1}">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="showAllOrder.do?pageS=${page.dpage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="showAllOrder.do?pageS=${page.totalpage}">尾页</a>
		</td>
		</tr>


</table>
</form>
</c:otherwise>       
</c:choose>
</body>
</html>