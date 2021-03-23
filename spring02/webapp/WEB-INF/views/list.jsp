<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body>
<!-- 상단메뉴 -->
<nav class="navbar navbar-default navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        비트교육센터
      </a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href="index.do">HOME</a></li>
    	<li><a href="intro.do">INTRO</a></li>
    	<li><a href="list.do">DEPT</a></li>
    </ul>
  </div>
</nav>
<!-- content -->
<div class="container">
	<div class="row">
	  <div class="col-xs-12">
	  <!-- 본문시작 -->
<ol class="breadcrumb">
  <li><a href="index.do">Home</a></li>
  <li class="active">DEPT</li>
</ol>
<div class="page-header">
  <h1>리스트 페이지<small>DEPT 테이블 목록</small></h1>
</div>	  
	  <table class="table table-hover">
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
	  			<td><a href="dept.do?idx=${bean.deptno }">${bean.deptno }</a></td>
	  			<td><a href="dept.do?idx=${bean.deptno }">${bean.dname }</a></td>
	  			<td><a href="dept.do?idx=${bean.deptno }">${bean.loc }</a></td>
	  		</tr>
	  	</c:forEach>
	  	</tbody>
	  </table>
	  <a href="add.do" class="btn btn-primary" role="button">입력</a>
	  <!-- 본문끝 -->
	  </div>
	</div>
	<div class="row">
	  <div class="col-xs-12 text-center">
	  Copyright &copy; 비트캠프 All rights reserved.
	  </div>
	</div>
</div>
</body>
</html>









