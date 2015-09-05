<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div id="header">
	<div id="baner">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td width="132">
						<img src="<c:url value="/images/baner_01.gif"/>" width="132"
							height="90" />
					</td>
					<td width="461">
						<img src="<c:url value="/images/baner_02.gif"/>" width="461"
							height="90" />
					</td>
					<td width="" background="<c:url value="/images/baner_03.gif"/>">
						&nbsp;
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="tablink">
		<table width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td width="1">
					<img src="<c:url value="/images/siteDocsBgLeft.gif"/>" width="5"
						height="30" />
				</td>
				<td background="<c:url value="/images/siteDocsBg.gif"/>">
					<div id="navibar">
						<ul>
							<li>
								<html:link action="/pages/home">Trang chủ</html:link>
							</li>
							<li>
								<html:link action="/pages/gioithieu">Giới thiệu</html:link>
							</li>
							<li>
								<html:link action="/pages/Registry?method=registry">Đăng ký</html:link>
							</li>
							<li>
								<html:link action="/pages/viewcart">Giỏ hàng</html:link>
							</li>
							<li>
								<html:link action="/pages/contact">Liên hệ</html:link>
							</li>

						</ul>
					</div>
				</td>
				<td width="1">
					<img src="<c:url value="/images/siteDocsBgRight.gif"/>" width="5"
						height="30" />
				</td>
			</tr>
		</table>
	</div>

</div>
