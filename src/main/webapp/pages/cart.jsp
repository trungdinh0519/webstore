<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
  		<!--
  		function checkDel(){
  			result=confirm("<fmt:message key="label.confirm.delete"/>");
  			return result;
  		}
  		-->
  		</script>
		
	    <link href="../styles/cart.css" rel="stylesheet" type="text/css">
	    
	    
	    <link href="<c:url value="/styles/cart.css"/>" rel="stylesheet" type="text/css">
	</head>
	<body>
		<span class="managercart"><fmt:message key="label.cart.manager" />
		</span>
		<html:form action="/pages/updatecart">
			<!-- <a class="clear" onclick="return checkDel();"
				href="<c:url value="/pages/emptycart.do"/>"><fmt:message
					key="label.cart.clear" /> </a> -->
			<table cellpadding="0" cellspacing="0" border="0" width="100%"
				class="cart">
				<thead>
					<tr>
						<th class="items">
							<p>
								<fmt:message key="label.cart.item" />
							</p>
						</th>
						<th class="quantity">
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
							<p>&nbsp;
								
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
								<p>&nbsp;
									
								</p>
							</td>

						</tr>
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
		<hr />
		<c:url var="checkUrl" value="/pages/billing.do?mt_code=fillbill"></c:url>
		<c:url var="continueUrl" value="/pages/continueShopping.do"></c:url>
		<form action="<c:out value="${checkUrl}"/>" name="cartForm"
			method="post">
				<div class="buttonbarcenter">
			<input type="button" name="continue"
				value="<fmt:message key="label.cart.continue"/>"
				onclick="document.location.href='<c:out value="${continueUrl}"/>'" />
			<input type="submit" name="checkoutBtn"
				value="<fmt:message key="label.cart.begincheckout"/>">
				</div>
		</form>

	</body>
</html>
