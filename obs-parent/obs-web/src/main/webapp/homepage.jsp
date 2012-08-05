<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
    <jsp:directive.page language="java" import="nl.obs.core.db.entity.User"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Online Book Store</title>
</head>
<body>


<H3>Login succesvol!</H3>
															
<jsp:useBean id="user" class="nl.obs.core.db.entity.User" scope="request"> 
<jsp:setProperty property="username" name="user" value="Nieuwe gebruiker"/>
</jsp:useBean>

Welkom <jsp:getProperty property="username" name="user"/>!
					
															
</body>
</html>
</jsp:root>