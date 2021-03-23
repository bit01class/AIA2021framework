<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        비트교육센터
      </a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href="index.action">HOME</a></li>
    	<li><a href="intro.action">INTRO</a></li>
    	<li class="active"><a href="list.action">DEPT</a></li>
    </ul>
  </div>
</nav>	
<div class="container">
	<div class="row">
	  <div class="col-md-12">
	  <!-- start content -->
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
  		<td><a href="deptOne.action?deptno=${bean.deptno }">${bean.deptno }</a></td>
  		<td><a href="deptOne.action?deptno=${bean.deptno }">${bean.dname }</a></td>
  		<td><a href="deptOne.action?deptno=${bean.deptno }">${bean.loc }</a></td>
  	</tr>
  	</c:forEach>
  </tbody>
</table>
<a class="btn btn-primary" role="button" href="add.action">입력</a>
	  <!-- end content -->
	  </div>
	</div>
	<div class="row">
	  <div class="col-md-12">
	  Copyright &copy; 비트캠프 All rights reserved.
	  </div>
	</div>
</div>
</body>
</html>







