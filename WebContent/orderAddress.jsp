<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>地址选择</title>  
</head>
<body>
<p>请选择您的收货地址：</p>
<form action="insertToOrder.do" method="post">
<c:if test="${addresslist!=null}">
<c:forEach items="${addresslist}" var="address">
		<input type="radio" name="addressId" value="${address.addressId}" />
		<span>${address.province} ${address.city} ${address.district}</span>
</c:forEach>

<input type="submit" value="提交">
</c:if>
</form>

<a href="addAddress.jsp" >添加新的收货地址</a>
</body>
</html>