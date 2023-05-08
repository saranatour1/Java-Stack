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
    <title>Login and Regestration page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  </head>

  <body>
    <div class="container container-sm container-md container-lg container-xl mt-5 text-start">
      
      <h1 class="my-4">
        ${book.title}
      </h1>
      <p><a href="/books">Back to shelves</a></p>

      <p> 
        <span class="text-danger"> ${book.user.userName}</span>
        read 
        <span class="text-primary">
          ${book.title}
        </span>

        by 
        <span class="text-success">
          ${book.author}
        </span>
      </p>

      <p class="mt-4">
        Here are <span class="text-danger"> ${book.user.userName}</span> Thoughts: 
      </p>

      <hr class="mx-auto my-5">

      <p>
        ${book.myThoughts}
      </p>
      <hr class="mx-auto my-5">
    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
