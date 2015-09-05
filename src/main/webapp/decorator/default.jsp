<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<html:base />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><decorator:title default="goodstore" />
		</title>
		<jsp:include flush="true" page="/common/meta.jsp"></jsp:include>
		<style type="text/css" media="all">
      		@import url("../styles/messages.css");
      		@import url("../styles/box_mod.css");
      		@import url("../styles/estcmlo.css");
      	</style>
		<decorator:head />
	</head>
	<body
		<decorator:getProperty property="body.onload" writeEntireProperty="true"/>
		<decorator:getProperty property="body.id" writeEntireProperty="true"/>
		<decorator:getProperty property="body.class" writeEntireProperty="true"/>>
		<center>
			<div id="contener" class="pageBase">
				<div id="header">
					<div id="baner">
						<table width="800" height="142" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<th width="93" scope="row">
									&nbsp;
								</th>
								<th width="202" scope="row">
									&nbsp;
								</th>
								<th height="23" colspan="2" scope="row">
									<div id="menu1" align="center">
										<!-- menu at here-->
										<html:link action="/pages/home">Trang chủ</html:link>
										|
										<html:link action="/pages/viewcart">Giỏ hàng</html:link>
										|
										<html:link action="/pages/contact">Liên hệ</html:link>
										|
										<authz:authorize ifAnyGranted="ROLE_ADMIN">
											<a href="<c:url value="/admin/"/>">Quản trị website</a>
										</authz:authorize>
									</div>
								</th>
							</tr>
							<tr>
								<th scope="row">
									&nbsp;
								</th>
								<th scope="row">
									&nbsp;
								</th>
								<th height="69" colspan="2" scope="row">
									&nbsp;
								</th>
							</tr>
							<tr>
								<th scope="row">
									&nbsp;
								</th>
								<th height="23" colspan="2" scope="row">
									<div id="menu2">
										<!-- menu at here-->
										<html:link action="/pages/Registry?method=registry"> Đăng ký </html:link>
										|
										<a href="<c:url value="/login.jsp"/>">Đăng Nhập</a> |
										<!-- <authz:authorize ifAnyGranted="ROLE_USER">
											<a href="<c:url value="/member.jsp"/>">Thành viên</a>
										</authz:authorize> -->
									</div>
								</th>
								<td width="223">
									&nbsp;
								</td>
							</tr>
							<tr>
								<th colspan="4" scope="row">
									<div id="menu3">
										<!-- menu at here-->
									</div>
								</th>
							</tr>
						</table>
					</div>
				</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr align="left" valign="top">
						<th class="leftPanel" width="183" height="522" scope="row">
							<div id="leftbody">
								<div id="search" class="mod">
									<div class="hd">
										Tìm kiếm
									</div>
									<div class="bd">
										<form action="<c:url value="/pages/viewcategory.do"/>"
											method="post">
											<input type="hidden" name="method" value="search" />
											<select name="categoryId">
												<option value="Tất cả">
												</option>
												<c:forEach var="category" items="${categories}">
													<option value="<c:out value="${category.id }"/>">
														<c:out value="${category }" />
													</option>
												</c:forEach>
											</select>
											<input type="text" name="keyword" size="15" />
											<input name="" type="submit" value="Tim">

											<!--<a href="#"><fmt:message key="label.searchAdvance" /> </a>-->
										</form>
									</div>
								</div>

								<div id="catelog" class="mod">
									<div class="hd">
										Danh mục
									</div>
									<div class="bd">
										<page:applyDecorator name="window" page="/pages/catalog.jsp" />
									</div>
								</div>

								<div id="cart" class="mod">
									<div class="hd">
										<a href="<c:url value="/pages/viewcart.do"/>"> Giỏ hàng </a>
									</div>
									<div class="bd">
										<ul>
											<li>
												Gi&#7887; h&agrave;ng c&oacute;
												<c:out value="${cart.soluong }" />
												s&#7843;n ph&#7849;m
											</li>
											<li>
												T&#7893;ng gi&aacute; tr&#7883; gi&#7887; h&agrave;ng:
												<fmt:formatNumber value="${cart.subTotal }" pattern="###"></fmt:formatNumber>
												<fmt:message>label.currency</fmt:message>
											</li>
											<li>
												<c:url var="checkUrl"
													value="/pages/billing.do?mt_code=fillbill"></c:url>

												<a id="dhang" href="<c:out value="${checkUrl}"/>">Đặt
													hàng </a>
											</li>
										</ul>
									</div>
								</div>
								<authz:authorize ifAnyGranted="ROLE_USER">
									<div id="member" class="mod">
										<div class="hd">
											<fmt:message key="welcome.tilte" />
											<authz:authentication operation="username" />
										</div>
										<div class="bd">
											<ul>
												<li>
													<a
														href="<c:url value="/pages/editProfile.do?method=edit&id="/><authz:authentication operation='username' />">
														Thông tin cá nhân </a>
												</li>
												<li>
													<a href="<c:url value="/userpages/editPassword.jsp"/>">Đổi
														mật khẩu</a>
												</li>
												<li>
													<a href="<c:url value="/userpages/order.do?method=list"/>">Đơn
														hàng đã đặt</a>
												</li>
												<li>
													<a href="<c:url value="/logout.jsp"/>"><fmt:message
															key="logout.title" /> </a>
												</li>
											</ul>
											<div>
											</div>
								</authz:authorize>
							</div>
						</th>
						<td width="617">
							<div id="centerBody">
								<jsp:include page="/common/messages.jsp" />
								<decorator:body />
							</div>
						</td>
					</tr>
				</table>
				<div id="hbmnu" align="center">
					<html:link action="/pages/home">Trang chủ</html:link>
					|
					<html:link action="/pages/Registry?method=registry"> Đăng ký </html:link>
					|
					<a href="<c:url value="/login.jsp"/>">Đăng Nhập</a> |
					<html:link action="/pages/contact">Liên hệ</html:link>
				</div>
				<div id="footer" align="center">
					Copyright © 2007 - 2008 Nguyen Dinh Trung
					<BR>
				</div>
			</div>
		</center>

	</body>
</html>

