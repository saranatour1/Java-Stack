<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity loops</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>


<h1 class="text-primary text-center my-5">Fruit store</h1>
<table class="table w-50 mx-auto mt-5">
<thead>
	<tr>
		<th scope="col" > Name </th>
		<th scope="col"> Price </th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${fruits}" var="item">
	    <tr>
	        <td>${item.name}</td>
	        <td>${item.price}</td>
	    </tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>
