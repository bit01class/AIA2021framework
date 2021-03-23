<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/head.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th>deptno</th>
				<th>dname</th>
				<th>loc</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bean">
			<tr>
				<td><a href="#">${bean.deptno }</a></td>
				<td><a href="#">${bean.dname }</a></td>
				<td><a href="#">${bean.loc }</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>






