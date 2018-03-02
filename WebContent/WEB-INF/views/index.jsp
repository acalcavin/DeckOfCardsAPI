<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring MVC</title>
</head>
<body>
	<br>
	<div style="text-align:center">
		<h2>
			Let's Draw<br> <br>
		</h2>
		<h2>
		${deckId}
		</h2>
		<h3>
			<a href="welcome?id=${deckId}">Click here to draw 5 cards</a>
		
		</h3>
	</div>
</body>
</html>