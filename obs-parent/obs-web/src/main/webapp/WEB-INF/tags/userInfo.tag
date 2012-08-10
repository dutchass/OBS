<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${auth.authenticated == true}">
		logged in as ${auth.user.username} (<a href="/logout">logout</a>)
		</c:when>
	<c:otherwise>
		not logged in, click <a href="/login">here</a> to login
		</c:otherwise>
</c:choose>
