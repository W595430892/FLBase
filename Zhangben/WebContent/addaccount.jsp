<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br><br>
	<div align="center">
		<form action="Servlet?method=addaccount" method="post"
			onsubmit="return check()">
			<h5>
				用途：<input name="thing" type="text" id="thing">
			</h5>
			<h5>
				总钱：<input name="money" type="text" id="money"></h5>
			<label>收支：</label> <select name="mtype">

				<option value="收入" <c:if test="${mtype=='a'}"></c:if>>收入</option>
				<option value="支出" <c:if test="${mtype=='b'}"></c:if>>支出</option>
				</select> 
			<br /> 
			<br /> <input type="submit" value="提&nbsp&nbsp交">
		</form>
	</div>
	<script type="text/javascript">
		function check() {
			var thing = document.getElementById("thing");
			var money = document.getElementById("money");
			var mtype = document.getElementById("mtype");
			//非空
			if (thing.value == '') {
				alert('用途为空');
				thing.focus();
				return false;
			}
			if (money.value == '') {
				alert('总钱为空');
				money.focus();
				return false;
			}
		}
	</script>
</body>
</html>