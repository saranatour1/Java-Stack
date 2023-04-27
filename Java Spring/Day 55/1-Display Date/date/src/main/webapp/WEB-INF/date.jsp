<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date Today</title>
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

	<h2><c:out value="${date}"></c:out></h2>
	
	<script src ="/js/script.js"></script>
	
</body>
</html>