<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
  		<!--
  		function checkDel(){
  			result=confirm("<fmt:message key="label.confirm.delete"/>");
  			return result;
  		}
  		-->
  		</script>
		<style type="text/css">
<!--
.config th {
	font-size: 12px;
	text-align: left;
	padding-top: 5px;
	padding-bottom: 5px;
	padding-left: 10px;
}
.config p {
	text-align: left;
	padding:4px 0 4px 0;
	color: #FF6600;
}
.config .button {
	text-align: center;
	margin-top: 30px;
	margin-bottom: 50px;
}
-->
        </style>
	</head>
	<body>
		<div class="config">
		  <html:form action="/admin/saveconfig?mt_code=save">
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<th colspan="2">
							<p>
								Cấu hình cho thanh toán qua paypal
							</p>
						</th>
					</tr>
					<tr>
						<th>

							<fmt:message>label.config.moitruong</fmt:message>
						</th>
						<td>

							<html-el:select property="moitruong">
								<html:option value="sandbox">Sandbox(môi trường thử nghiệm)</html:option>
								<html:option value="live">Live(môi trường thật)</html:option>
							</html-el:select>
						</td>
					</tr>
					<tr>
						<th>

							<fmt:message>label.config.businessemail</fmt:message>
						</th>
						<td>
							<html-el:text property="businessemail" size="30" />
						</td>
					</tr>
					<tr>
						<th colspan="2">
							<p>
							</p>
						</th>
					</tr>
					<tr>
						<th colspan="2">
							<p>
								Địa chỉ chuyển tiền bưu điện
							</p>
						</th>
					</tr>
					<tr>
						<th>

							<fmt:message>label.config.tencongty</fmt:message>
						</th>
						<td>
							<html-el:text property="tencongty" size="30" />
						</td>
					</tr>
					<tr>
						<th>

							<fmt:message>label.config.diachi</fmt:message>
						</th>
						<td>
							<html-el:text property="diachi" size="30" />
						</td>
					</tr>
					<tr>
						<th>

							<fmt:message>label.config.nguoinhantien</fmt:message>
						</th>
						<td>
							<html-el:text property="nguoinhantien" size="30" />
						</td>
					</tr>
					<tr>
						<th>

							<fmt:message>label.config.emailSupport</fmt:message>
						</th>
						<td>
							<html-el:text property="emailSupport" size="30" />
						</td>
					</tr>
					<tr>
						<th colspan="2">
							<p>
							</p>
						</th>
					</tr>
					<tr>
						<th colspan="2">
							<p>
								Tỷ giá ngoại tệ
							</p>
						</th>
					</tr>
					<tr>
						<th>
							1 USD=
<!-- 					<fmt:message>label.config.usd_vnd</fmt:message> -->
						</th>
						<td>
							<html-el:text property="usd_vnd" size="10" />
							
							<fmt:message>label.currency</fmt:message>
							
						</td>
					</tr>
				</table>
				<div class="button">
				  <html:submit>
				    <fmt:message>button.update</fmt:message>
				    </html:submit>
		    </div>
			</html:form>
		</div>
	</body>
</html>
