<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${auth.authenticated == true}">
	<div>
		<section>
		<div>
			<h1>${auth.customer.firstname} ${auth.customer.lastname}</h1>
			<h3>${auth.customer.zipcode} ${auth.customer.city}</h3>
			<h4>
				<a href="mailto:${auth.customer.email}">${auth.customer.email}</a>
			</h4>
		</div>
		</section>
	</div>
</c:if>

