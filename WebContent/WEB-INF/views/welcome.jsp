<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your 5 cards</title>
</head>
<body>
<h2>Here's your hand:</h2>
${cards}
<br><br>

${deckId}
<br>
<form action="drawAgain" method="post">
<button type=submit name="drawAgain">Draw again</button> 
</form>

<br><br>

<button type=submit>Make your wager</button>
</body>
</html>