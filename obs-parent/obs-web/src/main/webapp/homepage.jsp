<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="obs" tagdir="/WEB-INF/tags"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<obs:header title="Online Book Store"></obs:header>
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