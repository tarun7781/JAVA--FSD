<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Products Details</h3>
<c:set var="product" value="${obj }"></c:set>
Id: ${product.id } <br>
Name: ${product.name } <br>
Price: ${product.price } <br><br>
<a href="update.jsp">Update the product</a> <br><br>
<a href="index.jsp">Home Page</a>
</body>
</html>
