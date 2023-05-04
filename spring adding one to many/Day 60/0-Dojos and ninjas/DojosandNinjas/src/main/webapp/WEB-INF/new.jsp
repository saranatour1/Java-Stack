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
  <title>add </title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>

  <!-- Form for creating a new Ninja -->
  
  <h1 class="text-center mt-4 ">New Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja"  class="container mx-auto w-50">
<p>
  <form:select class="form-control"  path="dojo">
    <c:forEach  var="doj" items="${dojos}">
      <form:option value="${doj.id}">${doj.fullName}</form:option>
    </c:forEach>


    </form:select>
</p>		

<p>
				<form:label path="firstName" class="form-label">First name</form:label>
				<form:errors path="firstName" class="text-danger"/>
				<form:input type="text" path="firstName" class="form-control"/>
		</p>
    <p>
      <form:label path="lastName" class="form-label">Last name</form:label>
      <form:errors path="lastName" class="text-danger"/>
      <form:input type="text" path="lastName" class="form-control"/>
  </p>
  
  <p>
    <form:label path="age" class="form-label">Age</form:label>
    <form:errors path="age" class="text-danger"/>
    <form:input type="text" path="age" class="form-control"/>
  </p>

  
		<input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>    

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>