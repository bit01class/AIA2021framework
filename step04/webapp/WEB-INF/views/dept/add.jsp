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
	
	<div class="page-header">
	  <h1>입력페이지 <small>DEPT목록</small></h1>
	</div>
	
	<form action="insert.bit" method="post">
	  <div class="form-group">
	    <label for="deptno">deptno</label>
	    <input type="text" class="form-control" id="deptno" name="deptno" placeholder="dentno">
	  </div>
	  <div class="form-group">
	    <label for="dname">dname</label>
	    <input type="text" class="form-control" id="dname" name="dname" placeholder="dname">
	  </div>
	  <div class="form-group">
	    <label for="loc">loc</label>
	    <input type="text" class="form-control" id="loc" name="loc" placeholder="loc">
	  </div>
	  <button type="submit" class="btn btn-default">입 력</button>
	</form>
</div>
</body>
</html>





