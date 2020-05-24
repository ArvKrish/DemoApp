<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ak.Keys"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="index.css">
<title>RPG - Welcome ${playerName}</title>
</head>
<body>
	${Message}
	<br />
	<div class="form">
		<form action="GetOpponent" method="post">
			<label for="oname">Name </label> <input name="oname" type="text"
				max="10" placeholder="Enter here" size="15" maxlength="11" required>
			<input type="submit" name="submit" value="value">
		</form>

		<br /> (or) <br /> <br />

		<form action="GetOpponent" method="post">
			<label for="key">Code </label> <input name="key" type="number"
				min="1" max="100" required> <input type="submit"
				name="submit" value="key">
		</form>

	</div>

</body>
</html>