<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit book</title>
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
	<h2>Editing book: ${book.title}</h2>
	<f:form method="post" action="editBookSubmit" modelAttribute="book">
		<div>
			<f:label path="title">Title:</f:label>
			<f:input path="title" type="text" required="required"/>
		</div>
		<div>
			<f:label path="series">Series:</f:label>
			<f:input path="series" type="text" />
		</div>
		<div>
			<f:label path="authors">Authors:</f:label>
			<f:select path="authors" items="${authors}" itemLabel="fullName" itemValue="authorId" multiple="multiple" required="required"/>
		</div>
		<div>
			<f:label path="read">Read:</f:label>
			<f:checkbox path="read" />
		</div>
		<div>
			<f:label path="dateRead">Date read:</f:label>
			<f:input path="dateRead" type="date" />
		</div>
		<div>
			<f:label path="asin">ASIN:</f:label>
			<f:input path="asin" type="text" required="required"/>
		</div>
		<div>
			<f:label path="publishedDate">Published:</f:label>
			<f:input path="publishedDate" type="date" required="required"/>
		</div>
		<div>
			<button type="submit">Update Book</button>
		</div>
		<f:hidden path="bookId"/>
	</f:form>
</body>
</html>