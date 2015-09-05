<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
<link rel="stylesheet" type="text/css"
			href="<c:url value="/styles/productlist.css"/>" />

		<link rel="stylesheet" type="text/css"
			href="../styles/productlist.css" />
	</head>
	<body>
		<div id="productlist">
			<display:table name="productnews" sort="external" id="row"
				requestURI="/pages/home.do"  class="list">
				<display:column titleKey="label.listnew.title">
					<div class="lineproduct">
						<c:url var="pdetail" value="/pages/productDetail.do">
							<c:param name="productId" value="${row.id}"></c:param>
						</c:url>
						<a href="${pdetail}"><img
								src="<c:url value="/upload/${row.smallImage}"/>" border="0" />
						</a>
						<div class="protsortdesc">
							<a href="${pdetail }"> <c:out value="${row.name}"></c:out> </a>
							<br />
							<fmt:message key="label.product.salePrice" />
							<c:if test="${row.price!=row.unitPrice}">
								<span class="price_2"><fmt:formatNumber
										value="${row.unitPrice}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>&nbsp;&nbsp;&nbsp;
								<span class="price_3"><fmt:formatNumber
										value="${row.price}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>
							</c:if>
							<c:if test="${row.price==row.unitPrice}">
								<span class="price_1"><fmt:formatNumber
										value="${row.price}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>
							</c:if>
							<br />

							<c:out value="${row.sort_desc}">&nbsp;&nbsp;</c:out>
							<a href="${pdetail }">Chi ti&#7871;t </a>
							<br />
							<form id="addcart" name="addcart" method="get"
								action="<c:url value="/pages/addtocart.do"/>">
								<input type="hidden" name="urlreturn" value="/pages/home.do">
								<input type="hidden" name="productId" value="${row.id}" />
								<!--<fmt:message key="label.quantity" />
								<input name="quantity" type="text" size="1" value="1" />-->
								<div id="instock">
								  <fmt:message key="label.product.stock" />
								  <c:out value="${row.stock}"></c:out>
								  <c:out value="${row.unit}"></c:out>
						  </div>
					    <!--<fmt:message key="label.quantity" />
								<input name="quantity" type="text" size="1" value="1" />-->
								<div id="addcartbutton">
								  <input name="addcart" type="image"
									src="<c:url value="/images/Addtocart.gif"/>
							    "></div>

							</form>

						</div>

						<div class="clear"></div>
					</div>
				</display:column>
				<display:setProperty name="paging.banner.some_items_found">

					<span class="pagebanner">Tim thay {0} {1}, tu {2} toi {3}</span>

				</display:setProperty>
				<display:setProperty name="paging.banner.no_items_found">
					<span class="pagebanner"> Khong tim thay {0} </span>
				</display:setProperty>
				<display:setProperty name="basic.msg.empty_list">
					Khong co san pham nao
				</display:setProperty>

				<display:setProperty name="paging.banner.full">
					<span class="pagelinks"> [<a href="{1}">Dau</a> /<a
						href="{2}">Truoc</a>] {0} [<a href="{3}">Tiep</a> /<a href="{4}">Cuoi</a>]
					</span>
				</display:setProperty>
				<display:setProperty name="paging.banner.onepage">
					<span class="pagelinks"> </span>

				</display:setProperty>
				<display:setProperty name="paging.banner.all_items_found">
					<span class="pagebanner">Tim thay {0} {1}, hien thi tat ca.</span>
				</display:setProperty>
				<display:setProperty name="paging.banner.items_name">
					san pham
				</display:setProperty>


			</display:table>

		</div>
		<div id="productlist">
			<display:table name="productdiscounts" sort="external" id="row"
				requestURI="/pages/home.do"  class="list">
				<display:column titleKey="label.listdiscount.title">
					<div class="lineproduct">
						<c:url var="pdetail" value="/pages/productDetail.do">
							<c:param name="productId" value="${row.id}"></c:param>
						</c:url>
						<a href="${pdetail}"><img
								src="<c:url value="/upload/${row.smallImage}"/>" border="0" />
						</a>
						<div class="protsortdesc">
							<a href="${pdetail }"> <c:out value="${row.name}"></c:out> </a>
							<br />
							<fmt:message key="label.product.salePrice" />
							<c:if test="${row.price!=row.unitPrice}">
								<span class="price_2"><fmt:formatNumber
										value="${row.unitPrice}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>&nbsp;&nbsp;&nbsp;
								<span class="price_3"><fmt:formatNumber
										value="${row.price}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>
							</c:if>
							<c:if test="${row.price==row.unitPrice}">
								<span class="price_1"><fmt:formatNumber
										value="${row.price}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>
							</c:if>
							<br />

							<c:out value="${row.sort_desc}">&nbsp;&nbsp;</c:out>
							<a href="${pdetail }">Chi ti&#7871;t </a>
							<br />
							<form id="addcart" name="addcart" method="post"
								action="<c:url value="/pages/addtocart.do"/>">

								<input type="hidden" name="productId" value="${row.id}" />
								<!--<fmt:message key="label.quantity" />
								<input name="quantity" type="text" size="1" value="1" />-->
								<div id="instock">
								  <fmt:message key="label.product.stock" />
								  <c:out value="${row.stock}"></c:out>
								  <c:out value="${row.unit}"></c:out>
						  </div>
					    <!--<fmt:message key="label.quantity" />
								<input name="quantity" type="text" size="1" value="1" />-->
								<div id="addcartbutton">
								  <input name="addcart" type="image"
									src="<c:url value="/images/Addtocart.gif"/>
							    "></div>

							</form>

						</div>

						<div class="clear"></div>
					</div>
				</display:column>
				<display:setProperty name="paging.banner.some_items_found">

					<span class="pagebanner">Tim thay {0} {1}, tu {2} toi {3}</span>

				</display:setProperty>
				<display:setProperty name="paging.banner.no_items_found">
					<span class="pagebanner"> Khong tim thay {0} </span>
				</display:setProperty>
				<display:setProperty name="basic.msg.empty_list">
					Khong co san pham nao
				</display:setProperty>

				<display:setProperty name="paging.banner.full">
					<span class="pagelinks"> [<a href="{1}">Dau</a> /<a
						href="{2}">Truoc</a>] {0} [<a href="{3}">Tiep</a> /<a href="{4}">Cuoi</a>]
					</span>
				</display:setProperty>
				<display:setProperty name="paging.banner.onepage">
					<span class="pagelinks"> </span>

				</display:setProperty>
				<display:setProperty name="paging.banner.all_items_found">
					<span class="pagebanner">Tim thay {0} {1}, hien thi tat ca.</span>
				</display:setProperty>
				<display:setProperty name="paging.banner.items_name">
					san pham
				</display:setProperty>


			</display:table>

		</div>
	</body>
</html>
