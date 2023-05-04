<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Main Page </title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>

  <!-- Form for creating a new Dojo -->
  
  <h1 class="text-center mt-4 ">New Dojo</h1>
<form:form action="/dojos/new" method="post" modelAttribute="dojo"  class="container mx-auto w-50">
		<p>
				<form:label path="fullName" class="form-label">Dojo name</form:label>
				<form:errors path="fullName" class="text-danger"/>
				<form:input type="text" path="fullName" class="form-control"/>
		</p>
  
		<input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>    

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>