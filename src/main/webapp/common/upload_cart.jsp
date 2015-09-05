<%@ include file="/common/taglibs.jsp"%>

<input type="hidden" name="cmd" value="_cart" />

<input type="hidden" name="upload" value="1" />

<INPUT TYPE="hidden" name="charset" value="utf-8">
<input type="hidden" name="business"
	value="<c:out value="${business_email}"/>" />
<c:forEach var="item" items="${cart.items}" varStatus="status">

	<c:if test="${status.index == 0}">
		<input type="hidden" name="shipping_<c:out value="${status.count}"/>"
			value="<c:out value="${cart.shipcost/usd_vnd}"/>" />
	</c:if>
	<input type="hidden" name="item_name_<c:out value="${status.count}"/>"
		value="<c:out value="${item.product.name}"/>" />

	<input type="hidden" name="amount_<c:out value="${status.count}"/>"
		value="<c:out value="${item.price/usd_vnd}"/>" />
	<!-- quantity of this photograph -->
	<input type="hidden" name="quantity_<c:out value="${status.count}"/>"
		value="<c:out value="${item.quantity}"/>" />
</c:forEach>

<!-- set to 0 so user will be asked to provide a note during purchasing -->
<input type="hidden" name="no_note" value="1" />
<!-- set to 2 to require a shipping address after the jump -->
<input type="hidden" name="no_shipping" value="0" />
<!-- where to send user from the jump if cancel while there, which is fully qualified URL to this page (including port) -->
<input type="hidden" name="cancel_return" value="<c:out value="${cancel_url}"/>" />
<input type="hidden" name="notify_url" value="<c:out value="${return_url}"/>" />
<!-- where to send user after completes jump which is fully qualified URL to this page (including port) -->
<input type="hidden" name="return" value="<c:out value="${return_url}"/>" />
<!-- set to 1 to force the use of a GET request when returning the user from the jump -->
<input type="hidden" name="rm" value="2" />

<input type="hidden" name="first_name"
	value="<c:out value="${shippingForm.firstname}"/>">
<input type="hidden" name="last_name"
	value="<c:out value="${shippingForm.lastname}"/>">
<input type="hidden" name="address1"
	value="<c:out value="${shippingForm.address}"/>">

<input type="hidden" name="city"
	value="<c:out value="${shippingForm.city}"/>">
<input type="hidden" name="zip"
	value="<c:out value="${shippingForm.postalCode}"/>">
<input type="hidden" name="state"
	value="<c:out value="${shippingForm.province}"/>">

<input type="hidden" name="country"
	value="<c:out value="${shippingForm.country}"/>">

