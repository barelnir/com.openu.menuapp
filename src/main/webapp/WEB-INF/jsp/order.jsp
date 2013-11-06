<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="common/header.jsp" %>

<div class="link">
<h2>${dish.name}</h2>

<c:if test="${saved == 'success'}">
<p class="success">ההזמנה בוצעה בהצלחה</p>
</c:if>

<c:if test="${deleted == 'success'}">
<p class="success">ההזמנה בוטלה בהצלחה</p>
</c:if>

<table>
	<tr>
		<td>${dish.name}</td>
		<td>${dish.price}</td>
	</tr>
	<tr>
		<td>${dish.description}</td>
		<td></td>
	</tr>
</table>

${order.dish} = ${dish}

<form:form modelAttribute="order" action="/menuapp/order/create" method="POST">
<form:input type="hidden" path="dish" value="${dish.uuid}"/>
<table>


	<tr>
		<td>תוספות למנה:</td>
		<td><form:checkboxes element="li" items="${availableAdditionalOptions}" path="selectedAdditionalOptions" itemLabel="name" itemValue="uuid"/></td>
 	</tr>
   	<tr>
   		<input value="הזמן" type="submit">
   		<!--<button type="submit" id="save">הזמן</button>-->
   	</tr>
  </table>
</form:form>

</div>

<!-- <script type="text/javascript">

        $(function() {
                $("#save").click(function(event) {
                $("#order").attr("action", "/menuapp/order/create")
                        $("#order").submit();
                });
        });
</script> -->



<%@ include file="common/footer.jsp" %>