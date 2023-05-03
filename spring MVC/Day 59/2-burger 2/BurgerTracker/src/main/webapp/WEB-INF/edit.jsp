<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit form</title>
</head>
<body>


<!-- Form to add new burgers to the menu -->



<h1 class="text-center mt-4 ">Edit burger # ${burger.id}</h1>
<form:form action="/burger/${burger.id}" method="post" modelAttribute="burger"  class="container mx-auto w-50">
  <input type="hidden" name="_method" value="put">
		<p>
				<form:label path="burgerName" class="form-label">Burger name</form:label>
				<form:errors path="burgerName" class="text-danger"/>
				<form:input type="text" path="burgerName" class="form-control"/>
		</p>
		<p>
				<form:label path="restName" class="form-label">Resturant Name</form:label>
				<form:errors path="restName" class="text-danger"/>
				<form:input type="text" path="restName" class="form-control" />

		</p>
		<p>
				<form:label path="notes" class="form-label">Notes</form:label>
				<form:errors path="notes" class="text-danger"/>
				<form:textarea path="notes" class="form-control" />
		</p>
		<p>
				<form:label path="rating" class="form-label">Rating</form:label>
				<form:errors path="rating" class="text-danger"/>     
				<form:input type="number" path="rating"  class="form-control"/>
		</p>    
		<input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>    


	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>		
</body>
</html>