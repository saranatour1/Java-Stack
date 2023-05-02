<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Result page</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>

  <div class="container">
    <h1 class="mt-4 text-center">Here's Your Omikuji!</h1>
 
    <h1>${sara}</h1>



    <div class="card w-50 mx-auto">
      <div class="card-body" style="background-color: rgba(164, 255, 255, 0.531);">
        <p>
          In <span><c:out value="${num}" /></span> years, you will live in
          <span><c:out value="${city}" /></span>
          with
          <span><c:out value="${person_name}" /></span> as your roommate,
          <span><c:out value="${hobby}" /></span> for a living. The next time you
          see a <span><c:out value="${living_thing}" /></span> , you will have good
          luck. Also, <span><c:out value="${say_something}" /></span> .
        </p>
      </div>
    </div>

    <div class="text-center mt-4">
      <a href="/omikuji" class="btn btn-primary">Go Back</a>
    </div>

  </div>

  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
