<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ninja Gold Game</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  </head>
  <body>
    <div class="container mt-5">
      <!-- The Total Gold amount start -->
      <div class="row">
        <div class="col-4 offset-4 text-center">
          <h4>Your Gold:</h4> 
          <!-- Fix the value later  -->
          <input type="number" class="form-control text-center" name="total_gold" value="${gold}" disabled>
        </div>
      </div>
      <!-- the total gold amount finish -->
  
      <!-- Start of forms -->
      <div class="row mt-5">
        <div class="col-3">
          <form action="/handleform" method="post" class="card h-100">
            <!-- farm form -->
            <input type="hidden" name="formtype" value="farm">
            <div class="card-body text-center">
              <h5 class="card-title">Farm</h5>
              <p class="card-text">Earns (10 - 20 golds)</p>
              <button type="submit" class="btn btn-primary">Find Gold</button>
            </div>
          </form>
        </div>
  
        <div class="col-3">
          <form action="/handleform" method="post" class="card h-100">
            <!-- Cave form -->
            <input type="hidden" name="formtype" value="cave">
            <div class="card-body text-center">
              <h5 class="card-title">Cave</h5>
              <p class="card-text">Earns (5 - 10 golds)</p>
              <button type="submit" class="btn btn-primary">Find Gold</button>
            </div>
          </form>
        </div>
  
        <div class="col-3">
          <form action="/handleform" method="post" class="card h-100">
            <!-- House form -->
            <input type="hidden" name="formtype" value="house">
            <div class="card-body text-center">
              <h5 class="card-title">House</h5>
              <p class="card-text">Earns (2 - 5 golds)</p>
              <button type="submit" class="btn btn-primary">Find Gold</button>
            </div>
          </form>
        </div>
  
        <div class="col-3">
          <form action="/handleform" method="post" class="card h-100">
            <!-- Quest form -->
            <input type="hidden" name="formtype" value="quest">
            <div class="card-body text-center">
              <h5 class="card-title">Quest</h5>
              <p class="card-text">Earns/Takes (0 - 50 golds)</p>
              <button type="submit" class="btn btn-primary">Find Gold</button>
            </div>
          </form>
        </div>
        <!-- New form -->

        <div class="col-8 mt-3 mx-auto">
          <form action="/handleform" method="post" class="card h-100">
            <!-- Quest form -->
            <input type="hidden" name="formtype" value="spa">
            <div class="card-body text-center">
              <h5 class="card-title">Spa </h5>
              <p class="card-text">Takes (5 - 20) golds</p>
              <button type="submit" class="btn btn-primary">Find Gold</button>
            </div>
          </form>
        </div>

        <div class="col-5 mt-3 mx-auto">
          <form action="/reset" method="post" class="card h-100">
            <!-- Quest form -->
              <button type="submit" class="btn btn-primary">Reset</button>
          
          </form>
        </div>
        </div>

              <!-- Activities -->
      <h3 class="mt-4 mb-4">Activites: </h3>
      <div class="card rounded w-100 h-100 border" style="height: 20rem !important; overflow-y: auto !important; "> 
        <!-- For each here -->
        <!-- Not rendering ?!?!??! -->
        <c:forEach var="activity" items="${activities}">
          <p class="ms-3 mt-3"><c:out value="${activity}" escapeXml="false" ></c:out></p>
      </c:forEach>


        

      </div>
      </div>
      <!-- end of forms -->




    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
