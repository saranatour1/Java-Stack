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
    <title>Confirmation page, all books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  </head>

  <body>
    <div class="container mt-5">
      <div class="d-flex justify-content-between">
        <hgroup>
          <h1>Welcome, ${thisUser.userName} !</h1>
          <p>Books From Everyones shelves:</p>

          <a href="/booksmarket"> Go check the market here</a>
        </hgroup>

        <div>
           <a href="/logout" class="btn btn-link"> Logout</a> <br>
            <a href="/books/new"> + add a book to my shelve</a>
        </div>
      </div>

      <table class="table w-75 mx-auto">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Author Name</th>
            <th scope="col"> Posted By </th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${allbooks}" var="book">
            <tr>
              <th scope="row">${book.id}</th>
              <td><a href="/books/${book.id}">${book.title}</a> </td>
              <td>${book.author}</td>
              <td>${book.user.userName}</td>
            </tr>
          </c:forEach>

        </tbody>
      </table>


    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
