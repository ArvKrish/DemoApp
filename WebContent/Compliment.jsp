<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ak.Keys" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="index.css">
<title>RPG - Welcome ${playerName }</title>
</head>
<body>

<br/>
<form class="form" action="GetCompliment" class="form" method="post">
<label for="compliment">Enter Compliment </label>
<input name="compliment" type="text" max="10" placeholder="Enter here" size="15" maxlength="11"  required>
<input type="submit" name="submit" value="value">
</form>
</body>
</html>