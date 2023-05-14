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
            <title>Confirmation page, all books</title>
            <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
          </head>

          <body>
            <div class="container mt-5">
              <div class="d-flex justify-content-between">
                <hgroup>
                  <h1>Welcome, ${thisUser.firstName} !</h1>
                  <a href="/projects/new" class="btn btn-link"> Add a project</a>
                </hgroup>

                <div>
                  <a href="/logout" class="btn btn-link"> Logout</a> <br>

                </div>
              </div>
              <h3>All the projects </h3>
              <table class="table w-75 mx-auto">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Project</th>
                    <th scope="col">team lead </th>
                    <th scope="col"> due date</th>
                    <th scope="col"> actions </th>
                  </tr>
                </thead>
                <tbody>


                  <c:forEach var="project" items="${notProjects}">
                    <tr>
                      <td class="text-center">
                        <c:out value="${project[0]}" />
                      </td>
                      <td class="text-center">
                        <a href="/projects/${project[0]}">${project[1]}</a>
                      </td>
                      <td class="text-center">
                        <c:out value="${project[2]}" />
                      </td>
                      <td class="text-center">
                        <c:out value="${project[3]}" />
                      </td>
                      <td>
                        <a href="/projects/${project[0]}/join">Join team</a>
                      </td>
                    </tr>
                  </c:forEach>




                  <!-- <c:forEach items="${notallprojects}" var="project">
                    <tr>
                      <th scope="row">${projct.id}</th>
                      <td><a href="/projects/${project.id}">${project.title}</a> </td>
                      <td>${project.leader.firstName}</td>
                      <td>${project.dueDate}</td>
                      <td><a href="/projects/${project.id}/join">Join team</a></td>
                    </tr>
                  </c:forEach> -->

                </tbody>
              </table>
              <h3>Your Projects </h3>
              <table class="table w-75 mx-auto">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Project</th>
                    <th scope="col">team lead </th>
                    <th scope="col"> due date</th>
                    <th scope="col"> actions </th>
                  </tr>
                </thead>
                <tbody>
                  <!-- <c:forEach items="${allprojects}" var="project">
            <tr>
              <th scope="row">${project.id}</th>
              <td><a href="/projects/${project.id}">${project.title}</a> </td>
              <td>${project.leader.firstName}</td>
              <td>${project.dueDate}</td>
              <c:choose>
                <c:when test="${newUser == project.leader.id}">
                  <td class="d-flex"><a href="/projects/${project.id}/edit" class="btn btn-link">Edit</a>

                    <form action="/projects/${project.id}/delete" method="post">
                      <input type="hidden" name="_method" value="delete">

                      <button type="submit" class="btn btn-link text-danger"> Delete</button>
                    </form>
                  </td>

                </c:when>
                <c:otherwise>
                  <td>
                    <a href="/projects/${project.id}/leave">Leave </a>
                  </td>


                </c:otherwise>
              </c:choose>
            </tr>
          </c:forEach> -->

                  <tr>
                    <c:forEach var="column" items="${fromUser}">
                  <tr>
                    <td class="text-center">
                      <c:out value="${column[0]}" />
                    </td>
                    <td class="text-center">
                      <a href="/projects/${column[0]}">${column[1]}</a>
                    </td>
                    <td class="text-center">
                      <c:out value="${column[2]}" />
                    </td>
                    <td class="text-center">
                      <c:out value="${column[3]}" />
                    </td>
                    <c:if test="${newUser eq column[4]}">
                      <td class="d-flex">
                        <a href="/projects/${column[0]}/edit" class="btn btn-link">Edit</a>
                        <form action="/projects/${column[0]}/delete" method="post">
                          <input type="hidden" name="_method" value="delete">
                          <button type="submit" class="btn btn-link text-danger">Delete</button>
                        </form>
                      </td>
                    </c:if>
                    <td>
                      <c:if test="${newUser != column[4]}">
                        <a href="/projects/${column[0]}/leave">Leave</a>
                      </c:if>
                    </td>





                  </tr>
                  </c:forEach>
                  </tr>

                </tbody>
              </table>




            </div>

            <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
          </body>

          </html>