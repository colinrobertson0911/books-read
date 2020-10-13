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
			<div>
				
				<form action="searchByTitle" method="post">
					<div>
						<label>Search By Title: </label><input type="text" name="title"/>
						<button type="submit">Search</button>
					</div>
				</form>
			</div>	
			<div>
				<form action="searchBySeries" method="post">
					<div>
						<label>Search By Series: </label><input type="text" name="series"/>
						<button type="submit">Search</button>
					</div>
				</form>
			</div>
		</div>
		
			<div class="col col--4 last--col">
					
				<div>
					<form action="searchByAuthor" method="post">
						
						<label>Search By Author: </label><input type="text" list="authors" name="fullName">
						<datalist id="authors">
							<c:forEach items="${authors}" var="authors">
								<option value="${authors.fullName}">
							</c:forEach>
						</datalist>
						<input type="submit" value="search" /> 
					</form>
				</div>	
				<div>
					<form action="searchNotRead" method="post">
						<div>
							<label>Search Books Not Read: </label>
							<button type="submit">Search</button>
						</div>
					</form>
				</div>	
			</div>		
		
	</header>
	<div class="page-container">
	<h3>${visabilityMessage}</h3>
			<c:forEach var="book" items="${books}">
				<div>
					<div  class="col col--2 books">
						<div class="title">${book.title}</div>
						<c:if test="${!empty(book.series)}">
							<div class="series">${book.series}</div>
						</c:if>
						<c:forEach items="${book.authors}" var="author">
							<div class="author">${author.fullName}</div>
						</c:forEach>
						<div class="read">
							<label>Read: </label>
							${book.read}
						</div>
					</div>
				</div>
			</c:forEach>
		
	</div>
</body>
</html>