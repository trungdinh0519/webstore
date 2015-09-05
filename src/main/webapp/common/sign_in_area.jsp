<%@ include file="/common/taglibs.jsp"%>

<html>
	<body>
		<table>
			<tr>
				<td>
					<span id="welcome"><fmt:message key="welcome.tilte" />
					</span>
				</td>

				<authz:authorize ifAnyGranted="ROLE_USER">
					<td>
						<span id="username"><authz:authentication
								operation="username" />|</span>
					</td>
					<td>
						&nbsp;
						<a href="<c:url value="/logout.jsp"/>"><fmt:message key="logout.title" />
						</a>
					</td>
				</authz:authorize>
				 <authz:authorize ifNotGranted="ROLE_USER">
					<td>
					<fmt:message>label.customer.welcome</fmt:message>
					</td>
				</authz:authorize> 
			</tr>
		</table>
	</body>
</html>
