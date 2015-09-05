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
  			form.action="shipMethod.do?method=addnew";
  			form.submit();
  		}
  		-->
  		</script>
	</head>
	<body>

		<div>
			<div>
				<form action="#" method="post" name="plform1">

					<input type="submit"
						value="<fmt:message
									key="label.display.addnew" />"
						onclick="return addnew();">
				</form>
			</div>
			<display:table name="shipMethods" id="row"
				requestURI="/admin/shipMethod.do">
				<display:column property="name" href="shipMethod.do?method=edit"
					paramId="id" paramProperty="id"
					titleKey="label.shipMethod.name_table" />
				<display:column property="desc"
					titleKey="label.shipMethod.desc_table" />
				<display:column>
					<a href="shipMethod.do?method=edit&id=<c:out value="${row.id}"/>"><fmt:message
							key="label.display.edit" /> </a>|
					<a onclick="return checkDel();"
						href="shipMethod.do?method=del&id=<c:out value="${row.id}"/>"><fmt:message
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
			</display:table>

		</div>

	</body>
</html>
