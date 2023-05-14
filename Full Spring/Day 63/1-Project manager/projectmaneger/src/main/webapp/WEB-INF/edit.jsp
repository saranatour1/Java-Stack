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
    <title>add a new Project</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  </head>

  <body>
    <div class="container mt-5">

      <h1 class="mt-3"> Add a New project </h1> 
      <p><a href="/dashboard">Back to Main page</a></p>

      <form:form
      action="/projects/${project.id}/edit"
      method="post"
      modelAttribute="project"
      class="container w-100"
    >
    <input type="hidden" name="_method" value="put">
      <p>
        <form:label path="title" class="form-label">Project Title :</form:label>
        <form:errors path="title" class="text-danger" />
        <form:input type="text" path="title" class="form-control" />
      </p>
      <p>
        <form:label path="descreption" class="form-label"> Project Descreption :</form:label>
        <form:errors path="descreption" class="text-danger" />
        <form:textarea type="text" path="descreption" cols="30" rows="10" class="form-control" />
      </p>

      <p>
        <form:label path="dueDate" class="form-label">Due Date:</form:label>
        <form:errors path="dueDate" class="text-danger" />
        <form:input type="date" path="dueDate" class="form-control" />
        <!-- <input type="date" name="try" class="form-control"/> -->
      </p>

      <input type="submit" value="Submit" class="btn btn-primary" />
      
      <input type="reset" value="Cancel " class="btn btn-primary" />
    </form:form>

    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
