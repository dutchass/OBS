<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
	<jsp:directive.page import="nl.obs.core.model.AuthenticationModel" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login pagina</title>
</head>
<body>

	${((!auth.authenticated) and (auth.user != null)) ? "LOGIN FAILED!" : ""}

	<FORM action="/login" method="post">
		<!--  in action= "controller  servlet" die de login method afhandelt in de LoginServlet -->
		<br /> Gebruikersnaam <INPUT type="text" name="username" /> <br />
		Wachtwoord <INPUT type="password" name="password" /> <br /> <br /> <INPUT
			type="submit" value="Inloggen" /> <INPUT type="submit"
			value="Annuleren" />
	</FORM>

</body>
	</html>
</jsp:root>