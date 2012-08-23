<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="obs" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<obs:head title="Order Overview" />
<obs:pageheader />
<body>
	<obs:userInfo />
	<obs:customerInfo />
	
	<c:choose>
		<c:when test="${auth.authenticated== true}">
		<section>
			<p>U gaat ${shoppingCartModel.totalAmount} boeken kopen voor een totaal van ${shoppingCartModel.totalPrice}, weet u dit zeker?</p>
			<section>
				<p><a href="?action=finalize">ja</a></p>
				<p><a href="/cart/">nee</a></p>
			</section>
		</section>
		</c:when>
		<c:otherwise>
		<obs:message type="WARNING">U dient ingelogd te zijn om uw bestelling af te ronden.</obs:message>
		</c:otherwise>
	</c:choose>
</body>
</html>