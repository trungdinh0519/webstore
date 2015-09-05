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
  			form.action="shiprate.do?method=addnew";
  			form.submit();
  		}
  		function getShiprate(value){
			var	form=document.plform1;
			form.action="shiprate.do?method=search&smId="+value;
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
					<select name="smId" onChange="return getShiprate(value);">
						<option value="">
							<fmt:message key="label.app.select" />
						</option>
						<c:forEach var="method" items="${methods}">
							<option value="<c:out value="${method.id }"/>">
								<c:out value="${method}" />
							</option>
						</c:forEach>

					</select>
					
				</form>
				<form action="" method="post" name="shiprateForm">
					
					
				</form>
			</div>
			<display:table name="shiprates" id="row"
				requestURI="/admin/shiprate.do">
				<display:column property="method"
					titleKey="label.shiprate.method_table"></display:column>
				<display:column property="name" href="shiprate.do?method=edit"
					paramId="id" paramProperty="id"
					titleKey="label.shiprate.name_table" />
				<display:column property="from" titleKey="label.shiprate.from_table"></display:column>
				<display:column property="to" titleKey="label.shiprate.to_table"></display:column>
				<display:column property="price"
					titleKey="label.shiprate.price_table" format="{0,number,0.00}"></display:column>
				<display:column>
					<a href="shiprate.do?method=edit&id=<c:out value="${row.id}"/>"><fmt:message
							key="label.display.edit" /> </a>|
					<a onclick="return checkDel();"
						href="shiprate.do?method=del&id=<c:out value="${row.id}"/>"><fmt:message
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
