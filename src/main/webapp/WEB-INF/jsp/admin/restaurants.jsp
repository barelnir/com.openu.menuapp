<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/header.jsp" %>

<div class="link">

<h2>מערכת ניהול - מסעדות</h2>

<c:if test="${saved == 'success'}">
<p class="success">המסעדה נוספה בהצלחה</p>
</c:if>

<c:if test="${deleted == 'success'}">
<p class="success">המסעדה הוסרה בהצלחה</p>
</c:if>

<table>
<tr>
	<td colspan="6"><a href="/menuapp/admin/restaurant/add">הוסף</a></td>
</tr>
<c:if test="${empty restaurants}">
<tr>
<td colspan="4">לא נמצאו מסעדות</td>
</tr>
</c:if>
<c:forEach var="current" items="${restaurants}">
<tr>
	<td>img</td>
	<td>${current.name}</td>
	<td>${current.address.city}</td>
	<td><a href="/menuapp/admin/restaurant/${current.uuid}">צפה</a></td>
	<td><a href="/menuapp/admin/restaurant/edit/${current.uuid}">ערוך</a></td>
	<td><a href="/menuapp/admin/restaurant/delete/${current.uuid}">מחק</a></td>
</tr>
</c:forEach>
</table>
</div>

<%@ include file="../common/footer.jsp" %>