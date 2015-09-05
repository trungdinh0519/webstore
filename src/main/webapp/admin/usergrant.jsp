<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>User Form</title>
		<link href="<c:url value="/styles/formtble.css"/>" rel="stylesheet"
			type="text/css" />
		<script language="javascript1.2" type="text/javascript"
			src="<c:url value="/scripts/him.js"/>"></script>
	</head>
	<body>
		<html:form action="/admin/userG?method=grant" method="post"
			styleId="userG" onsubmit="return validateUserForm(this);">
			<table cellspacing="0" cellpadding="0" class="tblForm1">
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.username" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:hidden property="username" />
						<c:out value="${userForm.username}"></c:out>
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.enabled" />
					</td>
					<td>
						<html:checkbox property="enabled" value="on"></html:checkbox>
						<html:errors property="enabled" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.accountExpired" />
					</td>
					<td>
						<html:checkbox property="accountExpired"></html:checkbox>
						<html:errors property="accountExpired" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.accountLocked" />
					</td>
					<td>
						<html:checkbox property="accountLocked"></html:checkbox>
						<html:errors property="accountLocked" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.credentialsExpired" />
					</td>
					<td>
						<html:checkbox property="credentialsExpired"></html:checkbox>
						<html:errors property="credentialsExpired" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.user.privi" />
					</td>
					<td width="600px">

						<fieldset>
							<legend>
								<fmt:message key="label.user.roles" />
							</legend>
							<c:if test="${not empty roles}">
								<c:forEach var="role" varStatus="status" items="${roles}">
									<span class="roles_show_label_check"><html:multibox
											property="roles" value="${role.id}" /> <c:out
											value="${role.name}"></c:out> </span>
									<c:if test="${status.count%4==0}">
										<br />
									</c:if>
								</c:forEach>
							</c:if>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<html:submit>
							<fmt:message key="button.save" />
						</html:submit>
						<html:reset>
							<fmt:message key="button.reset" />
						</html:reset>
						<html:cancel>
							<fmt:message key="button.cancel" />
						</html:cancel>
					</td>
				</tr>
			</table>

		</html:form>
	</body>
</html>

