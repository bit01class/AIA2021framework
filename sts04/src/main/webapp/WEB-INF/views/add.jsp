<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${pageContext.request.contextPath }/webjars/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src="${pageContext.request.contextPath }/webjars/jquery/1.12.4/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath }">
        비트교육센터
      </a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href="${pageContext.request.contextPath }/">HOME</a></li>
    	<li><a href="${pageContext.request.contextPath }/dept/">DEPT</a></li>
    	<li><a href="${pageContext.request.contextPath }/login/">LOGIN</a></li>
    </ul>
  </div>
</nav>
<div class="container">
	<div class="jumbotron">
	  <h1>ADD page!</h1>
	  <p>...</p>
	</div>
	<form class="form-horizontal" action="./" method="post">
	  <div class="form-group">
	    <input type="text" value="${bean.deptno }" name="deptno" placeholder="deptno" class="form-control" />
	  </div>
	  <div class="form-group">
	    <input type="text" value="${bean.dname }" name="dname" placeholder="dname" class="form-control" />
	  </div>
	  <div class="form-group">
	    <input type="text" value="${bean.loc }" name="loc" placeholder="loc" class="form-control" />
	  </div>
	  <div class="form-group">
	    <button type="submit">입 력</button>
	    <button type="reset">취 소</button>
	  </div>
	</form>
</div>
</body>
</html>




























