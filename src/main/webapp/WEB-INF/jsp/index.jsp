<%@ include file="common/header.jsp" %>

<div class="link">
<h2>Create Product</h2>
<c:if test="${saved == 'success'}">
<p class="success">Product Created Successfully</p>
</c:if>
<c:if test="${deleted == 'success'}">
<p class="success">Product Deleted Successfully</p>
</c:if>
<c:if test="${status == 'exist'}">
<p class="error">Product Already Exist</p>
</c:if>
<form:form modelAttribute="product" action="/menuapp/create" method="post">
<form:label path="productId">Product Name</form:label><form:input path="productId" />
<form:label path="productName">First Name</form:label><form:input path="productName" />
<form:label path="productPrice">Last Name</form:label><form:input path="productPrice" />
<button type="submit" id="save">Save Product</button><button type="submit" id="search">Search Product</button>
</form:form>
</div>

<c:if test="${search == 'true'}">
<table>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th colspan="2">Actions</th>
</tr>
<c:if test="${empty products}">
<tr>
<td colspan="4">No results found!</td>
</tr>
</c:if>
<c:forEach var="current" items="${products}">
<tr>
<td>${current.productId}</td>
<td>${current.productName}</td>
<td>${current.productPrice}</td>
<td><a href="/menuapp/edit/${current.productId}">Edit</a></td>
<td><a href="/menuapp/delete/${current.productId}">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>

<script type="text/javascript">

$(function() {
$("#save").click(function(event) {
         $("#product").attr("action", "/menuapp/create")
$("#product").submit();
});

$("#search").click(function(event) {
         $("#product").attr("action", "/menuapp/search")
$("#product").submit();

});
});
</script>

<%@ include file="common/footer.jsp" %>