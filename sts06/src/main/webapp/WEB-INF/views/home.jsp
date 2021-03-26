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
		.list-group-item-action{
			cursor: pointer;
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
	$('.table>button').click(function(){
		addForm();
	});
	
});	
function addDept(){
	$.post("dept",$('form').serialize(),function(data){
							console.log(data);
							listPage();
							$('.modal').modal('hide');
							$('form').find('input').val('');
						});
}
function addForm(){
	$('.modal-title').text('입력페이지');
	$('.modal').modal({show:true});
	$('.modal .btn-primary').off().click(function(){
		addDept();
	});
	
}
function detailPage(){
	deptno=$(this).attr('deptno');
	$.getJSON('dept/'+deptno,function(data){
		deptForm(data);
	});
}
function deptForm(data){
	$('.modal-title').text('상세페이지');
	$('.modal').find('input').eq(0).val(data.deptno);
	$('.modal').find('input').eq(1).val(data.dname);
	$('.modal').find('input').eq(2).val(data.loc);
	$('.modal').modal('show');
	$('.modal .btn-primary').off().click(function(){
		updatePage();
	});
}
function updatePage(){
	var deptno=$('form').find('input:eq(0)').val();
	console.log(deptno);
	$.ajax('dept/'+deptno,{
		data:{deptno:'1',dname:'test',loc:'test'}
		,type:'put'
		,dataType  : "json"
        ,contentType: "application/json"
		,success:function(data){
			console.log(data);
		}
	});
}
function listPage(){
	$('.list-group').children().filter(':gt(0)').remove();
	$.getJSON('dept',function(data){
		for(var ele of data){
			var obj=$(row);
			obj.addClass('list-group-item-action');
			obj.find('h4').html(ele.dname);
			obj.find('p').html(ele.loc);
			obj.attr('deptno',ele.deptno);
			obj.click(detailPage);
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
	<button class="btn btn-primary btn-block">입 력</button>
</div>

<!-- modal -->
<div class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">입력페이지</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form>
        <p class="form-group"><input type="text" class="form-control" name="deptno" placeholder="deptno"/> </p>
        <p class="form-group"><input type="text" class="form-control" name="dname" placeholder="dname"/> </p>
        <p class="form-group"><input type="text" class="form-control" name="loc" placeholder="loc"/> </p>
      </form>
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












