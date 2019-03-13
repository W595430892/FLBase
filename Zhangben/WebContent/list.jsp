<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div align="center">
		<h1 style="color: black;">账单</h1>
		<form action="Servlet?method=time" method="post"
			onsubmit="return check()">
			
			<label>按月份查找：</label> <select name="time">

				<option value="01" <c:if test="${mtype=='a'}"></c:if>>01</option>
				<option value="02" <c:if test="${mtype=='b'}"></c:if>>02</option>
				<option value="03" <c:if test="${mtype=='c'}"></c:if>>03</option>
				<option value="04" <c:if test="${mtype=='d'}"></c:if>>04</option>
				<option value="05" <c:if test="${mtype=='e'}"></c:if>>05</option>
				<option value="06" <c:if test="${mtype=='f'}"></c:if>>06</option>
				<option value="07" <c:if test="${mtype=='g'}"></c:if>>07</option>
				<option value="08" <c:if test="${mtype=='h'}"></c:if>>08</option>
				<option value="09" <c:if test="${mtype=='i'}"></c:if>>09</option>
				<option value="10" <c:if test="${mtype=='j'}"></c:if>>10</option>
				<option value="11" <c:if test="${mtype=='k'}"></c:if>>11</option>
				<option value="12" <c:if test="${mtype=='l'}"></c:if>>12</option>
				</select> 月
			<input type="submit" value="查找">
		</form>
		
		<form action="Servlet?method=mtype" method="post"
			onsubmit="return check()">
			<label>按收支查找：</label> 
			<select name="mtype">
				<option value="收入" <c:if test="${mtype=='a'}"></c:if>>收入</option>
				<option value="支出" <c:if test="${mtype=='b'}"></c:if>>支出</option>
				</select> 
			<input type="submit" value="查找">
		</form>
		<table class="tb">
			<tr>
				<td>id</td>
				<td>名称</td>
				<td>金额</td>
				<td>类型</td>
				<td>时间</td>
			</tr>
			<c:forEach items="${account}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.thing}</td>
					<td>${item.money}</td>
					<td>${item.mtype}</td>
					<td>${item.time}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>