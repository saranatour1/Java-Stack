<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Books </title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>

<div class="container mt-3">
  <h1 class="text-center">All Books</h1>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">id</th>
        <th scope="col"> title</th>
        <th scope="col">descreption</th>
        <th scope="col">Number of pages</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var = "book" items="${books}">
      <tr>
        <th scope="row">${book.id}</th>
        <td> <a href="/books/${book.id}"> ${book.title} </a></td>
        <td> ${book.description}</td>
        <td>${book.language}</td>
        <td>${book.numberOfPages}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>