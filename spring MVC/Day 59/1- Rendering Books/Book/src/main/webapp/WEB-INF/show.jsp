<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>

<div class="container mt-3">
<h1 class="mt-2"> ${book.title}</h1>
<strong> Descreption :  </strong> <p>  ${book.description}</p>
<strong> Language:  </strong> <p>  ${book.language}</p>
<strong> Number of pages:  </strong> <p>  ${book.numberOfPages}</p>

</div>



<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>