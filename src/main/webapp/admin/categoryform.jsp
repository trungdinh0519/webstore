<%@ include file="/common/taglibs.jsp"%>
<html:html>
<head>
		<link href="<c:url value="/styles/formtble.css"/>" rel="stylesheet"
			type="text/css" />
		<script language="javascript1.2" type="text/javascript" src="<c:url value="/scripts/him.js"/>"></script>
</head>
<body>
	<html:form action="/admin/categoryForm?method=save" method="post"
		onsubmit="return validateCategoryForm(this);">
		<table  cellspacing="0" cellpadding="0" class="tblForm1">
			<tr>
				<td class="genericLabel" >
					<fmt:message key="label.category.name" />
					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="name" size="32" maxlength="64" />
					<html:errors property="name" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel" >
					<fmt:message key="label.category.desc" />

				</td>
				<td>
					<html:textarea property="desc" cols="50" rows="5" />
					<html:errors property="desc" />
				</td>
			</tr>
			<tr>
			<td></td>
				<td >
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
	<html:javascript formName="categoryForm" />
</body>
</html:html>
