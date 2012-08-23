<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${auth.authenticated == true}">
	<div>
		<section>
		<div>
			<h3> Klantgegevens:</h3><br/>
			${auth.customer.firstname} ${auth.customer.lastname}<br/>
			${auth.customer.zipcode} ${auth.customer.city}<br/>
				<a href="mailto:${auth.customer.email}">${auth.customer.email}</a>
			<br/>
		</div>
		</section>
	</div>
</c:if>

