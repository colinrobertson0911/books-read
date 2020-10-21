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
		<div class="col col--6">
			<h1 class="page-title">Books Read</h1>
		</div>
		<nav>
			
			<div class="col col--2 last--col">
				<div>
					<a href="search">Search Books</a>
				</div>
				<div>
					<a href="addBook">Add Book</a>
				</div>
				<div>
					<a href="addAuthor">Add Author</a>
				</div>
			</div>		
		</nav>
	</header>
	
	<div class="page-container">
	<h3>${visabilityMessage}</h3> <span class="error">${errorMessage}</span>
			<c:forEach var="book" items="${books}">
				<div>
					<a href="viewBook?bookId=${book.bookId}">
					<div class="col col--3 books">
						<div class="title">${book.title}</div>
						<c:if test="${!empty(book.series)}">
							<div class="series">${book.series}</div>
						</c:if>
						<c:forEach items="${book.authors}" var="author">
							<div class="author">${author.fullName}</div>
						</c:forEach>
						<div class="read">
							<label>Read: </label>
							${book.readFormatted}
						</div>
					</div>
					</a>
				</div>
			</c:forEach>
		
	</div>
</body>
</html>