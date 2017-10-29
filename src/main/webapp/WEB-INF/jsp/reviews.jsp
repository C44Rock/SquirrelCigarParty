<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title>Squirrel Review</title>
</head>

<body>
	<h2>Write a Review!</h2>
	
	<form action = "reviews" method = "POST">
		<label for = "username">Username</label>
		<input type = "text" name = "username"/><br>
		<label for = "rating">Rating</label>
		<input type = "text" name = "rating"/><br>
		<label for = "title">Title</label>
		<input type = "text" name = "title"/><br>
		<label for = "text">Text</label>
		<input type = "text" name = "text"/><br>
		
		<input type = "submit"/>
	</form>
</body>

</html>