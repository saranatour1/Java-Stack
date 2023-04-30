<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Result page</title>
  </head>
  <body>
    <h1>Here's Your Omikuji!</h1>

    <p>
      In <span><c:out value="${num}" /></span> years, you will live in
      <span><c:out value="${city}" /></span>
      with
      <span><c:out value="${person_name}" /></span> as your roommate,
      <span><c:out value="${hobby}" /></span> for a living. The next time you
      see a <span><c:out value="${living_thing}" /></span> , you will have good
      luck. Also, <span><c:out value="${say_something}" /></span> . Go Back
    </p>
  </body>
</html>
