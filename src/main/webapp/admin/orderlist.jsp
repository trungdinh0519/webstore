<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="<c:url value="/styles/displaytag2.css"/>" rel="stylesheet"
			type="text/css" />
		<script language="JavaScript"
			src="<c:url value="/scripts/CalendarPopup.js"/>"></script>
		<script language="JavaScript">
		document.write(getCalendarStyles( ));		
		</script>
		<script type="text/javascript">
  		<!--
  		function checkDel(){
  			result=confirm("<fmt:message key="label.confirm.delete"/>");
  			return result;
  		}  		
  		-->
  		</script>
	</head>
	<body>

		<div>
			<div>
				<form action="order.do?method=search" method="post" name="plform1">
					<script language="JavaScript" type="text/javascript" id="jscal1x">
      					var cal1x = new CalendarPopup("testdiv1");
      					cal1x.showNavigationDropdowns( );
      					cal1x.setYearSelectStartOffset(60);
   					 </script>
					<fmt:message>label.fromDate</fmt:message>
					<input name="startDate" type="text" size="10" maxlength="30" readonly="true">
					<DIV id=testdiv1
						style="VISIBILITY:visible; POSITION:absolute; BACKGROUND-COLOR: white; layer-background-color: white; height:60px"></DIV>
					<a href=""
						onClick="cal1x.select(document.forms[0].startDate,'anchor1x','dd/MM/yyyy'); return false;"
						NAME="anchor1x" ID="anchor1x"><img
							src="<c:url value="/images/b_calendar.png"/>" border="0"></img> </A>
					<fmt:message>label.toDate</fmt:message>
					<input name="endDate" type="text" size="10" maxlength="30" readonly="true">
					<a href=""
						onClick="cal1x.select(document.forms[0].endDate,
                    'anchor2x','dd/MM/yyyy'); return false;"
						NAME="anchor2x" ID="anchor2x"><img
							src="<c:url value="/images/b_calendar.png"/>" border="0"></img> </A>
					<fmt:message>label.keyword</fmt:message>
					<input type="text" name="keyword" value="">
					<input type="submit" value="<fmt:message key="button.search"/>">

				</form>
			</div>
			<div align="center">
				<c:forEach var="row" items="${orderStatus}" varStatus="status">
					[<a
						href="<c:url value="order.do?method=search&osId="/><c:out value="${row.id}"/>"><c:out
							value="${row.name}" /> </a>]
					
				</c:forEach>
			</div>

			<div class="order">
				<display:table name="orders" id="row" requestURI="/admin/order.do"
					sort="external" partialList="true" pagesize="${pageSize}"
					size="resultSize">

					<display:column property="id" href="order.do?method=view"
						paramId="id" paramProperty="id" titleKey="label.order.id_table" />
					<display:column titleKey="label.order.name_table">
						<c:out value="${row.billToLastName}"></c:out>&nbsp;&nbsp;
					<c:out value="${row.billToFirstName}"></c:out>
					</display:column>
					<display:column titleKey="label.order.date_table">
						<fmt:formatDate value="${row.orderDate}" pattern="dd/MM/yyyy" />
					</display:column>

					<display:column titleKey="label.order.total">
						<fmt:formatNumber value="${row.orderTotal}" pattern="#.###"></fmt:formatNumber>
					&nbsp;<fmt:message key="label.currency" />
					</display:column>

					<display:column titleKey="label.order.status">
						<div><form
							action="<c:url value="/admin/order.do?method=updateStatus"/>">
							<input type="hidden" name="method" value="updateStatus">
							<input type="hidden" name="id" value="<c:out value="${row.id}"/>">
							<input type="hidden" name="oldStatusid"
								value="<c:out value="${row.status.id}"/>">
							<input type="hidden" name="return" value="listdo" />
							<select name="statusId">
								<c:forEach var="s" items="${orderStatus}">
									<c:if test="${s.id==row.status.id}">
										<option value="${s.id}" selected="selected">
											${s.name}
										</option>
									</c:if>
									<c:if test="${s.id!=row.status.id}">
										<option value="${s.id}">
											${s.name}
										</option>
									</c:if>
								</c:forEach>
							</select>
							<input type="submit" value="<fmt:message key="button.update"/>" />
						</form></div>
					</display:column>

					<display:column titleKey="label.order.view">
						<a href="order.do?method=view&id=<c:out value="${row.id}"/>">
							<fmt:message key="label.display.view" /> </a>
					</display:column>
					<display:column titleKey="label.order.remove">
						<a onClick="return checkDel();"
							href="order.do?method=del&id=<c:out value="${row.id}"/>"> <fmt:message
								key="label.display.del" /> </a>
					</display:column>
					<display:footer>
						<tr>
							<td colspan="5">
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
					Không có đơn hàng nào
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
					đơn hàng
				</display:setProperty>
				</display:table>
			</div>
		</div>
	</body>
</html>
