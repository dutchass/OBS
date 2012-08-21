<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="obs" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>OBS Winkelwagen</title>
</head>
<body>
	<table border="1" width="85%" id="myTable">
		<col style="width: 10%">
		<col style="width: 45%">
		<col style="width: 15%">
		<col style="width: 15%">
		<thead>
			<tr>
				<th colspan="4">Winkewagenoverzicht producten</th>
			</tr>
			<tr>
			<tr>
				<th>Regelnr.</th>
				<th>Titel</th>
				<th>Aantal</th>
				<th>Bedrag</th>
			</tr>
		</thead>


		<c:forEach items="${shoppingCartModel.bookEntries}" var="bookEntry">
			<tr>
				<td align="center">${regelnummer} 1</td>
				<!-- jij bent geintresseerd in welk ding als eerste in je wagen kwam als je door de AH slentert? ok, dan moet je dat ergens bij gaan houden, regelnummer komt niet uit de lucht vallen-->
				<td>${bookEntry.book.title}</td>
				<td>${bookEntry.book.price}</td>
				<td>${bookEntry.amount}</td>
				<td align="center"><input type="button" value="Update item"
					onclick="document.location=" /> <input type="button"
					value="Delete item" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="left"><b>Totaal producten</b></td>
			<!--  -->
			<td colspan="2"><font color="green">${shoppingCartModel.totalAmount}</font></td>
		</tr>
		<tr>
			<td colspan="3" align="left"><b>Totaal bedrag</b></td>
			<!-- DEZE MAG JE ZELF DOEN ;)  -->
			<td colspan="2"><font color="green">"Euro"&nbsp;999,99</font></td>
		</tr>
	</table>
	<br>
	<input type="button" onclick="document.location="
		value="Winkelwagen updaten"> &nbsp;
	<input type="button" onclick="document.location="
		value="Winkelwagen leegmaken"> &nbsp;
	<input type="button" onclick="document.location="
		value="Afronden order">
</body>
</html>