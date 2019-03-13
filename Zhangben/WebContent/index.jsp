<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body><br><br>
	<div align="center">
		<h2>登录界面</h2>
		<hr width="40%"><br>
	</div>
	<div align="center">
		<form action="Servlet?method=denglu" method="post"
			onsubmit="return check()">
			<h5>
				账号：<input name="logname" type="text" id="logname"
					placeholder="请输入账户">
			</h5>
			<h5>
				密码：<input name="logpass" type="password" id="logpass"
					placeholder="请输入密码">
			</h5>
			<br /> 
			<br /> <input type="submit" value="登&nbsp&nbsp录">
		</form>
		<br /> 
		<br />
		<a href="zhuce.jsp">注册账号</a>
	</div>
	<script type="text/javascript">
		function check() {
			var logname = document.getElementById("logname");
			var logpass = document.getElementById("logpass");

			//非空
			if (logname.value == '') {
				alert('账号为空');
				logname.focus();
				return false;
			}
			if (logpass.value == '') {
				alert('请输入密码');
				logpass.focus();
				return false;
			}

		}
	</script>
</body>
</html>