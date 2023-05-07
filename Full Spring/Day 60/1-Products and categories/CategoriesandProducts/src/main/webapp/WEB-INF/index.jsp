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

    <div class="container mt-5">
      <h1 class="text-center mt-5 mb-5"> Home Page</h1>

      <div class="d-flex flex-column align-items-start">
          <a href="/category/new" class="btn btn-link">Add a new Category </a>
          <a href="/product/new" class="btn btn-link">Add a new Product</a>
      </div>
      <hr class="mx-auto my-5">

      <div class="container mx-auto w-50">
        <div class="row">
          <div class="col">

            <p class="border-bottom">Product</p>
            <p class="d-flex flex-column align-items-start">
              <c:forEach items="${products}" var="product"> 
                <a href="/products/${product.id}" class="btn btn-link">${product.prodName}</a>      </c:forEach>

            </p>
          </div>

          <div class="col">
            <p class="border-bottom">
              Category
            </p>
          <p class="d-flex flex-column align-items-start">
            <c:forEach items="${categories}" var="category">
              <a href="/category/${category.id}" class="btn btn-link">${category.catName}</a>
          </c:forEach>
          </p>
          </div>

        </div>



      </div>

      




    </div>

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>