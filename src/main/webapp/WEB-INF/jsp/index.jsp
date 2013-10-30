<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="common/header.jsp" %>

<div class="link">
<h2>רשימת מסעדות</h2>

<c:if test="${saved == 'success'}">
<p class="success">ההזמנה בוצעה בהצלחה</p>
</c:if>

<c:if test="${deleted == 'success'}">
<p class="success">ההזמנה בוטלה בהצלחה</p>
</c:if>

<table>
<c:if test="${empty restaurants}">
<tr>
<td colspan="4">לא נמצאו מסעדות</td>
</tr>
</c:if>
<c:forEach var="current" items="${restaurants}">
<tr>
	<td>
		<table>
			<tr>
				<td rowspan="4">img</td>
			</tr>
			<tr>
				<td>${current.name}</td>
				<td>${current.address.city}</td>
				<td>stars</td>
			</tr>
			<tr>
				<td>type</td>
				<td>minimum</td>
				<td><a href="/menuapp/restaurant/${current.uuid}">menu</a></td>
			</tr>
			<tr>
				<td></td>
				<td>open hours</td>
				<td><a href="www.facebook.com">share</a></td>
			</tr>
		</table>
	</td>
</tr>
</c:forEach>
</table>
</div>

<%@ include file="common/footer.jsp" %>