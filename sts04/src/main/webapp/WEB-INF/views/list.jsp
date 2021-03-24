<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	  <h1>LIST page!</h1>
	  <p>...</p>
	</div>
	<div class="list-group">
	<c:forEach items="${list }" var="bean">
	  <a href="${bean.deptno }" class="list-group-item">
	    <span class="badge">${bean.deptno }</span>
	    <h4 class="list-group-item-heading">${bean.dname }</h4>
	    <p class="list-group-item-text">${bean.loc }</p>
	  </a>
	</c:forEach>
	</div>
	<a href="form" class="btn btn-primary btn-block" role="button">입 력</a>
</div>
</body>
</html>




























