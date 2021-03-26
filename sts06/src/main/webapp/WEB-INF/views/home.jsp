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
	listPage();
	
	//$('.modal').modal({show:true});
});	
function listPage(){
	$('.list-group').children().filter(':gt(0)').remove();
	$.getJSON('dept',function(data){
		for(var ele of data){
			var obj=$(row);
			obj.find('h4').html(ele.dname);
			obj.find('p').html(ele.loc);
			obj.appendTo('.list-group');
		}
	});
}
	
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

<!-- modal -->
<div class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>












