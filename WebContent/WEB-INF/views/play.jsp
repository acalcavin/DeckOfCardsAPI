<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link href="resources\\styles.css" rel="stylesheet" />

<title>Play</title>


</head>
<body>

<div class="container-fluid"> 
	<div class="container">
	<br>
		<div class="box">
			<h2>Here's your hand:</h2>
			
			<div class="flex-container">
			<c:forEach var="myVar" items="${cardList}">
				<div>
				<img src="${myVar.image}" height=200><br>
				<p>${myVar.value} of ${myVar.suit}</p><br>
				</div>
			</c:forEach>
			</div>

	<form action="discard" method="post">
		<input type="hidden" name="id" value="${deckId}">
		<input type="checkbox" name="cardID" value=1>
		<input type="checkbox" name="cardID" value=2>
		<input type="checkbox" name="cardID" value=3>
		<input type="checkbox" name="cardID" value=4>
		<input type="checkbox" name="cardID" value=5>
		<input type="submit" class="btn btn-primary btn-lg" value="Discard">
	</form>

			<h3><a class="btn btn-primary btn-lg" href="discard?id=${deckId}" role="button">Discard and Draw »</a></h3>
			<br>
			<br>
			<h3><a class="btn btn-primary btn-lg" href="TKTK"  role="button">Show dealer's hand »</a></h3>
			<br>
			<br>

		</div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>