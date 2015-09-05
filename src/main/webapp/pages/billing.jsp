<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>Dat hang</title>
		<link href="../styles/bangttkhach.css" rel="stylesheet" type="text/css">
		<link href="<c:url value="/styles/bangttkhach.css"/>" rel="stylesheet" type="text/css">
		<style type="text/css">

        </style>
		<script language="javascript1.2" type="text/javascript"
			src="<c:url value="/scripts/him.js"/>"></script>
		<script language="javascript">
			function getProvince(country){
				var	form=document.billingForm;
				form.action="<c:url value='/pages/billing.do?mt_code=fillbill'/>";
				form.action+="&c_code="+country;
				form.submit();				
			}		
			function back(){
				var	form=document.billingForm;
				form.action="cart.jsp";
				form.submit();
			return false;
			}	
		</script>
	</head>
	<body>
		<h3>
			<fmt:message key="label.order.heading" />
		</h3>
		<jsp:include flush="true" page="/common/cartcheck.jsp"></jsp:include>
		<hr />
		<p class="pleaseInfo">
			<fmt:message key="label.order.pleaseEnterInfo" />
		</p>
		<div id="billInfo" class="infocustomer">
			<html:form action="/pages/saveBillInfo?mt_code=nextship"
				method="post" onsubmit="return validateBillingForm(this);"
				styleId="billingForm">
				<h3>
					<fmt:message key="billinfo.title" />
				</h3>
				<table cellpadding="0" cellspacing="0" border="0" width="100%"
					class="tableForm1">

					<tr>
						<th>
							<fmt:message key="label.firstname" />
							<label class="req">
								*
							</label>
						</th>
						<td>
							<html:text property="firstname" size="30"></html:text>
							<html:errors property="firstname" />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="label.lastname" />
							<label class="req">
								*
							</label>
						</th>
						<td>
							<html:text property="lastname" size="30"></html:text>
							<html:errors property="lastname" />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="label.email" />
							<label class="req">
								*
							</label>
						</th>
						<td>
							<html:text property="email" size="30"></html:text>
							<html:errors property="email" />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="label.phone" />
							<label class="req">
								*
							</label>
						</th>
						<td>
							<html:text property="phone" size="30"></html:text>
							<html:errors property="phone" />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="label.address" />
							<label class="req">
								*
							</label>
						</th>
						<td>
							<html:text property="address" size="30"></html:text>
							<html:errors property="address" />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="label.city" />
							<label class="req">
								*
							</label>
						</th>
						<td>
							<html:text property="city" size="30"></html:text>
							<html:errors property="city" />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="label.province" />
							<label class="req">
								*
							</label>
						</th>
						<td>
							<html:hidden property="province_name" />
							<c:if test="${not empty provinces}">

								<html:select property="province">
									<html:option value=""></html:option>
									<logic-el:iterate id="p" name="provinces">
										<html-el:option value="${p.code}">${p}</html-el:option>
									</logic-el:iterate>
								</html:select>
							</c:if>
							<c:if test="${empty provinces}">
								<html:text property="province" size="40"></html:text>
							</c:if>
							<html:errors property="province" />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="label.country" />
							<label class="req">
								*
							</label>
						</th>
						<td>
							<html:select property="country"
								onchange="return getProvince(value);">
								<html:option value=""></html:option>
								<c:forEach var="c" items="${countries}">
									<html-el:option value="${c.code2}">${c}</html-el:option>
								</c:forEach>
							</html:select>
							<html:errors property="country" />
						</td>
					</tr>
					<tr>
						<th>
							<fmt:message key="label.postalCode" />

						</th>
						<td>
							<html:text property="postalCode" size="8" />
							<html:errors property="postalCode" />
						</td>
					</tr>

				</table>
				<h3>
					<fmt:message key="shipinfo.title" />
				</h3>
				<html:radio property="chooseAddShip" value="SaveAs">
					<fmt:message key="label.billing.shipsaveas" />
				</html:radio>
				<html:radio property="chooseAddShip" value="ShipNew">
					<fmt:message key="label.billing.shipnew" />
				</html:radio>
				<hr />
				<div class="buttonbarcenter">
					
					<html:submit onclick="return back();">
						<fmt:message key="button.forward" />
					</html:submit>
					<html:submit>
						<fmt:message key="button.next" />
					</html:submit>
				</div>
			</html:form>
			<html:javascript formName="billingForm" />
		</div>
	</body>
</html>
