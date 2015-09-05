<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<style type="text/css">
<!--
.tableOrder{
font-family:"Times New Roman", Times, serif;
font-size:11pt;
}
-->
        </style>
	</head>
	<body>
		<div class="box">
			<table border="0" width="100%" cellpadding="0" cellspacing="0"
				class="tableOrder">
				<thead>
					<tr>
						<th colspan="2" bgcolor="#66CCCC">
							&nbsp;


						</th>
					</tr>
				</thead>
				<tr>
					<th align="left">
						<fmt:message>label.order.id</fmt:message>
					</th>
					<td>
						<c:out value="${order.id}"></c:out>
					</td>
				</tr>
				<tr>
					<th align="left">

						<fmt:message>label.order.date</fmt:message>

					</th>
					<td>
						<fmt:formatDate value="${order.orderDate}" pattern="dd-MM-yyyy" />

					</td>
				</tr>
				<tr>
					<th align="left">
						<fmt:message>label.order.status</fmt:message>

					</th>
					<td>

						<c:out value="${order.status}" />


					</td>
				</tr>

			</table>
		</div>
		<div class="box">

			<table cellspacing="0" width="100%" cellpadding="0" border="0"
				class="tableOrder">
				<thead>
					<tr>
						<th bgcolor="#66CCCC">
							<fmt:message>label.order.Billto</fmt:message>
						</th>
						<th bgcolor="#66CCCC">
							<fmt:message>label.order.Shipto</fmt:message>
						</th>

					</tr>
				</thead>
				<tr>
					<td width="50%">

						<table border="0" cellspacing="0" cellpadding="0"
							class="per_info tableOrder">
							<tr>
								<th width="30%" align="left">
									<fmt:message>label.order.Name</fmt:message>
								</th>
								<td width="60%">
									<c:out value="${order.billToLastName}"></c:out>
									&nbsp;
									<c:out value="${order.billToFirstName}"></c:out>
								</td>
							</tr>
							<tr>
								<th align="left">
									<fmt:message>label.order.address</fmt:message>
								</th>
								<td>
									<c:out value="${order.billToAddress}"></c:out>
									,
									<c:out value="${order.billToCity}"></c:out>
									,
									<c:out value="${BilltoProvince}"></c:out>
									,
									<c:out value="${BilltoCountry}"></c:out>
									,


								</td>
							</tr>
							<tr>
								<th align="left">
									<fmt:message>label.order.PostalCode</fmt:message>
								</th>
								<td>
									<c:out value="${order.billToPostalCode}"></c:out>
								</td>
							</tr>
							<tr>
								<th align="left">
									<fmt:message>label.order.Email</fmt:message>
								</th>
								<td>

									<c:out value="${order.billToEmail}"></c:out>

								</td>
							</tr>
							<tr>
								<th align="left">
									<fmt:message>label.order.Phone</fmt:message>
								</th>
								<td>

									<c:out value="${order.billToPhone}"></c:out>

								</td>
							</tr>
						</table>

					</td>
					<td width="50%">

						<table border="0" cellspacing="0" cellpadding="0"
							class="per_info tableOrder">
							<tr>
								<th width="30%" align="left">
									<fmt:message>label.order.Name</fmt:message>
								</th>
								<td width="60%">
									<c:out value="${order.billToLastName}"></c:out>
									&nbsp;
									<c:out value="${order.billToFirstName}"></c:out>
								</td>
							</tr>
							<tr>
								<th align="left">
									<fmt:message>label.order.address</fmt:message>
								</th>
								<td>
									<c:out value="${order.shipToAddress}"></c:out>
									,
									<c:out value="${order.shipToCity}"></c:out>
									,
									<c:out value="${ShiptoProvince}"></c:out>
									,
									<c:out value="${ShiptoCountry}"></c:out>
								</td>
							</tr>
							<tr>
								<th align="left">
									<fmt:message>label.order.PostalCode</fmt:message>
								</th>
								<td>
									<c:out value="${order.billToPostalCode}"></c:out>
								</td>
							</tr>
							<tr>
								<th align="left">
									<fmt:message>label.order.Email</fmt:message>
								</th>
								<td>

									<c:out value="${order.billToEmail}"></c:out>

								</td>
							</tr>
							<tr>
								<th align="left">
									<fmt:message>label.order.Phone</fmt:message>
								</th>
								<td>

									<c:out value="${order.billToPhone}"></c:out>

								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div class="box">

			<table cellspacing="0" width="100%" cellpadding="0" border="0"
				class="tableOrder">
				<thead>
					<tr>
						<th bgcolor="#66CCCC">
							<fmt:message>label.order.Detail</fmt:message>
						</th>
					</tr>

				</thead>
				<tr>
					<td>
						<table cellspacing="0" width="100%" cellpadding="0" border="0"
							id="items" class="tableOrder">
							<thead>
								<tr>
									<th bgcolor="#FFFFFF" align="left">
										<fmt:message>label.order.name</fmt:message>
									</th>
									<th bgcolor="#FFFFFF" align="left">
										<fmt:message>label.order.quantity</fmt:message>
									</th>
									<th bgcolor="#FFFFFF" align="left">
										<fmt:message>label.order.price</fmt:message>
									</th>
									<th bgcolor="#FFFFFF" align="left">
										<fmt:message>label.cart.subtotal</fmt:message>
									</th>
								</tr>

							</thead>
							<c:forEach var="row" items="${orderItem}">
								<tr>
									<td>
										<c:out value="${row.product.name }"></c:out>
									</td>
									<td>
										<c:out value="${row.quantity }"></c:out>
									</td>
									<td>

										<fmt:formatNumber value="${row.price}" pattern="###" />
										<fmt:message key="label.currency" />
									</td>
									<td>
										<fmt:formatNumber value="${row.price *row.quantity}"
											pattern="###" />
										<fmt:message key="label.currency" />

									</td>
								</tr>
							</c:forEach>
							<tr>
								<th colspan="4">
									&nbsp;


								</th>
							</tr>
							<tr>
								<td colspan="3">
									<fmt:message>label.subtotal</fmt:message>

								</td>
								<td>

									<fmt:formatNumber value="${order.orderSubTotal}"
										pattern="# ###" />
									<fmt:message key="label.currency" />
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<fmt:message>label.shipcost</fmt:message>

								</td>
								<td>
									<fmt:formatNumber value="${order.shipPrice}" pattern="# ###" />
									<fmt:message key="label.currency" />

								</td>
							</tr>
							<tr>
								<td colspan="3">
									<fmt:message>label.total</fmt:message>

								</td>
								<td>

									<fmt:formatNumber value="${order.orderTotal}"
										pattern="# ### ###" />
									<fmt:message key="label.currency" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

		</div>
		<br />
	</body>
</html>
