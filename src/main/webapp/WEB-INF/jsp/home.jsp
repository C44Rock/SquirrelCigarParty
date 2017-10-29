<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title>Squirrel Page</title>
</head>

<body>
	<h2>Squirrel Parties For Dummies</h2>
	<h4>THE HOTTEST SELLING BOOK IN THE WORLD</h4>
	<h5>Get your copy before it's too late</h5>
	
	<p>Already read the book? Write a review below!</p>
	<c:url var="reviewLink" value="/reviews"/>
	<a href = "${reviewLink}">Review Here</a><br>
	
	<img src = "pics/forDummies.png" alt = "squirrel parties for dummies book">
	
	<c:forEach var = "review" items = "${reviews}">
		<p>-----------------------------------------------------------</p>
		<p>${review.title}</p>
		<p>by ${review.username} on ${review.dateSubmitted}</p>
		<p>${review.rating}</p>
		<p>${review.text}</p>
		<p>-----------------------------------------------------------</p>
	</c:forEach>
</body>

</html>