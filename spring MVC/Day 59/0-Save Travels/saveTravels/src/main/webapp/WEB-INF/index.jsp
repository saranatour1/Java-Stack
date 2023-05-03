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
    <h1 class="text-center mt-3">Save Travles</h1>
    <table class="table container mx-auto mt-5 w-50">
      <thead>
        <tr>
          <th scope="col">id</th>
          <th scope="col">expences</th>
          <th scope="col">vendor</th>
          <th scope="col">Amount</th>
          <th scope="col">Edit</th>
          <th scope="col">Delete</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="trip" items="${trips}">
          <tr>
            <th scope="row">${trip.id}</th>
            <td><a href="/travel/${trip.id}"> ${trip.expense}</a></td>
            <td>${trip.vendor}</td>
            <td>${trip.amount} $</td>
            <td><a href="/travel/${trip.id}/edit">Edit</a></td>
            <td><form action="/travel/${trip.id}" method="post">
              <input type="hidden" name="_method" value="delete">
              <input type="submit" value="Delete" class="btn btn-danger">
          </form></td>
            <!-- <td><a href="/expenses/${trip.id}/edit">edit</a></td> -->
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <!-- Form to add new travel menu -->

    <h1 class="text-center mt-4">Add a new Expense</h1>
    <form:form
      action="/"
      method="post"
      modelAttribute="travel"
      class="container mx-auto w-50"
    >
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
