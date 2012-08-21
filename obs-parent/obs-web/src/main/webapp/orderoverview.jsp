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
	<c:choose>
		<c:when test="${auth.authenticated == true}">
			<div class="tableWrapper">
				<table id="myTable" style="border: 1px solid black;">
					<thead style="background-color: #EFEFEF;">
						<tr>
							<th colspan="5">Overzicht bestellingen</th>
						</tr>
						<tr>
							<th>Order #</th>
							<th>Details</th>
							<th>Geplaatst</th>
							<th>Verzonden</th>
							<th>Totaal</th>
						</tr>
					</thead>

					<tbody id="myTbody">
						<c:forEach items="${orderList}" var="order">
							<tr>
								<td>${order.invoiceNumber}</td>
								<td>
									<!-- ORDER PRODUCTS -->
									<table>
										<thead style="background-color: #EFEFEF;">
											<tr>
												<th colspan="2">Boeken</th>
											</tr>
											<tr>
												<th>Titel</th>
												<th>Aantal</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${order.orderedBooks}" var="orderedBook">
												<tr>
													<td>${orderedBook.book.title}</td>
													<td>${orderedBook.amount}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</td>
								<td>${order.date}</td>
								<td>${order.shipped}</td>
								<td>${order.totalOrderAmount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>

		<c:otherwise>
			<obs:message type="WARNING">U dient ingelogd te zijn om uw bestellingen te bekijken.</obs:message>
		</c:otherwise>
	</c:choose>


</body>
</html>