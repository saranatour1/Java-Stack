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
  <title>show dojo ${dojo.id} </title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>

  <h1 class="text-center mt-5 mb-5"> Show Dojos of ${dojo.fullName}</h1>
  <table class="table container mx-auto mt-5 w-50">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name </th>
				<th scope="col">age</th>
			</tr>
		</thead>
		<tbody>
      <c:forEach var="ninja" items="${dojo.ninjas}">
        <tr>
          <td>${ninja.id}</td>
          <td>${ninja.firstName}</td>
          <td>${ninja.lastName}</td>
          <td>${ninja.age}</td> 
    </tr>
      </c:forEach>
   


		</tbody>
	</table>

  


<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>