<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="obs" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<obs:head title="Online Book Store" />
<body>

	<div style="width: 50%; margin: 0px auto;">
		<c:if test="${(!auth.authenticated) and (auth.user != null)}">
			<obs:message type="ERROR">Verkeerde gebruikersnaam of wachtwoord!</obs:message>
		</c:if>

		<form action="/login" method="post">


			<!--  in action= "controller  servlet" die de login method afhandelt in de LoginServlet -->
			<br /> Gebruikersnaam <input class=".ui-corner-all" type="text"
				name="username" /> <br /> Wachtwoord <input class=".ui-corner-all"
				type="password" name="password" /> <br /> <br /> <input
				type="submit" value="Inloggen" /> <input type="submit"
				value="Annuleren" />
		</form>
	</div>
</body>
</html>
