<%@ include file="/common/taglibs.jsp"%>
<html:html>
<head>
	<link href="<c:url value="/styles/formtble.css"/>" rel="stylesheet"
		type="text/css" />
	<script language="javascript1.2" type="text/javascript"
		src="<c:url value="/scripts/him.js"/>"></script>
</head>
<body>
	<html:form action="/admin/provinceEdit?method=update" method="post"
		onsubmit="return validateProvinceForm(this);">
		<table cellspacing="0" cellpadding="0" class="tblForm1">
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.province.id" />

				</td>
				<td>
					<html:hidden property="id" />
					<c:out value="${provinceForm.id }"></c:out>
				</td>
			</tr>
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.province.name" />
					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="name" size="32" />
					<html:errors property="name" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel">
					<fmt:message key="label.province.code" />

				</td>
				<td>
					<html:text property="code" size="5" />
					<html:errors property="code" />
				</td>
			</tr>

			<tr>
				<td class="genericLabel">
					<fmt:message key="label.country.lbl" />
				</td>
				<td>
					<html:select property="country">

						<html:option value="">
							<fmt:message key="label.app.select" />
						</html:option>
						<c:if test="${not empty countries}">
							<c:forEach var="c" items="${countries}">
								<html-el:option value="${c.code2}">${c.name}</html-el:option>
							</c:forEach>
						</c:if>
					</html:select>
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
	<html:javascript formName="provinceForm" />
</body>
</html:html>
