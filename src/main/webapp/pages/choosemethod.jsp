<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>Dat hang</title>
		<link href="../styles/bangttkhach.css" rel="stylesheet" type="text/css">
		<link href="<c:url value="/styles/bangttkhach.css"/>" rel="stylesheet" type="text/css">
		<script language="javascript1.2" type="text/javascript"
			src="<c:url value="/scripts/him.js"/>"></script>
		<script language="javascript">
		 function back(){
				var	form=document.chooseMethodForm;
				form.action="<c:url value='/pages/shipping.do?mt_code=fillshipinfo'/>";
				form.submit();	
			
			}	
		</script>
	</head>
	<body>
		<h3>
			<fmt:message key="label.order.heading" />
		</h3>
		<jsp:include flush="true" page="/common/cartcheck.jsp"></jsp:include>
		<hr />
		<div id="choosemethod">
			<html:form action="/pages/processchoosemethod?mt_code=processcm"
				styleId="chooseMethodForm" method="post"
				onsubmit="return validateChooseMethodForm(this);">
				
				<h3>
					<fmt:message key="chooseshipmethod.title" />
				</h3>
				<table cellpadding="0" cellspacing="0" border="0" width="100%"
					class="shipselect">
					<thead>
						<tr>
							<th>&nbsp;</th>
							<th>
								<fmt:message key="chooseshipmethod.name.title" />							</th>
							<th>
								Gia							</th>
						</tr>
					</thead>
					<c:if test="${not empty lineships}">
						<c:forEach var="item" items="${lineships }">
							<tr>
								<td>
									<html-el:radio property="shipmethod"
										value="${item.shipMethod.id}"></html-el:radio>								</td>
								<td>
									<c:out value="${item.shipMethod.name}" />								</td>
								<td>
									<c:out value="${item.shiprate }"></c:out>

									<fmt:message key="label.currency" />								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>

				<hr />
				<div class="buttonbarcenter">
					<html:submit onclick="return back();">
						<fmt:message key="button.forward" />
					</html:submit>
					<html:submit>
						<fmt:message key="button.next" />
					</html:submit>
				</div>
				</html:form>
				<html:javascript formName="chooseMethodForm" />
				
	</div>
	</body>
</html>

