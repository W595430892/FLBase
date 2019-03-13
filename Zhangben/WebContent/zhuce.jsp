<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
<br><br>
	<div align="center">
		<h2>用户注册</h2>
		<hr width="40%"><br>
	</div>
	<div align="center">
		<form action="Servlet?method=zhuce" method="post"
			onsubmit="return check()">
			<h5>
				账号：<input name="logname" type="text" id="logname">
			</h5>
			<h5>
				密码：<input name="logpass1" type="password" id="logpass1">
			</h5>
			<h5>
				密码：<input name="logpass2" type="password" id="logpass2">
			</h5>
			<h5>
				邮箱：<input name="mail" type="text" id="mail">
			</h5>
			<br /> 
			<br /> <input type="submit" value="注&nbsp&nbsp册">
		</form>
		<br /> 
		<br />
		<a href="index.jsp">返回登陆</a>
	</div>
	<script type="text/javascript">
		function check() {
			var logname = document.getElementById("logname");
			var logpass1 = document.getElementById("logpass1");
			var logpass2 = document.getElementById("logpass2");
			var mail = document.getElementById("mail");
			//非空
			if (logname.value == '') {
				alert('账号为空');
				logname.focus();
				return false;
			}
			if (logpass1.value == '') {
				alert('请输入密码');
				logpass1.focus();
				return false;
			}
			if (logpass2.value == '') {
				alert('请再次输入密码');
				logpass2.focus();
				return false;
			}
			if (mail.value == '') {
				alert('邮箱为空');
				mail.focus();
				return false;
			}
			if (logpass2.value != logpass1.value) {
				alert('两次密码不一致！');
				logpass2.focus();
				return false;
			}
		}
	</script>
</body>
</html>