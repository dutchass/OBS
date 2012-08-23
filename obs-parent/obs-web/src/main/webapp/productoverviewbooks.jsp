<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="obs" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html />

<html>
<obs:head title="Productoverzicht boeken" />
<obs:pageheader />
<body>
	<obs:userInfo />
	<obs:customerInfo />

	<div class="tableWrapper">
		<table id="myTable">
			<thead>
				<tr>
					<th colspan="5">Productoverzicht boeken</th>
				</tr>
				<tr>
					<th></th>
					<th>Titel</th>
					<th>Auteur</th>
					<th>ISBN</th>
					<th>Prijs</th>
					<th></th>
				</tr>
			</thead>

			<tbody id="myTbody">
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td><img class="resizeme" src="/WEB-IMAGES/${book.imagebookurl}" /></td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.ISBNnumber}</td>
						<td>${book.price}</td>
						<td><a href="?action=addToCart&bookId=${book.id}" >+</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".resizeme").aeImageResize({
				width : 75
			});
		});
	</script>
	
	
</body>
</html>

