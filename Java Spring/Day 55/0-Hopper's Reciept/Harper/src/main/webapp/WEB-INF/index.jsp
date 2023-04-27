<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Harper project</title>
</head>
<body>

	<h1> Customer Name: <c:out value="${x}"></c:out>  </h1>
	<p> item name:  <c:out value="${y}"></c:out>  </p>
	<p> Price:$ <c:out value="${z}"></c:out>  </p>
	<p> Descreption: <c:out value="${k}"></c:out>  </p>
	<p> Vendor: <c:out value="${j}"></c:out>  </p>
</body>
</html>