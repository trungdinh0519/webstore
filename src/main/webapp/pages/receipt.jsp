<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<head>
	</head>
	<body>
		<c:if test="${successpay}">
			<p>
				&nbsp;
			</p>
			<p align="justify"><b>
				&#272;&#417;n h&agrave;ng c&#7911;a qu&yacute; kh&aacute;ch
				&#273;&atilde; &#273;&#432;&#7907;c l&#432;u.Ch&uacute;ng t&ocirc;i
				s&#7869; chuy&#7875;n h&agrave;ng cho qu&yacute; kh&aacute;ch trong
				th&#7901;i gian s&#7899;m nh&#7845;t.Xin ch&acirc;n th&agrave;nh
				c&#7843;m &#417;n ch&uacute;c qu&yacute; kh&aacute;ch c&oacute;
				&#273;&#432;&#7907;c s&#7843;n ph&#7849;m ph&ugrave; h&#7907;p!</b>
			</p>

			<div align="center">
				<c:url var="continueUrl" value="/pages/continueShopping.do"></c:url>
				<form action="<c:out value="${continueUrl}"/>" name="continueShoppingForm"
					method="post">
					<input type="button" name="continue"
						value="<fmt:message key="label.cart.continue"/>"
						onclick="document.location.href='<c:out value="${continueUrl}"/>'" />
					
				</form>
			</div>
		</c:if>

	</body>
</html>
