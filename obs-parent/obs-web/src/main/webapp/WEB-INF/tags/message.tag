<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="type" description="" required="true"
	type="nl.obs.web.tag.MessageType"%>

<jsp:doBody var="bodyRes" />

<c:choose>
	<c:when test="${type == 'WARNING'}">
		<c:set var="style" value="ui-state-highlight" />
		<c:set var="icon" value="ui-icon-alert" /> 
		</c:when>
		<c:when test="${type == 'INFO'}">
		<c:set var="style" value="ui-state-default" /> 
		<c:set var="icon" value="ui-icon-info" />
		</c:when>
	<c:when test="${type == 'ERROR'}">
		<c:set var="style" value="ui-state-error" /> 
		<c:set var="icon" value="ui-state-highlight" />
		</c:when>
</c:choose>

<div class="ui-widget">
	<div class="${style} ui-corner-all" style="padding: 0 .7em;">
		<p>
			<span class="${icon} ui-icon-alert"
				style="float: left; margin-right: .3em;"></span> ${bodyRes}
		</p>
	</div>
</div>

