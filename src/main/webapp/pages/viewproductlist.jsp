<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/styles/productlist.css"/>" />

	</head>
	<body>
		<div id="productlist">
			<display:table name="products" sort="external" id="row"
				requestURI="/pages/viewcategory.do" partialList="true"
				pagesize="${pageSize}" size="resultSize" class="list">
				<display:column titleKey="label.list.title">
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

								<input type="hidden" name="urlreturn"
									value="/pages/viewcategory.do">
								<input type="hidden" name="productId" value="${row.id}" />
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
							    ">
								</div>

							</form>

						</div>

						<div class="clear"></div>
					</div>
				</display:column>
				<display:setProperty name="paging.banner.some_items_found">
					<span class="pagebanner">{0} {1} </span>
				</display:setProperty>
				<display:setProperty name="paging.banner.no_items_found">
					<span class="pagebanner"> Không tìm thấy {0} </span>
				</display:setProperty>
				<display:setProperty name="basic.msg.empty_list">
					Không có sản phẩm nào
				</display:setProperty>
				<display:setProperty name="paging.banner.full">
					<span class="pagelinks"> [<a href="{1}"> &lt;&lt; </a> /<a
						href="{2}">&lt;</a>] {0} [<a href="{3}">&gt;</a> /<a href="{4}">&gt;&gt;</a>]
					</span>
				</display:setProperty>
				<display:setProperty name="paging.banner.onepage">
					<span class="pagelinks">/ {0} trang </span>
				</display:setProperty>
				<display:setProperty name="paging.banner.all_items_found">
					<span class="pagebanner">Tìm thấy {0} {1}, hiển thị tất cả.</span>
				</display:setProperty>
				<display:setProperty name="paging.banner.items_name">
					sản phẩm
				</display:setProperty>
				<display:setProperty name="paging.banner.one_item_found">
					<span class="pagebanner"> Một sản phẩm </span>
					
				</display:setProperty>


			</display:table>

		</div>

	</body>
</html>
