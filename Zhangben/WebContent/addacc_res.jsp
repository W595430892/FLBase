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
		if (a == 0) {
			out.println("<script charset=\"UTF-8\" >alert('添加成功！正在跳转请稍后……'); </script>");
		} 
		else
			out.println("<script charset=\"UTF-8\" >alert('添加失败！返回添加页面'); window.location.href='addaccount.jsp';</script>");
	%>
</body>
</html>