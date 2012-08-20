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
	    <col style="width:10%">
        <col style="width:45%">
        <col style="width:15%">
        <col style="width:15%">
	<thead>
		<tr>
			<th colspan="4">Winkewagenoverzicht producten</th>
		</tr>
		<tr>
   <tr>
       <th >Regelnr.</th>
       <th>Titel</th>
       <th>Aantal</th>
       <th>Bedrag</th>       
    </tr>
</thead>


   	 <c:forEach items="${bookList}" var="book">
   	 <tr>
        <td align="center">${regelnummer} 1</td>
       	<td>${book.title} "titel komt hier"</td>
       	<td>${book.price} prijs</td>
       	<td>${amount} hoeveelheid</td>      
       	<td align="center">
        	<input type="button" value="Update item" onclick="document.location="/>
         	<input type="button" value="Delete item" />
      	</td>
  	  </tr>
	 </c:forEach>

	<tr>
	   <td colspan="3" align="left"><b>Totaal bedrag</b></td>
	   <td colspan="2"><font color="green">"Euro"&nbsp;999,99</font></td>
	</tr>
</table>
<br>
		<input type="button" onclick="document.location=" value="Winkelwagen updaten">
		&nbsp;<input type="button" onclick="document.location=" value="Winkelwagen leegmaken">
		&nbsp;<input type="button" onclick="document.location=" value="Afronden order">
</body>
</html>