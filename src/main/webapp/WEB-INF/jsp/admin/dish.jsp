<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/header.jsp" %>

<div class="link">

<h2>מערכת ניהול - מנה</h2>

<c:choose>
<c:when test="${showForm == 'true'}">
<form:form modelAttribute="dish" action="/menuapp/admin/restaurant/dish/saveOrUpdate" method="POST">
<c:if test="${editForm == 'true'}">
<form:input type="hidden" path="uuid"/>
</c:if>
<form:input type="hidden" path="restaurant.uuid"/>
<table>
	<tr>
		<td><form:label path="name">שם המנה</form:label></td>
		<td><form:input path="name" /></td>
	</tr>
	<tr>
		<td><form:label path="description">תיאור</form:label></td>
		<td><form:input path="description" placeholder="חציל בלאדי קלוי ברוטב שום ועשבי תיבול"/></td>
	</tr>
	<tr>
		<td><form:label path="price">מחיר</form:label></td>
		<td><form:input path="price" /></td>
	</tr>
	<tr>
		<td colspan="2"><button type="submit" id="save">שמור</button></td>
	</tr>
</table>
</form:form>

</c:when>
<c:otherwise>

<table>
	<tr>
		<td>שם המנה</td>
		<td>${dish.name}</td>
	</tr>
	<tr>
		<td>תיאור</td>
		<td>${dish.description}</td>
	</tr>
	<tr>
		<td>מחיר</td>
		<td>${dish.price}</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/menuapp/admin/restaurant/${dish.restaurant.uuid}">חזור</a></td>
	</tr>
</table>

<table>
<tr>
	<td colspan="8"><a href="/menuapp/admin/restaurant/dish/additional_option/add/${dish.uuid}">הוסף תוספת</a></td>
</tr>
<c:if test="${empty availableAdditionalOptions}">
<tr>
<td colspan="4">לא נמצאו תוספות</td>
</tr>
</c:if>
<c:forEach var="current" items="${availableAdditionalOptions}">
<tr>
	<td>img</td>
	<td>${current.uuid}</td>
	<td>${current.name}</td>
	<td><a href="/menuapp/admin/restaurant/dish/additional_option/delete/${current.uuid}">מחק</a></td>
</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</div>


<%@ include file="../common/footer.jsp" %>