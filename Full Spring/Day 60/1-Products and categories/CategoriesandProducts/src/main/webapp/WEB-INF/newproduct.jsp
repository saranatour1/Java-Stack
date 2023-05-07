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
  <div class="container mx-auto mt-5 ">
    <h1 class="text-center my-5"> Add a New Product</h1>
    <form:form action="/product/new" method="post" modelAttribute="product"  class="container mx-auto w-50">

    <p>
      <form:label path="prodName" class="form-label">Product name </form:label>
      <form:errors path="prodName" class="text-danger"/>
      <form:input type="text" path="prodName" class="form-control"/>
  </p>
    <p>
            <form:label path="descreption" class="form-label">descreption</form:label>
            <form:errors path="descreption" class="text-danger"/>
            <form:input type="text" path="descreption" class="form-control"/>
        </p>
      
      <p>
        <form:label path="price" class="form-label">price</form:label>
        <form:errors path="price" class="text-danger"/>
        <form:input type="text" path="price" class="form-control"/>
      </p>
    
      
        <input type="submit" value="Submit" class="btn btn-primary"/>
    </form:form> 
  </div>
   

   

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>