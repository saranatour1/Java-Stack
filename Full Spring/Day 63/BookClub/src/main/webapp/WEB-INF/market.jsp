<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <title>Market</title>
            <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
          </head>

          <body>
            <div class="container mt-5">
              <div class="d-flex justify-content-between">
                <hgroup>
                  <p> Hi, Welcome, ${thisUser.userName} !</p>

                  <h1 class="my-3">Book broker</h1>
                  <p> Avilable books to borrow :</p>
                </hgroup>
                <a href="/books" class="btn btn-link"> Go back to the shelves</a>

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
                    <th scope="col">Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${allbooks}" var="book">
                    <tr>
                      <th scope="row">${book.id}</th>
                      <td><a href="/books/${book.id}">${book.title}</a> </td>
                      <td>${book.author}</td>
                      <td>${book.user.userName}</td>
                      <!-- start of the if statemnent -->
                      <c:choose>
                        <c:when test="${newUser == book.user.id}">
                          <td class="d-flex"><a href="/books/${book.id}/edit" class="btn btn-link">Edit</a>

                            <form action="/books/${book.id}/delete" method="post">
                              <input type="hidden" name="_method" value="delete">

                              <button type="submit" class="btn btn-link text-danger"> Delete</button>
                            </form>
                          </td>

                        </c:when>
                        <c:otherwise>
                          <td>
                            <a href="/books/${book.id}/borrow">borrow</a>
                          </td>


                        </c:otherwise>
                      </c:choose>
                    </tr>
                  </c:forEach>

                </tbody>
              </table>


                <div class="my-3">
                  <p>Books I'm borrowing :</p>
                  <table class="table w-75 mx-auto">
                    <thead>
                      <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Title</th>
                        <th scope="col">Author Name</th>
                        <th scope="col"> Posted By </th>
                        <th scope="col">Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${borrowedBooks}" var="book">
                        <tr>
                          <th scope="row">${book.id}</th>
                          <td><a href="/books/${book.id}">${book.title}</a> </td>
                          <td>${book.author}</td>
                          <td>${book.user.userName}</td>
                          <!-- start of the if statemnent -->
                          <td><a href="/books/${book.id}/return">return</a> </td>
                        </tr>
                      </c:forEach>
    
                    </tbody>
                  </table>

                </div>



              

            </div>

            <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
          </body>

          </html>