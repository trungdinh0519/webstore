<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="../styles/productdetail.css" rel="stylesheet"
			type="text/css">

		<link rel="stylesheet" type="text/css"
			href="../styles/productlist.css" />
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/styles/productdetail.css"/>" />
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/styles/productlist.css"/>" />
		<script type="text/javascript">
  		<!--
  		function checkDel(){
  			result=confirm("<fmt:message key="label.confirm.delete"/>");
  			return result;
  		}  		
  		function kiemtra(){
			Form f=document.comentForm;
			if(f.comment.value.size<30)
			return false;
			else return true;
			}
  		-->
  		</script>
	</head>
	<body>
		<div id="productdetail">
			<div class="psortdesc">
				<div class="title">
					<c:out value="${product.category.name}" />
					&gt;
					<c:out value="${product.name}" />
				</div>
				<div class="img">
					<script type="text/javascript">//<![CDATA[
            document.write('<a href="javascript:void window.open(\'<c:url value="/upload/${product.mediumImage}"/>\', \'win2\', \'status=no,toolbar=no,scrollbars=yes,titlebar=no,menubar=no,resizable=yes,width=400,height=500,directories=no,location=no\');" title=""><img src="<c:url value="/upload/${product.mediumImage}"/>"  alt="" border="0" /><br/><fmt:message key='label.fullimage'/></a>');
            //]]></script>
					<noscript>
						<a href="<c:url value="/upload/${product.mediumImage}"/>"
							target="_blank" title=""><br /> <img
								src="<c:url value="/upload/${product.mediumImage}"/>" border="0" />
						</a>
					</noscript>
				</div>
				<div class="psdesc">
					<h3>
						<c:out value="${product.name }"></c:out>
					</h3>
					<ul>
						<li class="masanpham">
							<fmt:message key="label.product.id" />
							<c:out value="${product.id}" />
						</li>
						<li>
							<c:url value="/manufacturerInfo.do" var="mfurl">
								<c:param name="id" value="${product.manufacturer.id}" />
							</c:url>
							<script type="text/javascript">//<![CDATA[
            document.write('<a href="javascript:void window.open(\'<c:out value="${mfurl}"/>\', \'win2\', \'status=no,toolbar=no,scrollbars=yes,titlebar=no,menubar=no,resizable=yes,width=640,height=480,directories=no,location=no\');" title="">( <c:out
									value="${product.manufacturer.name}" /> )</a>');
            //]]></script>
							<noscript>
								<a href="<c:out value="${mfurl}"/>" target="_blank" title="">(<c:out
										value="${product.manufacturer.name}" />)</a>
							</noscript>

						</li>
						<li>
							<fmt:message key="label.product.salePrice" />
							<c:if test="${product.price!=product.unitPrice}">
								<span class="price_2"><fmt:formatNumber
										value="${product.unitPrice}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>&nbsp;&nbsp;&nbsp;
								<span class="price_3"><fmt:formatNumber
										value="${product.price}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>
							</c:if>
							<c:if test="${product.price==product.unitPrice}">
								<span class="price_1"><fmt:formatNumber
										value="${product.price}" pattern="# ###" /> <fmt:message
										key="label.currency" /> </span>
							</c:if>
						</li>
						<li>
							<fmt:message key="label.product.stock" />
							<c:out value="${product.stock}"></c:out>
							<c:out value="${product.unit}"></c:out>
						</li>
						<li>
							<c:out value="${product.sort_desc}"></c:out>
						</li>
						<li>
							<form id="addcart" name="addcart" method="get"
								action="<c:url value="/pages/addtocart.do"/>">
								<input type="hidden" name="productId" value="${product.id}" />
								<fmt:message key="label.quantity" />
								<input name="quantity" type="text" size="1" value="1" />
								<input name="" type="image" src="../images/Addtocart.gif">
							</form>
						</li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
			<div class="pdescription">
				<div>
					<h3>
						<fmt:message key="label.product.desc_title" />
					</h3>
				</div>
				<div class="text">
					<c:out value="${product.desc}" escapeXml="false"></c:out>
				</div>
			</div>
		</div>
		<hr>
		<jsp:include page="/common/messages.jsp" />
		<span class="req" style="color:red;"><c:out
				value="${error_val}"></c:out>
		</span>
		<authz:authorize ifAnyGranted="ROLE_USER">
			<form name="comentForm"
				action="<c:url value="/pages/writeComment.do"/>" method="post">
				Viết đánh giá:
				<input type="hidden" name="productId"
					value="<c:out value="${product.id }"/>">
				<p>
					<textarea name="comment" cols="70" rows="6"></textarea>
				</p>
				<p>
					<input type="submit" value="Ghi" />
				</p>
			</form>
			<hr>
		</authz:authorize>
		<c:if test="${not empty comments }">

			<c:forEach var="comment" items="${comments}">


				<table>
					<tr>
						<td width="500">
							<p>
								Tên:
								<c:out value="${comment.name}"></c:out>
								<br />
								Bình luận:
								<br />
								<c:out value="${comment.content}"></c:out>
								<br />
							</p>
						</td>
						<td width="50">
							<authz:authorize ifAnyGranted="ROLE_ADMIN">
								<form action="<c:url value="/pages/delComment.do"/>"
									method="post">
									<input type="hidden" name="id"
										value="<c:out value="${comment.id }"/>">
									<input type="hidden" name="pid"
										value="<c:out value="${product.id }"/>">
									<input type="submit" value="Xóa" />
								</form>
							</authz:authorize>
						</td>
					</tr>
				</table>

				<hr width="50%" />
			</c:forEach>
		</c:if>

	</body>
</html>


