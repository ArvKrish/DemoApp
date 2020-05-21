<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ak.Keys" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RPG - Welcome ${playerName}</title>
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
<div class="header">
<h3>Welcome ${playerName }</h3>
</div>
<div class="form">
<form action="Action" method="post">
<label for="oname">Villain Name&emsp;</label>
<input name="oname" type="text" max="10" placeholder="Enter here" size="20" maxlength="11"required>
<br/><br/>
<label for="key">Code &ensp; &ensp; &ensp; &ensp; &ensp;&ensp;	</label>
<input name="key" type="number" min="1" max="100" size="20" placeholder="Enter a code" required>
<input type="submit"  value="Submit">

</form>
</div>
</body>
</html>