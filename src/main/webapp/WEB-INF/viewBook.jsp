<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome to My Book Tracker</title>
	<link rel="stylesheet" href="css/stylesheet.css" type="text/css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<header class="row">
		<div class="col col--2">
			<a href="home"><img class="imgBook" alt="logo - Books Read" src="images/openBook.jpg" style="width: 60%"/></a>
		</div>
	</header>
	
	<div>
			
		<div  class="col col--4 books">
			<div class="title">
			<label>Title: </label>${book.title}</div>
			<c:if test="${!empty(book.series)}">
				<div class="series">
				<label>Series: </label>${book.series}</div>
			</c:if>
			<c:forEach items="${book.authors}" var="author">
				<div class="author">
				<label>Author: </label>${author.fullName}</div>
			</c:forEach>
			<div>
				<label>Read: </label>
				<span class="read">${book.readFormatted}</span>
			</div>
			<c:if test="${(book.read) == true}">
				<div>
					<label>Date Read: </label>
					<span>${book.dateReadFormatted}</span>
				</div>
			</c:if>
			<div>
				<label>ASIN: </label>
				<span>${book.asin}</span>
			</div>
			<div>
				<label>Published: </label>
				<span>${book.publishedDateFormatted}</span>
			</div>
		</div>
		
	</div>
</body>
</html>