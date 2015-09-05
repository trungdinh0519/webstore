<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="<c:url value="/styles/displaytag2.css"/>" rel="stylesheet"
			type="text/css" />
		

		<script type="text/javascript">
  		<!--
  		function checkDel(){
  			result=confirm("<fmt:message key="label.confirm.delete"/>");
  			return result;
  		}
  		function addnew(){
  			var form=document.plform1;
  			form.action="product.do?method=addnew";
  			form.submit();
  		}
  		-->
  		</script>
	</head>
	<body>

		<div>
			<div>
				<form action="product.do?method=search" method="post" name="plform1">

					<fmt:message key="label.search" />
					<select name="cateId">
						<option value="">
							<fmt:message key="label.productlist.selectCate" />
						</option>
						<c:forEach var="category" items="${categories}">
							<option value="<c:out value="${category.id }"/>">
								<c:out value="${category }" />
							</option>
						</c:forEach>

					</select>
					<input type="text" name="keyword">
					<input type="submit" value="<fmt:message key="button.search"/>">
					<input type="submit"
						value="<fmt:message
									key="label.display.addnew" />"
						onclick="return addnew();">
				</form>
				
				
			</div>
			<display:table name="products" sort="external" id="row"
				requestURI="/admin/product.do" partialList="true"
				pagesize="${pageSize}" size="resultSize">
				<display:column property="name" href="product.do?method=edit"
					paramId="id" paramProperty="id" titleKey="label.product.name_table" />
				<display:column property="category"
					titleKey="label.product.catalog_table" />
				<display:column property="manufacturer"
					titleKey="label.product.manufacturer_table" />
				<display:column property="unitPrice"
					titleKey="label.product.unitPrice_table" format="{0,number,0.00}">
				</display:column>
				<display:column>
					<a href="product.do?method=edit&id=<c:out value="${row.id}"/>"><fmt:message
							key="label.display.edit" /> </a>|
					<a onclick="return checkDel();"
						href="product.do?method=del&id=<c:out value="${row.id}"/>"><fmt:message
							key="label.display.del" /> </a>

				</display:column>
				<display:footer>
					<tr>
						<td colspan="5">
							
							<br>
						</td>
					</tr>
				</display:footer>
				<display:setProperty name="paging.banner.placement">bottom</display:setProperty>
				<display:setProperty name="paging.banner.some_items_found">

					<span class="pagebanner">Tìm thấy {0} {1}, từ {2} tới {3}</span>

				</display:setProperty>
				<display:setProperty name="paging.banner.no_items_found">
					<span class="pagebanner"> Không tìm thấy {0} </span>
				</display:setProperty>
				<display:setProperty name="basic.msg.empty_list">
					Không có sản phẩm nào
				</display:setProperty>

				<display:setProperty name="paging.banner.full">
					<span class="pagelinks"> [<a href="{1}">Đầu</a> /<a
						href="{2}">Trước</a>] {0} [<a href="{3}">Tiếp</a> /<a href="{4}">Cuối</a>]
					</span>
				</display:setProperty>
				<display:setProperty name="paging.banner.onepage">
					<span class="pagelinks"> </span>

				</display:setProperty>
				<display:setProperty name="paging.banner.all_items_found">
					<span class="pagebanner">Tìm thấy {0} {1}, hiển thị tất cả.</span>
				</display:setProperty>
				<display:setProperty name="paging.banner.items_name">
					sản phẩm
				</display:setProperty>
				
			</display:table>

		</div>

	</body>
</html>
