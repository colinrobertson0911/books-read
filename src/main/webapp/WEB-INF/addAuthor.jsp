<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Adding an Author</title>
	<link rel="stylesheet" href="css/stylesheet.css" type="text/css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<header class="row">
		<div class="col col--2">
			<a href="home"><img class="imgBook" alt="logo - Books Read" src="images/openBook.jpg" style="width: 60%"/></a>
		</div>
		<div class="col col--6">
			<h1 class="page-title">Books Read</h1>
		</div>
		
	</header>
	<h2>Add an Author</h2>
	<f:form method="post" action="addAuthorSubmit" modelAttribute="author">
		<div>
			<f:label path="fullName">Full Name:</f:label>
			<f:input path="fullName" type="text" required="required"/>
		</div>
		
		<div>
			<button type="submit">Add Author</button>
		</div>
	</f:form>
</body>
</html>