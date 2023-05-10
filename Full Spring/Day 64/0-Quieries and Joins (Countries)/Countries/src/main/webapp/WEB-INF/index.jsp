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
            <title>Login and Regestration page</title>
            <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
          </head>

          <style>
            html {
              scroll-behavior: smooth;
            }
          </style>

          <body>
            <div class="container container-sm container-md mt-5 mx-auto">
              <nav class="d-flex justify-content-center my-3">
                <a href="#Query1" class="btn btn-link">Query1</a>
                <a href="#Query2" class="btn btn-link">Query2</a>
                <a href="#Query3" class="btn btn-link">Query3</a>
                <a href="#Query4" class="btn btn-link">Query4</a>
                <a href="#Query5" class="btn btn-link">Query5</a>
                <a href="#Query6" class="btn btn-link">Query6</a>
                <a href="#Query7" class="btn btn-link">Query7</a>
                <a href="#Query8" class="btn btn-link">Query8</a>
              </nav>


              <div id="Query1">
                <h3>
                  Query 1
                </h3>
                <a href="#" class="btn btn-link"> Back to top </a>


                <table class="table w-50 mx-auto table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">Country</th>
                      <th scope="col">Percentage</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="column" items="${task1}">
                      <tr>
                        <td class="text-center">
                          <c:out value="${column[0]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[1]}" />
                        </td>

                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>

              <div id="Query2">
                <h3>
                  Query 2
                </h3>
                <a href="#" class="btn btn-link"> Back to top </a>


                <table class="table w-50 mx-auto table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">Country</th>
                      <th scope="col">Number of cities</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="column" items="${task2}">
                      <tr>
                        <td class="text-center">
                          <c:out value="${column[0]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[1]}" />
                        </td>

                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>

              <div id="Query3">
                <h3>
                  Query 3
                </h3>
                <a href="#" class="btn btn-link"> Back to top </a>


                <table class="table w-50 mx-auto table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">City</th>
                      <th scope="col">Population</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="column" items="${task3}">
                      <tr>
                        <td class="text-center">
                          <c:out value="${column[0]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[1]}" />
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>

              <div id="Query4">
                <h3>
                  Query 4
                </h3>
                <a href="#" class="btn btn-link"> Back to top </a>


                <table class="table w-50 mx-auto table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">Country</th>
                      <th scope="col">Language</th>
                      <th scope="col">Percentage</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="column" items="${task4}">
                      <tr>
                        <td class="text-center">
                          <c:out value="${column[0]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[1]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[2]}" />
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>

              <div id="Query5">
                <h3>
                  Query 5
                </h3>
                <a href="#" class="btn btn-link"> Back to top </a>


                <table class="table w-50 mx-auto table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">Country</th>
                      <th scope="col">Surface Area </th>
                      <th scope="col">Population</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="column" items="${task5}">
                      <tr>
                        <td class="text-center">
                          <c:out value="${column[0]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[1]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[2]}" />
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>

              <div id="Query6">
                <h3>
                  Query 6
                </h3>
                <a href="#" class="btn btn-link"> Back to top </a>


                <table class="table w-50 mx-auto table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">Country</th>
                      <th scope="col">Goverment Form </th>
                      <th scope="col">Capital</th>
                      <th scope="col">Life Expectency</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="column" items="${task6}">
                      <tr>
                        <td class="text-center">
                          <c:out value="${column[0]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[1]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[2]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[3]}" />
                        </td>

                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>

              <div id="Query7">
                <h3>
                  Query 7
                </h3>
                <a href="#" class="btn btn-link"> Back to top </a>


                <table class="table w-50 mx-auto table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">City</th>
                      <th scope="col">Country </th>
                      <th scope="col">District </th>
                      <th scope="col">Population</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="column" items="${task7}">
                      <tr>
                        <td class="text-center">
                          <c:out value="${column[0]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[1]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[2]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[3]}" />
                        </td>

                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>

              <div id="Query8">
                <h3>
                  Query 8
                </h3>
                <a href="#" class="btn btn-link"> Back to top </a>


                <table class="table w-50 mx-auto table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">Region</th>
                      <th scope="col">Number of Countries </th>

                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="column" items="${task8}">
                      <tr>
                        <td class="text-center">
                          <c:out value="${column[0]}" />
                        </td>
                        <td class="text-center">
                          <c:out value="${column[1]}" />
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>
            </div>




            <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
          </body>

          </html>