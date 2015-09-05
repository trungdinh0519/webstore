<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>
	<body>
		<div>
			<h3>
				<c:out value="${manufacturer.name}" />
			</h3>
			<p>
				Email:
				<a href="<c:out value="${manufacturer.email}"/>"><c:out
						value="${manufacturer.email}" /> </a>
			</p>
			<p>
				Website:
				<a href="<c:out value="${manufacturer.url}"/>"><c:out
						value="${manufacturer.url}" /> </a>
			</p>
			<p>
				<c:out value="${manufacturer.desc}" />
			</p>
		</div>

	</body>
</html>
