<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>InfoLossPass.jsp</title>
</head>

<body>
	<fmt:message key="info.loss.pass" />
	<br>
	<html:form action="/pages/losspass?method=losspass" method="post"
		onsubmit="return validateLossPass(this);">
		<table>
			<tr>
				<th>
					<fmt:message key="label.username" />

				</th>
				<td>
					<html:text property="username"></html:text>
				</td>
			</tr>
			<tr>
				<th>
					<fmt:message key="label.email" />
				</th>
				<td>
					<html:text property="email"></html:text>
				</td>
			</tr>
			<tr>
				<th>

				</th>
				<td>
					<html:submit>
						<c:out value="Gửi"/>
					</html:submit>
				</td>
			</tr>
		</table>

	</html:form>
	<html:javascript formName="lossPass" />
</body>
</html:html>
