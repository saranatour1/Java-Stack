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
    <title>Edit</title>
  </head>
  <body>
    <h1 class="text-center mt-3">Edit an entity</h1>

    <!-- Form to add new travel menu -->


    <form:form
      action="/Travel/${travel.id}"
      method="post"
      modelAttribute="travel"
      class="container mx-auto w-50"
    >
    <input type="hidden" name="_method" value="put">
      <p>
        <form:label path="expense" class="form-label"
          >Expese Name :
        </form:label>
        <form:errors path="expense" class="text-danger" />
        <form:input type="text" path="expense" class="form-control" />
      </p>
      <p>
        <form:label path="vendor" class="form-label"> Vendor: </form:label>
        <form:errors path="vendor" class="text-danger" />
        <form:input type="text" path="vendor" class="form-control" />
      </p>

      <p>
        <form:label path="amount" class="form-label">amount $ </form:label>
        <form:errors path="amount" class="text-danger" />
        <form:input type="number" path="amount" class="form-control"  />
      </p>

      <p>
        <form:label path="descreption" class="form-label">descreption : </form:label>
        <form:errors path="descreption" class="text-danger" />
        <form:textarea path="descreption" class="form-control" />
      </p>

      <input type="submit" value="Submit" class="btn btn-primary" />
    </form:form>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
