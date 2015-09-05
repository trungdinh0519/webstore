<%@ include file="/common/taglibs.jsp"%>
<html:html>
<head>
		<link href="<c:url value="/styles/formtble.css"/>" rel="stylesheet"
			type="text/css" />
		<script language="javascript1.2" type="text/javascript" src="<c:url value="/scripts/him.js"/>"></script>
</head>
<body>
	<html:form action="/admin/mfEdit?method=update" method="post"
		onsubmit="return validateMfForm(this);">
		<table  cellspacing="0" cellpadding="0" class="tblForm1">
			<tr>
				<td class="genericLabel" >
					<fmt:message key="label.mf.id" />
					
				</td>
				<td>
					<html:hidden property="id"/>
					<c:out value="${mfForm.id }"></c:out>
				</td>
			</tr>
			<tr>
				<td class="genericLabel" >
					<fmt:message key="label.mf.name" />
					<label class="red">
						*
					</label>
				</td>
				<td>
					<html:text property="name" size="32" maxlength="255" />
					<html:errors property="name" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel" >
					<fmt:message key="label.mf.url" />

				</td>
				<td>
					<html:text property="url" maxlength="255"/>
					<html:errors property="url" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel" >
					<fmt:message key="label.mf.email" />

				</td>
				<td>
					<html:text property="email" />
					<html:errors property="email" />
				</td>
			</tr>
			<tr>
				<td class="genericLabel" >
					<fmt:message key="label.mf.desc" />

				</td>
				<td>
					<html:textarea property="desc" cols="50" rows="10" />
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
	<html:javascript formName="mfForm" />
</body>
</html:html>
