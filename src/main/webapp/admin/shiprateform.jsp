<%@ include file="/common/taglibs.jsp"%>
<html:html>
<head>
	<link href="<c:url value="/styles/formtble.css"/>" rel="stylesheet"
		type="text/css" />
	<script language="javascript1.2" type="text/javascript"
		src="<c:url value="/scripts/him.js"/>"></script>
</head>
<body>
	<html:form action="/admin/shiprateForm?method=save" method="post"
		onsubmit="return validateShiprateForm(this);">
		<table cellspacing="0" cellpadding="0" class="tblForm1">
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.shiprate.name" />
					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="name" size="20" />
					<html:errors property="name" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.shiprate.from" />
					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="from" size="10" />
					(kg)
					<html:errors property="from" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.shiprate.to" />

					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="to" size="10" />
					(kg)
					<html:errors property="to" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.shiprate.price" />

					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="price" size="10" />
					<fmt:message key="label.product.currency" />
					<html:errors property="price" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.shiprate.levAmout" />
					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="levAmout" size="10" />
					(kg)
					<html:errors property="levAmout" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.shiprate.levPrice" />

					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="levPrice" size="10" />
					<fmt:message key="label.product.currency" />
					<html:errors property="levPrice" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.shiprate.method" />
					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:select property="shipMethod">
						<html:option value=""></html:option>
						<c:if test="${not empty methods}">
							<c:forEach var="method" items="${methods}">
								<html:option value="${method.id}">${method.name}</html:option>
							</c:forEach>
						</c:if>
					</html:select>
					<html:errors property="shipMethod" />
				</td>
			</tr>

			<tr>
				<td class="genericLabel">
					<fmt:message key="label.shiprate.provinces" />
				</td>
				<td width="600px">

					<fieldset>
						<legend>
							<fmt:message key="label.shiprate.province.list" />
						</legend>
						<c:if test="${not empty provinces}">
							<c:forEach var="pro" varStatus="status" items="${provinces}">
								<span class="province_show_label_check"><html:multibox
										property="provinces" value="${pro.code}" /> <c:out
										value="${pro.name}"></c:out> </span>
								<c:if test="${status.count%4==0}">
									<br />
								</c:if>
							</c:forEach>
						</c:if>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<html:submit>
						<fmt:message key="button.save" />
					</html:submit>
					<html:cancel>
						<fmt:message key="button.cancel" />
					</html:cancel>
				</td>
			</tr>
		</table>
	</html:form>
	<html:javascript formName="shiprateForm" />
</body>
</html:html>
