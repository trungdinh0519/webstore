<%@ include file="/common/taglibs.jsp"%>
 <link href="<c:url value="/styles/cart.css"/>" rel="stylesheet" type="text/css">
<html:form action="/pages/updatecart">
	<table cellpadding="0" cellspacing="0" border="0" width="100%"
		class="cart">
		<thead>
			<tr>
				<th class="items">
					<p>
						<fmt:message key="label.cart.item" />
					</p>
				</th>
				<th class="quantity" width="30">
					<p>
						<fmt:message key="label.cart.quantity" />
					</p>
				</th>
				<th class="price">
					<p>
						<fmt:message key="label.cart.price" />
					</p>
				</th>
				<th class="cartsubtotal">
					<p>
						<fmt:message key="label.cart.subtotal" />
					</p>
				</th>
				<th>
					<p>
						&nbsp;
					</p>
				</th>
			</tr>
		</thead>

		<c:choose>
			<c:when test="${not empty cart.cartItems}">
				<c:forEach var="item" items="${cart.cartItems}" varStatus="status">
					<html-el:hidden property="labelValue[${status.index}].label" />
					<c:url var="deleteURL" value="/pages/deleteFromCart.do">
						<c:param name="index" value="${status.index}" />
					</c:url>
					<tr>
						<td class="items">
							<p>
								<c:out value="${item.product.name}" />
							</p>
						</td>
						<td class="quantity">
							<html-el:text property="labelValue[${status.index}].value"
								size="1" />
						</td>
						<td class="price">
							<p>

								<fmt:formatNumber value="${item.price}" pattern="# ###" />
								<fmt:message key="label.currency" />
							</p>
						</td>
						<td class="subtotal">
							<p>
							<fmt:formatNumber value="${item.subTotal}" pattern="# ###" />

								<fmt:message key="label.currency" />
							</p>
						</td>
						<td class="delete">
							<input type="button" name="deleteBtn"
								value="<fmt:message key="label.cart.delete"/>"
								onclick="document.location.href='<c:out value="${deleteURL}"/>';" />
						</td>
					</tr>
				</c:forEach>


				<tr>
				<tr class="subtotal">

					<td colspan="3">
						<p>
							<fmt:message key="label.subtotal" />
						</p>
					</td>
					<td>
						<p>
							<fmt:formatNumber value="${cart.subTotal}" pattern="# ###" />
							<fmt:message key="label.currency" />
						</p>
					</td>
					<td>
						<p>
							&nbsp;
						</p>
					</td>

				</tr>
				<c:if test="${(not empty cart.shipcost)and(cart.shipcost>0)}">
					<tr class="shiprate">
						<td colspan="3">
							<p>
								<fmt:message key="label.shiprate" />
							</p>
						</td>
						<td >
							<p>
								<fmt:formatNumber value="${cart.shipcost}" pattern="# ###" />

								<fmt:message key="label.currency" />
							</p>
						</td>
						<td>
							<p>
								&nbsp;
							</p>
						</td>

					</tr>
					<tr class="total">

						<td colspan="3">
							<p>
								<fmt:message key="label.total" />
							</p>
						</td>
						<td>
							<p>
								<fmt:formatNumber value="${cart.total}" pattern="# ###" />
								<fmt:message key="label.currency" />
							</p>
						</td>
						<td>
							<p>
								&nbsp;
							</p>
						</td>

					</tr>
				</c:if>


				<tr>
					<td class="update" colspan="5">
						<html-el:submit>
							<fmt:message key="button.update" />
						</html-el:submit>

					</td>

				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">
						<p>
							<fmt:message key="label.cart.empty" />
						</p>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>


	</table>
</html:form>
