<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
	  <li role="presentation"><a href="../index.bit">Home</a></li>
	  <li role="presentation"><a href="../intro.bit">Intro</a></li>
	  <li role="presentation" class="active"><a href="list.bit">Dept</a></li>
	</ul>
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
			<td><a href="detail.bit?idx=${bean.deptno }">${bean.deptno }</a></td>
			<td><a href="detail.bit?idx=${bean.deptno }">${bean.dname }</a></td>
			<td><a href="detail.bit?idx=${bean.deptno }">${bean.loc }</a></td>
		</tr>		
		</c:forEach>
		</tbody>
	</table>
	<a href="add.bit" class="btn btn-primary btn-lg btn-block" role="button">입 력</a>
</div>
</body>
</html>





