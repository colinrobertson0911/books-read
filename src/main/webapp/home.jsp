<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome to My Book Tracker</title>
	
</head>
<body>
	<header>
		<nav>
			<div>
				<div>
					<a href="home"><img alt="logo - Books Read" src="#"></a>
				</div>
				<ul>
					<li><a href="">Home</a></li>
					<li><a href="/search">Search</a></li>
				</ul>			
			</div>		
		</nav>
	</header>
	<section>
			<c:forEach var="book" items="${books}">
				<div>
					<div>
						<div>${book.title}</div>
						<c:if test="${!empty(book.series)}">
							<div>${book.series}</div>
						</c:if>
						<c:forEach items="${book.authors}" var="author">
							<div>${author.fullName}</div>
						</c:forEach>
						<div>${book.read}</div>
						<div>-----------</div>
					</div>
				</div>
			</c:forEach>
		
	</section>
</body>
</html>