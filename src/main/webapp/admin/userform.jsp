<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>User Form</title>
		<link href="<c:url value="/styles/formtble.css"/>" rel="stylesheet"
			type="text/css" />
		<script language="javascript1.2" type="text/javascript"
			src="<c:url value="/scripts/him.js"/>"></script>
		<script language="javascript">
			function getProvince(country){
				var	form=document.userForm;
				form.action="user.do?method=addnew&c_code="+country;
				form.submit();
			}
		</script>
	</head>
	<body>
		<html:form action="/admin/userForm?method=save" method="post"
			styleId="userForm" onsubmit="return validateUserForm(this);">
			<table cellspacing="0" cellpadding="0" class="tblForm1">
				
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.username" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="username" size="40"/>
						<html:errors property="username" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.password" />
						<label class="red">
							*
						</label>
					</td>
					<td>
					<html:password property="password" size="40"></html:password>
						<html:errors property="password" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.confirmPassword" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:password property="confirmPassword" size="40"></html:password>
						<html:errors property="confirmPassword" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.firstname" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="firstname" size="40"/>
						<html:errors property="firstname" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.lastname" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="lastname" size="40"/>
						<html:errors property="lastname" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.email" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="email" size="40"/>
						<html:errors property="email" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.phone" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="phone" />
						<html:errors property="phone" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.website" />
						
					</td>
					<td>
						<html:text property="website" size="50"/>
						<html:errors property="website" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.address" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="address.address" size="50"/>
						<html:errors property="address.address" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.city" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="address.city" size="40"/>
						<html:errors property="address.city" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.province" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<c:if test="${not empty provinces}">
							<html:select property="address.province">
								<html:option value=""></html:option>
								
								<logic-el:iterate id="p" name="provinces">
									<html-el:option value="${p.code}">${p}</html-el:option>
								</logic-el:iterate>
							</html:select>
						</c:if>
						<c:if test="${empty provinces}">
							<html:text property="address.province" size="40"></html:text>
						</c:if>
						<html:errors property="address.province" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.country" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:select property="address.country"
							onchange="return getProvince(value);">
							<html:option value=""></html:option>
							<c:forEach var="c" items="${countries}">
								<html-el:option value="${c.code2}">${c}</html-el:option>
							</c:forEach>
						</html:select>
						<html:errors property="address.country" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.postalCode" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="address.postalCode" size="8"/>
						<html:errors property="address.postalCode" />
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
											value="${role.desc}"></c:out> </span>
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
		<html:javascript formName="userForm" />
	</body>
</html>

