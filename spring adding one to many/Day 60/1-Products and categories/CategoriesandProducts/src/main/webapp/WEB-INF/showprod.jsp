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
  <title>Show Product page </title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <a href="/" class="btn btn-link"> Back </a>
    <h1 class=" text-center"> ${product.prodName} </h1>
    <hr class="container mx-auto">
  
    <h3> All the Categories </h3>
  <c:forEach items="${allcats}" var="cat">
    <p>
      - ${cat.catName}
    </p>
  
  </c:forEach>  
  
  <hr class="container mx-auto">
  
  </div>


  <div class="container w-50 flex-start">
    <form action="/products/${product.id}" method="post">
      <div class="mb-3">
        <label for="cat" class="form-label">Select a cat</label>
        <select name="cat" id="cat" class="form-control">
          <c:forEach items="${allcats}" var="cat">
            <option value="${cat.id}">
              - ${cat.catName}
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