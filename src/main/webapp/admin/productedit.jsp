<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title></title>
		<link href="<c:url value="/styles/formtble.css"/>" rel="stylesheet"
			type="text/css" />
		<script language="javascript1.2" type="text/javascript"
			src="<c:url value="/scripts/him.js"/>"></script>
		<!-- TinyMCE -->
		<script type="text/javascript"
			src="<c:url value="/tinymce/jscripts/tiny_mce/tiny_mce.js"/>"></script>
		<script type="text/javascript">
	<!--
	// O2k7 skin
	tinyMCE.init({
		// General options
		mode : "exact",
		elements : "desc",
		theme : "advanced",
		plugins : "safari,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,inlinepopups",

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak",
		theme_advanced_buttons5:"insertdate,inserttime,preview,|,forecolor,backcolor,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_path_location : "bottom",
		theme_advanced_resizing : true,

		// Example content CSS (should be your site CSS)
		content_css : "../tinymce/examples/css/content.css",

		// Drop lists for link/image/media/template dialogs
		template_external_list_url : "../tinymce/examples/lists/template_list.js",
		external_link_list_url : "../tinymce/examples/lists/link_list.js",
		external_image_list_url : "../tinymce/examples/lists/image_list.js",
		media_external_list_url : "../tinymce/examples/lists/media_list.js",

		// Replace values for the template plugin
		template_replace_values : {
			username : "Some User",
			staffid : "991234"
		}
	});
	-->
</script>
	</head>
	<body>
		<html:form action="/admin/productEdit?method=update" method="post"
			enctype="multipart/form-data"
			onsubmit="return validateProductForm(this);">

			<table cellspacing="0" cellpadding="0" class="tblForm1">
				<tr>
					<td class="genericLabel" width="20%">
						<fmt:message key="label.product.id" />
					</td>
					<td width="80%">
						<html:hidden property="id" />
						<c:out value="${productForm.id }" />
					</td>
				</tr>
					<tr>
					<td class="genericLabel" width="15%">
						<fmt:message key="label.product.name" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="name" />
						<html:errors property="name" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.price" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="unitPrice" size="10" maxlength="12" />
						<fmt:message key="label.product.currency" />
						<html:errors property="unitPrice" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.discount" />
					</td>
					<td>
						<html:text property="discount" size="10" maxlength="12" />
						<fmt:message key="label.product.discount.percent" />
						<html:errors property="discount" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.unit" />
					</td>
					<td>
						<html:text property="unit" maxlength="32" />
						<html:errors property="unit" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.weight" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:text property="weight" size="10" maxlength="10" />
						<fmt:message key="label.product.unit_w" />
						<html:errors property="weight" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<fmt:message key="label.product.lblweight" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>

				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.length" />
					</td>
					<td>
						<html:text property="length" size="10" maxlength="10" />
						<fmt:message key="label.product.unit_lwh" />
						<html:errors property="length" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.width" />
					</td>
					<td>
						<html:text property="width" size="10" maxlength="10" />
						<fmt:message key="label.product.unit_lwh" />
						<html:errors property="width" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.height" />
					</td>
					<td>
						<html:text property="height" size="10" maxlength="10" />
						<fmt:message key="label.product.unit_lwh" />
						<html:errors property="height" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						&nbsp;
					</td>
					<td>
						<fmt:message key="label.product.lblkichthuoc" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.sortdesc" />
					</td>
					<td>
						<html:textarea property="sort_desc" cols="60" rows="5" />
						<html:errors property="sort_desc" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<p align="left"><fmt:message key="label.product.desc" /></p>
						<html:textarea property="desc" cols="90" rows="15" />
						<html:errors property="desc" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="genericLabel">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.smallImage" />
					</td>
					<td>
						<html:text property="smallImage" size="50" maxlength="255" />
						<html:errors property="smallImage" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.upload" />
					</td>
					<td>
						<html:file property="smallFile" />
						<html:errors property="smallFile" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.mediumImage" />
					</td>
					<td>
						<html:text property="mediumImage" size="50" maxlength="255" />
						<html:errors property="mediumImage" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.upload" />
					</td>
					<td>
						<html:file property="mediumFile" />
						<html:errors property="mediumFile" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.largeImage" />
					</td>
					<td>
						<html:text property="largeImage" size="50" maxlength="255" />
						<html:errors property="largeImage" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.upload" />
					</td>
					<td>
						<html:file property="largeFile" />
						<html:errors property="largeFile" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<fmt:message key="label.product.lblimg" />
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.manufacturer" />
					</td>
					<td>
						<html:select property="manufacturer">
							<html:option value="">
								<fmt:message key="label.app.select" />
							</html:option>
							<c:if test="${not empty manufacturers}">
								<c:forEach var="m" items="${manufacturers}">
									<html-el:option value="${m.id}">${m.name}</html-el:option>
								</c:forEach>
							</c:if>
						</html:select>

						<html:errors property="manufacturer" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.catalog" />
						<label class="red">
							*
						</label>
					</td>
					<td>
						<html:select property="category">
							<html:option value="">
								<fmt:message key="label.app.select" />
							</html:option>
							<c:if test="${not empty categories}">
								<c:forEach var="c" items="${categories}">
									<html-el:option value="${c.id}">${c.name}</html-el:option>
								</c:forEach>
							</c:if>
						</html:select>

						<html:errors property="category" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.stock" />
					</td>
					<td>
						<html:text property="stock" />
						<html:errors property="stock" />
					</td>
				</tr>

				<tr>
					<td class="genericLabel">

					</td>
					<td>
						<html:hidden property="taxed" value="true" />
						
					</td>
				</tr>
				
				<tr>
					<td class="genericLabel">
						<fmt:message key="label.product.active" />
					</td>
					<td>
						<html:radio property="active" value="true" />
						<fmt:message key="label.product.yes" />
						<html:radio property="active" value="false" />
						<fmt:message key="label.product.no" />
						<html:errors property="active" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<fmt:message key="label.product.lblactive" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<html:submit>
							<fmt:message key="button.save" />
						</html:submit>
						<html:cancel>
							<fmt:message key="button.cancel" />
						</html:cancel>
					</td>
				</tr>
			</table>



		</html:form>
		<html:javascript formName="productForm" />
	</body>
</html>

