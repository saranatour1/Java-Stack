<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>edit book ${book.id}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  </head>

  <body>
    <div class="container mt-5">

      <h1 class="mt-3"> Edit the book </h1> 
      <p><a href="/books">Back to shelves</a></p>

      <form:form
      action="/books/${book.id}"
      method="post"
      modelAttribute="book"
      class="container w-100"
    >
    <input type="hidden" name="_method" value="put">
      <p>
        <form:label path="title" class="form-label">Title :</form:label>
        <form:errors path="title" class="text-danger" />
        <form:input type="text" path="title" class="form-control" />
      </p>
      <p>
        <form:label path="author" class="form-label">Author :</form:label>
        <form:errors path="author" class="text-danger" />
        <form:input type="text" path="author" class="form-control" />
      </p>
      <p>
        <form:label path="myThoughts" class="form-label">My Thoughts :</form:label>
        <form:errors path="myThoughts" class="text-danger" />
        <form:textarea type="text" path="myThoughts" cols="30" rows="10" class="form-control" />
      </p>

      <input type="submit" value="Submit" class="btn btn-primary" />
    </form:form>

    <!-- delete -->
    <form action="/books/${book.id}/delete" method="post">
      <input type="hidden" name="_method" value="delete">

      <button type="submit" class="btn btn-link text-danger"> Delete</button>
    </form>
    
    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
