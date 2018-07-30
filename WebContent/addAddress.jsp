<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">  
    select{ width:100px; text-align:center;}  
</style>  
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script> 
<script type="text/javascript" src="Js/address.js"></script>
<script type="text/javascript" src="Js/select.js"></script> 
</head>
<body>
<p>添加收货地址：</p>
<form action="addAddress.do" method="post">

地区：
<input type="hidden" value="北京市"  name="province" id="province1"/>
<input type="hidden" value="市辖区"  name="city" id="city1"/>
<input type="hidden" value="东城区"  name="district" id="district1"/>
<select id="province" onchange="changeSelect(this);">  
    <option value="000000" style="color:#999;" disabled="disabled" >-请选择省-</option>  
</select>  
<select id="city" onchange="changeSelect(this);" >  
    <option value="000000" style="color:#999;" disabled="disabled" >-请选择市-</option>  
</select>  
<select id="district" >  
    <option value="000000" style="color:#999;" disabled="disabled">-请选区-</option>  
</select>  
<br/>
<br/>
<input type="submit" value="提交">
</form>
</body>
</html>