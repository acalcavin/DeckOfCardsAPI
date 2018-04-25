<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link href="resources\\styles.css" rel="stylesheet" />

<title>Five-Card Draw</title>

</head>
<body>
<div class="container-fluid">
	<img src='resources\\blackjack2.png' class="card-image">

	
	<div class="container">
		<br>
		<div class="box">
			<h1>Let's Draw!</h1>
		</div>
		<br>
		<div class="box">
			<h2>Feeling Lucky?</h2>
				
			<!-- 		<h3>
				<a href="welcome?id=${deckId}">Click here to draw 5 cards</a>
			</h3>  -->
			
			<br>
			<h3>Click to draw 5 cards:</h3>
			<h3><a class="btn btn-primary btn-lg" href="play?id=${deckId}" role="button">Draw »</a></h3>
		</div>
		<br>
		<br> 
	</div>
	<div class="deckofcards">
	<h4>Powered by <a href="http://deckofcardsapi.com/">Deck of Cards API</a></h4>
	</div>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>