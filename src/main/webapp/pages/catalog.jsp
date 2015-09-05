<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<body>

		<ul>
			<c:forEach var="cate" items="${categories}">
				<li class="catId">
					<a
						href="<c:url value="/pages/viewcategory.do?categoryId=${cate.id}"/>">
						<c:out value="${cate.name }"></c:out> </a>
					<span></span>
				</li>

			</c:forEach>
			<li class="catId">
				<a href="<c:url value="/pages/viewcategory.do?categoryId=all"/>">
					Tat ca</a>
				<span></span>
			</li>
		</ul>
	</body>
</html>
