<%@ include file="common/header.jsp" %>

<div class="link">
<h2>Update Product</h2>
<c:if test="${saved == 'success'}">
<p class="success">Product Updated Successfully</p>
</c:if>
<form:form modelAttribute="user" action="/menuapp/update" method="post">
<form:label path="productId">Product Id</form:label><form:input path="productId" />
<form:label path="productName">Product Name</form:label><form:input path="productName" />
<form:label path="productPrice">Product Price</form:label><form:input path="productPrice" />
<button type="submit" id="save">Update Product</button> <a href="/menuapp/">Go Home</a>
</form:form>
</div>


<%@ include file="common/footer.jsp" %>