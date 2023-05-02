<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix = "c" uri
="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

    <meta charset="UTF-8" />
    <title>Omkiji Form</title>
  </head>
  <body>
    <h1 class="mt-3 text-center">Send an Omikuji!</h1>
    <div class="container mx-auto w-50 border shadow mt-5 rounded-5 mb-5">
      <form method="POST" action="/omikuji/handleform">
        <div class="mb-3 mt-3">
          <label for="num"> Pick any number from 5 to 25 </label>
          <!-- <select class="form-select" aria-label="Default select example" name="num">
                  <option selected>Pick a numeber? </option>
                  <% for(int i = 5; i <= 25; i++) { %>
                    <option value="<%= i %>" style="width: 4rem"><%= i %></option>
          
                    <% } %>

                </select> -->
          <input class="form-control" type="number" min="5" max="25" name="num" />
        </div>

        <div class="mb-3">
          <label for="city" class="form-label"
            >Enter the name of any city.</label
          >
          <input type="text" name="city" class="form-control" id="city" />
        </div>
        <!-- 
              <div class="mb-3">
                <label for="person_name" class="form-label">Enter the name of any real person</label>
                <input  type="text" name="person_name" class="form-control" id="person_name">
              </div> -->

        <div class="mb-3">
          <label for="person_name" class="form-label"
            >Enter the name of any real person</label
          >
          <input
            type="text"
            name="person_name"
            class="form-control"
            id="person_name"
          />
        </div>

        <div class="mb-3">
          <label for="hobby" class="form-label"
            >Enter professional endeavor or hobby:</label
          >
          <input type="text" name="hobby" class="form-control" id="hobby" />
        </div>

        <div class="mb-3">
          <label for="living_thing" class="form-label">
            Enter any type of living thing.</label
          >
          <input
            type="text"
            name="living_thing"
            class="form-control"
            id="living_thing"
          />
        </div>

        <div class="mb-3">
          <label for="say_something" class="form-label">
            Say something nice to someone:</label
          >
          <textarea
            type="text"
            name="say_something"
            class="form-control"
            id="say_something"
            cols="5"
            rows="10"
          ></textarea>
        </div>
        <div class="mb-3 mx-auto text-center">
          <p>Send and show a friend</p>
          <button type="submit" class="btn btn-primary">Send</button>
        </div>
      </form>
    </div>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
