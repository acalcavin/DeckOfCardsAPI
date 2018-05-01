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

<style>
body {
  padding: 15px 0;
}

.container {
  width: 80%;
  max-width: 1200px;
  margin: 0 auto;
}

.container * {
  box-sizing: border-box;
}

.flex-outer,
.flex-inner {
  list-style-type: none;
  padding: 0;
}

.flex-outer {
  max-width: 850px;
  margin: 0 auto;
  justify-content: center;
}

.flex-outer li,
.flex-inner {
  display: flex;
  flex-wrap: wrap;
  
}

.flex-inner {
  padding: 0 8px;
  justify-content: space-between;  
}

.flex-outer > li:not(:last-child) {
  margin-bottom: 20px;
}

.flex-outer li label,
.flex-outer li p {
  padding: 8px;
  font-weight: 300;
  letter-spacing: .09em;
}

.flex-outer > li > label,
.flex-outer li p {
  flex: 1 0 120px;
  max-width: 220px;
}

.flex-outer > li > label + *,
.flex-inner {
  flex: 1 0 220px;
}

.flex-outer li p {
  margin: 0;
}

.flex-outer li input:not([type='checkbox']),
.flex-outer li textarea {
  padding: 15px;
  border: none;
}

.flex-inner li {
  width: 150px;
}

.card {
	width: 150px;
	margin: 10px;
	text-align: center;
	light-height: 75px;
	font-size: 20px;
}

.flex-outer button {
	margin: auto;
	color: #fff;
	background-color: #2A9D8F;
	transition-duration: 0.4s;
	border-color: white;
}

.zoom {
    transition: transform .2s; 
}
.zoom:hover {
    transform: scale(1.1);
}
</style>

</head>
<body>

<div class="container-fluid"> 
	<div class="container">
	<br>
		<div class="box">
			<h2>Here's your hand:</h2>
			<br>

<form action="discard" method="post">
	<input type="hidden" name="id" value="${deckId}">
  <ul class="flex-outer">
    
    <li>
      <ul class="flex-inner">
      
      	<c:forEach var="myVar" items="${cardList}">
			
			<li>
			<div class="card">
				<div class="zoom">
				<img src="${myVar.image}" height=200>
				</div>
				<br>
				
				<p>${myVar.value} of ${myVar.suit}</p>
		   
				<input type="checkbox" name=cardID value="${myVar.cardID}" id="discard-box">
				
				<label for="discard-box"> <span style="color:black;text-transform:uppercase;font-size: 14px;">Discard</span></label>
			</div>
		   
			</li>		

		</c:forEach>
      
      </ul>
    </li>

  </ul>
  	<h3>
	<input type="submit" class="btn btn-primary btn-lg" value="Discard and Draw »">
  	</h3>
	
</form>

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