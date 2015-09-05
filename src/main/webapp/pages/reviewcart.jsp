<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<jsp:directive.page import="java.util.*;" />
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Dat hang</title>
		<script language="javascript1.2" type="text/javascript"
			src="<c:url value="/scripts/him.js"/>"></script>
		<script language="javascript">
		
		</script>
	</head>
	<body>
		<h3>
			<fmt:message key="label.order.checkout" />
		</h3>
		<jsp:include flush="true" page="/common/cartcheck.jsp"></jsp:include>
		<hr/>
		<div class="buttons">
			<form name="ReviewCartForm"
				action="<c:out value="${paygate_endpoint}"/>" method="get">
				<%@ include file="/common/upload_cart.jsp"%>
				<c:url var="backURL" value="/pages/choosemethod.do?mt_code=cmethod" />
				<c:url var="posURL" value="/pages/poscheckout.jsp" />
				<input type="button" name="back"
					value="<fmt:message key="button.forward" />"
					onclick="document.location.href='<c:out value="${backURL}"/>';" />
				<input type="button" name="checkoutPosBtn"
					value="<fmt:message key="button.checkoutPos" />"
					onclick="document.location.href='<c:out value="${posURL}"/>';" />
				<input type="submit" name="checkoutPaypalBtn"
					value="<fmt:message key="button.checkoutPaypal" />" />
			</form>
		</div>


	</body>
</html>
