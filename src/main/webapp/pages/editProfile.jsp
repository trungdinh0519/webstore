<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
	<head>
		<title></title>
		<link href="<c:url value="/styles/formtble.css"/>" rel="stylesheet"
			type="text/css" />
		<script language="javascript1.2" type="text/javascript"
			src="<c:url value="/scripts/him.js"/>"></script>
		<script language="javascript">
			
			function getProvince(country){
				var	form=document.UserInfo;
				form.action="editProfile.do?method=edit&c_code="+country;
				form.submit();
			}
		
		</script>
	</head>
	<body>
		<div id="heading">
			<fmt:message key="label.profile" />
		</div>
		<html:form action="/pages/profile?method=upPf" method="post"
			styleId="UserInfo" onsubmit="return validateUserForm(this);">

			<table cellspacing="0" cellpadding="0" class="tblsignup1">

				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.username" />

					</td>
					<td><c:out value="${userForm.username}"></c:out>
						<html:hidden property="username" />
					</td>
				</tr>
				
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.firstname" />
						<label class="req">
							*
						</label>
					</td>
					<td>
						<html:text property="firstname" size="40" />
						<html:errors property="firstname" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.lastname" />
						<label class="req">
							*
						</label>
					</td>
					<td>
						<html:text property="lastname" size="40" />
						<html:errors property="lastname" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.email" />
						<label class="req">
							*
						</label>
					</td>
					<td>
						<html:text property="email" size="40" />
						<html:errors property="email" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.phone" />
						<label class="req">
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
						<html:text property="website" size="50" />
						<html:errors property="website" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.address" />
						<label class="req">
							*
						</label>
					</td>
					<td>
						<html:text property="address.address" size="50" />
						<html:errors property="address.address" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.city" />
						<label class="req">
							*
						</label>
					</td>
					<td>
						<html:text property="address.city" size="40" />
						<html:errors property="address.city" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.province" />
						<label class="req">
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
						<label class="req">
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
						
					</td>
					<td>
						<html:text property="address.postalCode" size="8" />
						<html:errors property="address.postalCode" />
					</td>
				</tr>

				<tr>
					<td>
					</td>
					<td class="button">
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
		<p>
		</p>
		<script type="text/javascript">
			Form.focusFirtElement($('UserInfo'));
		</script>
		<html:javascript formName="UserInfo" />
	</body>
</html>

