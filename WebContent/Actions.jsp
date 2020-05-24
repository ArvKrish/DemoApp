<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ak.Keys"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RPG - Welcome ${playerName}</title>
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
	<div class="header">
		<span class="greet"> Hey ${playerName}! </span> <span class="status">Health:
			${playerHealth}<br>Power: ${playerPower}
		</span>
	</div>
	<br />
	<br />

	<h4>Choose an action!</h4>
	<div class="form">
		<form action="Move" method="post">
			<button name="Action" value="strike" type="submit"
				title="Current health: ${playerHealth}. Health after attack: ${playerHealth-(playerHealth*playerPower/200)}">Strike</button>
			<button name="Action" value="strikeAll" type="submit"
				title="Current health: ${playerHealth}. Health after attack: ${(playerHealth-(playerHealth*playerPower/200)*villainSize)<1?0:(playerHealth-(playerHealth*playerPower/200)*villainSize)}">Strike
				All</button>
			<button name="Action" value="boost" type="submit"
				title="Boosts energy by ten percent">Boost Energy</button>
			<button name="Action" value="addVillain" type="submit">Add
				New Villain</button>
			<button name="Action" value="showVillain" type="submit">Show
				All Villain</button>
			<button name="Action" value="compliment" type="submit">Compliment</button>
			<button name="Action" value="showCompliment" type="submit">Show
				Compliment</button>
			<button name="Action" value="summary" type="submit">Get
				Summary</button>
			<button name="Action" value="exit" type="submit">Exit</button>

		</form>
	</div>
	<h4 style="margin-left: 100px; margin-bottom: -50px;">Status:</h4>
	<div class="message">


		<p class="info">${Message}</p>

	</div>
</body>
</html>