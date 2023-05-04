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
  <title>Show Catogery page </title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <a href="/" class="btn btn-link"> Back </a>
    <h1 class=" text-center"> ${cat.catName} </h1>
    <hr class="container mx-auto">
  
    <h3> All the Products </h3>
  <c:forEach items="${prod}" var="pr">
    <p>
      - ${pr.prodName}
    </p>
  
  </c:forEach>  
  
  <hr class="container mx-auto">
  
  </div>


  <!-- Form to add category to product  -->

  <div class="container w-50 flex-start">
    <form action="/category/${cat.id}" method="post">
      <div class="mb-3">
        <label for="product" class="form-label">Select a product</label>
        <select name="product" id="product" class="form-control">
          <c:forEach items="${prod}" var="pr">
            <option value="${pr.id}">
              - ${pr.prodName}
            </option>
          
          </c:forEach>  
  
        </select>
      
      </div>
      <input type="submit" class="btn btn-primary" value="add">
    </form>
  </div>





<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>