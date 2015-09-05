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
				var	form=document.userForm;
				form.action="editProfile.do?method=edit&c_code="+country;
				form.submit();
			}
		
		</script>
	</head>
	<body>
	<% String username=request.getParameter("id"); %>
		<div id="heading">
			Đổi mật khẩu
		</div>
		<html:form action="/userpages/editPass?method=uppass" method="post"
			styleId="passForm" onsubmit="return validateUserForm(this);">
			<html:hidden property="username" value="<%=username%>"/>
			<table cellspacing="0" cellpadding="0" class="tblsignup1">
				<tr>
					<td class="genericLabel" width="15%">
						Mật khẩu cũ
						<label class="req">
							*
						</label>
					</td>
					<td>
						<html:password property="olePass" size="40"></html:password>
						<html:errors property="olePass" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						Mật khẩu mới
						<label class="req">
							*
						</label>
					</td>
					<td>
						<html:password property="newPass" size="40"></html:password>
						<html:errors property="newPass" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel" width="15%">
						Xác nhận mật khẩu
						<label class="req">
							*
						</label>
					</td>
					<td>
						<html:password property="cfPass" size="40"></html:password>
						<html:errors property="cfPass" />
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
			Form.focusFirtElement($('passForm'));
		</script>
		<html:javascript formName="passForm" />
	</body>
</html>
















