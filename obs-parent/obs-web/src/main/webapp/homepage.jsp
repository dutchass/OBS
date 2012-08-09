<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="obs" tagdir="/WEB-INF/tags" %>
<%@ page import="nl.obs.web.tag.MessageType" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Online Book Store</title>
<link type="text/css" href="css/start/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
<script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//testing code
</script>
<style type="text/css">
body {
	font: 62.5%"Trebuchet MS", sans-serif;
	margin: 50px;
}
</style>

</head>
<body>
	<obs:message type="WARNING">Message here!</obs:message>
	<p>
		<c:choose>
			<c:when test="${auth.authenticated == true}">
		Welkom ${auth.user.username} !
		</c:when>
			<c:otherwise>
		Click <a href="/login">here</a> to login.
		</c:otherwise>
		</c:choose>
	</p>
</body>
</html>