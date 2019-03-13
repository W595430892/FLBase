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
			out.println("<script charset=\"UTF-8\" >alert('创建成功！'); window.location.href='index.jsp'; </script>");
		} 
		else
			out.println("<script charset=\"UTF-8\" >alert('创建失败'); window.location.href='index.jsp';</script>");
	%>
</body>
</html>