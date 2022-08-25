<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.content {
  max-width: 500px;
  margin: auto;
}
</style>
<meta charset="ISO-8859-1">
<title>Feedback form</title>
</head>
<body>
<h1 class="content">Feedback Form</h1><br><br>
<div class="content">
  <form method="post" action="/feedback">
<label for="firstname">First Name :</label>
    <input type="text" id="firstname" name="firstname" placeholder="First Name" required>
<br><br><br>
    <label for="lastname">Last Name :</label>
    <input type="text" id="lastname" name="lastname" placeholder="Your last name" required>
<br><br><br>
<label for="email">Email Id : </label>
    <input type="email" id="email" name="email" placeholder="Your Email Address" required>
<br><br><br>
    <label for="feedback1">Feedback :</label>
    <textarea id="feedback1" name="feedback1" placeholder="Comments" style="height:200px" required></textarea>
<br><br><br>
     <input type="submit" value="Submit">

  </form>
  </div>
</body>
</html>