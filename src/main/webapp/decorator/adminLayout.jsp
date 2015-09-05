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
      		@import url("../styles/htwomnu.css");
      	</style>
      	<SCRIPT type=text/javascript>
		<!--
		window.onload=montre;
		function montre(id) {
		var d = document.getElementById(id);
			for (var i = 1; i<=10; i++) {
				if (document.getElementById('smenu'+i)) {document.getElementById('smenu'+i).style.display='none';}
			}
		if (d) {d.style.display='block';}
		}
		//-->
		</SCRIPT>
      	
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
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr align="left" valign="top">
						<td>
							<DIV id=ammenu>
								<DL>
									<DT onMouseOver="montre('smenu1');">
										<A href="#"><html:link
												action="/admin/editconfig?mt_code=edit">
												<fmt:message key="label.config" />

											</html:link> </A>
									</DT>
									<DD id=smenu1>
										<UL>

										</UL>
									</DD>
								</DL>
								<DL>
									<DT onMouseOver="montre('smenu2');">
										<a href="<c:url value="/admin/user.do?method=list"/>"><fmt:message
												key="label.member" /> </a>
									</DT>
									<DD id=smenu2>
										<UL>

										</UL>
									</DD>
								</DL>
								<DL>
									<DT onMouseOver="montre('smenu3');">
										<a href="<c:url value="/admin/mf.do?method=list"/>"> <fmt:message
												key="label.manufacturer" /> </a>
									</DT>
									<DD id=smenu3>
										<UL>

										</UL>
									</DD>
								</DL>
								<DL>
									<DT onMouseOver="montre('smenu4');">
										<a href="<c:url value="/admin/category.do?method=list"/>">
											Danh mục</a>
									</DT>
									<DD id=smenu4>
										<UL>

										</UL>
									</DD>
								</DL>
								<DL>
									<DT onMouseOver="montre('smenu5');">
										<a href="<c:url value="/admin/product.do?method=list"/>"><fmt:message
												key="label.product" /> </a>
									</DT>
									<DD id=smenu5>
										<UL>
											
										</UL>
									</DD>
								</DL>
								<DL>
									<DT onMouseOver="montre('smenu6');">
										<fmt:message key="label.location" />
									</DT>
									<DD id=smenu6>
										<UL>
											<LI>
												<a href="<c:url value="/admin/country.do?method=list"/>">
													<fmt:message key="label.country" /> </a>
											<LI>
												<a href="<c:url value="/admin/province.do?method=list"/>"><fmt:message
														key="label.province" /> </a>
										</UL>
									</DD>
								</DL>
								<DL>
									<DT onMouseOver="montre('smenu7');">
										<fmt:message key="label.shiprate" />
									</DT>
									<DD id=smenu7>
										<UL>
											<LI>
												<a href="<c:url value="/admin/shipMethod.do?method=list"/>"><fmt:message
														key="label.shipmethod" /> </a>
											<LI>
												<a href="<c:url value="/admin/shiprate.do?method=list"/>"><fmt:message
														key="label.shiprate_incountry" /> </a>
										</UL>
									</DD>
								</DL>
								<DL>
									<DT onMouseOver="montre('smenu7');">
										<a href="<c:url value="/admin/order.do?method=list"/>"> <fmt:message
												key="label.order" /> </a>
									</DT>
									<DD id=smenu7>
										<UL>

										</UL>
									</DD>
								</DL>

							</DIV>
							<p>
								&nbsp;
							</p>
							<p>
								&nbsp;
							</p>
							<div id="centerBody">

								<jsp:include page="/common/messages.jsp" />
								<decorator:body />
							</div>
							<p>
								&nbsp;
							</p>
							<p>
								&nbsp;
							</p>
						</td>
					</tr>
				</table>
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

