<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="models.Product, java.util.*" %>
	<%
		List<Product> products = (List<Product>) session.getAttribute("products");
		for (Product product : products) {
	%>
		<h1><%= product.getName() %></h1>
	<% } %>
</body>
</html>