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
	String username =request.getParameter("username");
	response.setContentType("text/html;charset=utf8");
	request.setCharacterEncoding("utf-8");
%>
	<form action="${pageContext.request.contextPath}/Servlet?method=update2" method="post"
	onsubmit="return check()">
		<table align="center">

			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name" size="25" id = "pwd1"  value="<%=username%>" /></td>
			</tr>
			<tr>
				<td>旧密码：</td>
				<td><input type="password" name="pwd1" id="pwd2" size="25" /></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="password" name="pwd2" size="25" /></td>
			</tr>
				<tr><td><input type="submit" value="确认修改" size="50"/></td></tr>
			

		</table>
	</form>
	<script type="text/javascript">
		function check() {
			var pwd1 = document.getElementById("pwd1");
			var pwd2 = document.getElementById("pwd2");
			//非空
			
			if (pwd1.value == '') {
				alert('请输入密码');
				pwd1.focus();
				return false;
			}
			if (pwd2.value == '') {
				alert('输入新密码');
				pwd2.focus();
				return false;
			}
		}
	</script>
</body>
</html>