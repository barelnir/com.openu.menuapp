<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/header.jsp" %>

<div class="link">

<h2>מערכת ניהול - מסעדה</h2>

<c:choose>
<c:when test="${showForm == 'true'}">
<form:form modelAttribute="restaurant" action="/menuapp/admin/restaurant/saveOrUpdate" method="POST">
<c:if test="${editForm == 'true'}">
<form:input type="hidden" path="uuid"/>
</c:if>
<table>
	<tr>
		<td><form:label path="name">שם המסעדה</form:label></td>
		<td><form:input path="name" /></td>
	</tr>
	<tr>
		<td><form:label path="address">כתובת</form:label></td>
		<td><form:input path="address" value="${restaurant.address.city}" placeholder="נחל איילון 4 דירה 17 צור יצחק"/></td>
	</tr>
	<tr>
		<td><form:label path="phone">טלפון</form:label></td>
		<td><form:input path="phone" /></td>
	</tr>
	<tr>
		<td><form:label path="managerName">שם המנהל</form:label></td>
		<td><form:input path="managerName" /></td>
	</tr>
	<tr>
		<td><form:label path="kosher">כשרות</form:label></td>
		<td><form:select path="kosher" >
			<form:option value="true" label="כשר"></form:option>
			<form:option value="false" label="לא כשר"></form:option>
			</form:select>
		</td>
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
		<td>שם המסעדה</td>
		<td>${restaurant.name}</td>
	</tr>
	<tr>
		<td>כתובת</td>
		<td>${restaurant.address.city}</td>
	</tr>
	<tr>
		<td>טלפון</td>
		<td>${restaurant.phone}</td>
	</tr>
	<tr>
		<td>שם המנהל</td>
		<td>${restaurant.managerName}</td>
	</tr>
	<tr>
		<td>כשרות</td>
		<c:choose>
		<c:when test="${restaurant.kosher}">
			<td>כשר</td>
		</c:when>
		<c:otherwise>
			<td>לא כשר</td>
		</c:otherwise>
		</c:choose>
		
	</tr>
	<tr>
		<td colspan="2"><a href="/menuapp/admin/restaurants">חזור</a></td>
	</tr>
</table>

<table>
<tr>
	<td colspan="8"><a href="/menuapp/admin/restaurant/dish/add/${restaurant.uuid}">הוסף מנה</a></td>
</tr>
<c:if test="${empty dishes}">
<tr>
<td colspan="4">לא נמצאו מנות</td>
</tr>
</c:if>
<c:forEach var="current" items="${dishes}">
<tr>
	<td>img</td>
	<td>${current.uuid}</td>
	<td>${current.name}</td>
	<td>${current.description}</td>
	<td>${current.price}</td>
	<td><a href="/menuapp/admin/restaurant/dish/${current.uuid}">צפה</a></td>
	<td><a href="/menuapp/admin/restaurant/dish/edit/${current.uuid}">ערוך</a></td>
	<td><a href="/menuapp/admin/restaurant/dish/delete/${current.uuid}">מחק</a></td>
</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</div>


<%@ include file="../common/footer.jsp" %>