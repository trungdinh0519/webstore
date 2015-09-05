<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title><fmt:message key="label.login" />
		</title>
			<style type="text/css" media="all">
      		@import url("../styles/forms.css");
      		
      	</style>
		<script type="text/javascript"
			src="<c:url value="/scripts/login.js"/>">
		</script>
		<script type="text/javascript"
			src="<c:url value="/scripts/jsval.js"/>">
		</script>
		<script type="text/javascript"
			src="<c:url value="/scripts/prototype.js"/>">
		</script>
	</head>

	<body onLoad="initValidation();">
		<div id="heading">
			 <!--     <fmt:message key="label.login" /> -->
		</div>
		<form name="loginForm" action="<c:url value='/login_check'/>"
			onSubmit="return validateStandard(this);" method="POST">
			<fieldset>
				<ul>
					<c:if test="${param.login_error != null}">
						<li class="error">
							<img src="<c:url value="/images/iconWarning.gif"/>"
								alt="<fmt:message key="icon.warning"/>">
							<fmt:message key="errors.password.mismatch" />
							
							<c:out value="${ACEGI_SECURITY_LAST_USERNAME}" />
						</li>
					</c:if>

					<li>
						<label for="j_username" class="desc">
							<fmt:message key="label.username" />
							<span class="req">*</span>
						</label>
						<input type='text' name='j_username' class="text medium"
							id="j_username"
							<c:if test="${not empty param.login_error}">value='<c:out value="${ACEGI_SECURITY_LAST_USERNAME}"/>'</c:if>>
					</li>
					<li>
						<label for="j_password" class="desc">
							<fmt:message key="label.password" />
							<span class="req">*</span>
						</label>

						<input type='password' name='j_password' class="text medium"
							id="j_password">

					</li>
					<li>
						<input type="checkbox" name="rememberMe">
						<label>
							<fmt:message key="label.rememberMe" />
						</label>
					</li>

					<li>
						<input name="submit" class="button" type="submit"
							value=<fmt:message key="button.login"/>>
					</li>
					<li>
						<a href="<c:url value='/pages/losspass.jsp'/>"><fmt:message
								key="label.retrive.lostpassword" /> </a>
					</li>
				</ul>

			</fieldset>


		</form>

	</body>
</html>
