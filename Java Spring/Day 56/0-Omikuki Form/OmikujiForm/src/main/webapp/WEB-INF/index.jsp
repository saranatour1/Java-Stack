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
    <div class="container mx-auto w-50 ">
        <h1 class="mt-3 ">Send an Omikuji!</h1>
        <form method="POST" action="/omikuji/handleform">
            <!-- <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
              </div> -->

              <div class="mb-3"> 
                <label for="num"> Pick any number from 5 to 25 </label>
                <select class="form-select" aria-label="Default select example" name="num">
                  <option selected>Pick a numeber? </option>
                  <% for(int i = 0; i <= 25; i++) { %>
                    <option value="<%= i %>" style="width: 4rem"><%= i %></option>
          
                    <% } %>

                </select>
              </div>
 
              <div class="mb-3">
                <label for="city" class="form-label">Enter the name of any city.</label>
                <input  type="text" name="city" class="form-control" id="city">
              </div>

              <div class="mb-3">
                <label for="person_name" class="form-label">Enter the name of any real person</label>
                <input  type="text" name="person_name" class="form-control" id="person_name">
              </div>
      
              <div class="mb-3">
                <label for="person_name" class="form-label">Enter the name of any real person</label>
                <input  type="text" name="person_name" class="form-control" id="person_name">
              </div>

              <div class="mb-3">
                <label for="hobby" class="form-label">Enter professional endeavor or hobby:</label>
                <input  type="text" name="hobby" class="form-control" id="hobby">
              </div>
      

            <div>
              <label for="hobby"></label>
              <input type="text" name="hobby" />
            </div>
      
            <div>
              <label for="living_thing"> Enter any type of living thing.</label>
              <input type="text" name="living_thing" />
            </div>
      
            <div>
              <label for="say_something">Say something nice to someone:</label>
              <textarea name="say_something" cols="15" rows="10"></textarea>
            </div>
      
            <div>
              <label for="send">Send and show a friend</label>
              <input type="submit" value="send" />
            </div>
          </form>
    </div>



    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
