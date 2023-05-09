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
    <title>Project </title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  </head>

  <body>
    <div class="container container-sm container-md container-lg container-xl mt-5 text-start">
      
      <h1 class="my-4">
      Project Details: 
      </h1>
      <p><a href="/dashboard">Back to dashboard </a></p>


      <p>
        Project : <span>${project.title}</span>
      </p>
      <p>
        Descreption : <span>${projct.descreption}</span>
      </p>

      <p>
        Due date : <span>${project.dueDate}</span>
      </p>

      <c:choose>
        <c:when test="${newUser == project.leader.id}">


            <form action="/projects/${project.id}/delete" method="post">
              <input type="hidden" name="_method" value="delete">

              <button type="submit" class="btn btn-link text-danger"> Delete</button>
            </form>


        </c:when>

      </c:choose>
      <hr class="mx-auto my-5">
    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
