<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 页面顶部 -->
	<div id="top" style="text-align:center;width:80%">
		<h1 align="center">欢迎使用后台管理页面</h1>
	</div >
	<div style="text-align:right">
		<p><a href="adminDetail.jsp">欢迎您：${admin.adminName}</a></p>
	</div>
	<div id="bottom" style="width:800;text-align:center">
		<div id="bottom_1" style="float:left"><iframe src="frame_left.jsp" width="300" height="600"></iframe></div>
		<div id="bottom_2" style="float:left"><iframe src="frame_right.jsp" width="1000" height="600" name="view_frame"></iframe></div>
	</div>
</body>
</html>