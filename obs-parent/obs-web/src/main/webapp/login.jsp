<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="obs" tagdir="/WEB-INF/tags"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<obs:header title="Online Book Store"></obs:header>
<body>


	<c:if test="${(!auth.authenticated) and (auth.user != null)}">
		<obs:message type="ERROR">Wrong username or password</obs:message>
	</c:if>

	<form action="/login" method="post">
		
			
		<!--  in action= "controller  servlet" die de login method afhandelt in de LoginServlet -->
		<br /> Gebruikersnaam <input class=".ui-corner-all" type="text" name="username" /> <br />
		Wachtwoord <input class=".ui-corner-all" type="password" name="password" /> <br /> <br />
		<input  type="submit" value="Inloggen" /> <input type="submit"
			value="Annuleren" />
	</form>

</body>
</html>
