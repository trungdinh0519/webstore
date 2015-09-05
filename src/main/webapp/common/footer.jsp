<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div id="footer">

	<div id="searchBottom">
		<table bgcolor="#999999" border="0" cellpadding="1" cellspacing="0"
			width="100%">
			<tbody>
				<tr>
					<td>
						<!-- Search Box --->
						<table bgcolor="#eeeecc" border="0" cellpadding="5"
							cellspacing="0" width="100%">
							<tbody>
								<tr>
									<td align="center">
										<form action="<c:url value="/pages/viewcategory.do"/>"
											method="post">
											<input type="hidden" name="method" value="search" />


											<b>T&igrave;m ki&#7871;m </b>
											<select name="categoryId">
												<option value="">

												</option>
												<c:forEach var="category" items="${categories}">
													<option value="<c:out value="${category.id }"/>">
														<c:out value="${category }" />
													</option>
												</c:forEach>
											</select>


											&nbsp;&nbsp;
											<input name="keyword" size="40" type="text" />
											&nbsp; &nbsp;

											<input src="<c:url value="/images/find.png"/>" name="Go"
												align="absmiddle" type="image" />
										</form>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="linkbottom">
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

	<div id="copyright">
		&copy; Nguyễn Đình Trung &nbsp;&nbsp;&nbsp; email:
		<a href="mailto:trungnd07@gmail.com">trungnd07@gmail.com</a>
	</div>
</div>
