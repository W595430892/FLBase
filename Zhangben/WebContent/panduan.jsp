<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
		int a = Integer.parseInt(String.valueOf(request.getAttribute("a")));
		if (a == 1) {
			out.println("<script charset=\"UTF-8\" >alert('登录成功！正在跳转请稍后……'); window.location.href='main.jsp';</script>");
		} 
		else
			out.println("<script charset=\"UTF-8\" >alert('用户名或密码错误！'); window.location.href='index.jsp';</script>");
	%>
</body>
</html>