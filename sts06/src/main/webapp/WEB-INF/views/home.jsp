<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<link rel="stylesheet" href="webjars/bootstrap/4.6.0-1/css/bootstrap.min.css">
	<style type="text/css">
		a>ul>li:first-child {
			width: 213px;
		}
	</style>
	<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/4.6.0-1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
var row;	
$(function(){
	row=$('.list-group').html();
	$('.list-group')
		.append($(row).html('<h4>추가1</h4><p>첫번째줄</p>'))
		.append($(row).html('<h4>추가2</h4><p>첫번째줄</p>'))
		.append($(row).html('<h4>추가3</h4><p>첫번째줄</p>'))
		.append($(row).html('<h4>추가4</h4><p>첫번째줄</p>'))
		;
});	
	
	</script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">비트교육센터</a>
</nav>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">Fluid jumbotron</h1>
    <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
  </div>
</div>
<div class="table">
	<ul class="list-group">
	  <li class="list-group-item">
	  	<h4>dname</h4>
	  	<p>loc</p>
	  </li>
	</ul>
</div>

</body>
</html>












