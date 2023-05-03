<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Main page with form</title>
  </head>
  <body>
    <div class="container mx-auto mt-5">
      <h1>
        Expense detils: <span> </span>
        <a href="/" class="btn btn-link">Go back</a>
      </h1>
      <h4>
        Expense name :
        <span>${travel.expense} </span>
      </h4>
      <h4>Expense descreption: <span> ${travel.descreption}</span></h4>
      <h4>Vendor : <span>${travel.vendor}</span></h4>
      <h4>Amount: <span>${travel.amount} $</span></h4>
    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
