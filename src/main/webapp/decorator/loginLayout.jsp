<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<html:base />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><decorator:title default="goodstore" /></title>
		<jsp:include flush="true" page="/common/meta.jsp"></jsp:include>
		<link href="<c:url value="/styles/messages.css"/>" rel="stylesheet"
			type="text/css" />
		<link href="<c:url value="/styles/box_mod.css"/>" rel="stylesheet"
			type="text/css" />
		<link href="<c:url value="/styles/estcmlo.css"/>" rel="stylesheet"
			type="text/css" />
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
				<p>&nbsp;</p><p>&nbsp;</p>
				<div id="centerBody" align="center">
					<jsp:include page="/common/messages.jsp" />
					<decorator:body />
				</div>
				<p>&nbsp;</p><p>&nbsp;</p>
				<div id="hbmnu" align="center">
					<a href="#">item1</a> |
					<a href="#">item2</a> |
					<a href="#">item3</a>
				</div>
				<div id="footer" align="center">
					Copyright © 2007 - 2008 Nguyen Dinh Trung
					<BR>
				</div>
			</div>
		</center>

	</body>
</html>

