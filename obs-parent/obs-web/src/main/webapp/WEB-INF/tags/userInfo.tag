<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${auth.authenticated == true}">
		<p>logged in as ${auth.user.firstname} ${auth.user.lastname} (${auth.user.username}) (<a href="/logout">logout</a>)<br/></p>
		<p> </p>
		</c:when>
	<c:otherwise>
		<p>not logged in, click <a href="/login">here</a> to login <br/></p>
		<p> </p>
		</c:otherwise>
</c:choose>
