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

										</div>

									</li>

								</c:forEach>

							</ul>
						</li>

					</ul>

				</form>
				<h2>Dealer's hand:</h2>
				<br>
				<form>
					
					<ul class="flex-outer">

						<li>
							<ul class="flex-inner">

								<c:forEach var="myVar" items="${dealerHand}">

									<li>
										<div class="card">
											<div class="zoom">
												<img src="${myVar.image}" height=200>
											</div>
											<br>

											<p>${myVar.value} of ${myVar.suit}</p>

										</div>

									</li>

								</c:forEach>

							</ul>
						</li>

					</ul>

				</form>
				<h3>
					<a class="btn btn-primary btn-lg" href="./" role="button">Play Again »</a>
				</h3>

				<br><br>

			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>