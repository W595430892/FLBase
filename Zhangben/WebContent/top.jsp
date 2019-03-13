<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>top</title>
</head>
<body>
<%
	String username = request.getParameter("username");
%>
<div align="center">
<h1>
<marquee>欢迎进入家庭记账本 </marquee>
</h1>

</div>
<div align="right">
用户：<%out.println(username);%></div>

</body>
</html>