<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div class="container">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">
	        비트교육센터
	      </a>
	    </div>
	    <div>
	    	<a href="index.action" class="btn btn-default navbar-btn">HOME</a>
	    	<a href="dept.action" class="btn btn-primary navbar-btn">DEPT</a>
	    	<a href="emp.action" class="btn btn-default navbar-btn">E M P</a>
	    </div>
	  </div>
	</nav>
	<div class="jumbotron">
	  <h1>DEPT Insert!</h1>
	  <a class="btn btn-primary btn-lg" href="dept.action">목 록</a>
	</div>
	<form action="insertDept.action" method="post">
	  <div class="form-group">
	    <label for="deptno">deptno</label>
	    <input type="text" class="form-control" id="deptno" name="deptno" placeholder="deptno">
	  </div>
	  <div class="form-group">
	    <label for="dname">dname</label>
	    <input type="text" class="form-control" id="dname" name="dname" placeholder="dname">
	  </div>
	  <div class="form-group">
	    <label for="loc">loc</label>
	    <input type="text" class="form-control" id="loc" name="loc" placeholder="loc">
	  </div>
	  <button type="submit" class="btn btn-default btn-block">입 력</button>
	</form>
</div>
</body>
</html>







