<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="common/header.jsp" %>

<div class="link">
<h2>${restaurant.name}</h2>

<c:if test="${saved == 'success'}">
<p class="success">ההזמנה בוצעה בהצלחה</p>
</c:if>

<c:if test="${deleted == 'success'}">
<p class="success">ההזמנה בוטלה בהצלחה</p>
</c:if>

<table>
	<tr>
		<td rowspan="4">img</td>
		<td>${restaurant.name}</td>
		<td>stars</td>
	</tr>
	<tr>
		<td>type</td>
		<td></td>
	</tr>
	<tr>
		<td>${restaurant.address.city}</td>
		<td></td>
	</tr>
	<tr>
		<td>${restaurant.phone}</td>
		<td></td>
	</tr>
</table>


<table>
<c:if test="${empty dishes}">
	<tr>
	<td colspan="4">לא נמצאו מנות</td>
	</tr>
</c:if>
<c:forEach var="current" items="${dishes}">
	<tr>
		<td>${current.uuid}</td>
		<td>${current.name}</td>
		<td>${current.description}</td>
		<td>${current.price}</td>
		<td><a href="/menuapp/order/${current.uuid}">הזמן</a></td>
	</tr>
</c:forEach>
</table>
</div>

<%@ include file="common/footer.jsp" %>