<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style type="text/css">
<!--
#x1 {
	width: 100%;
	float: left;
}
.style8 {font-family: Geneva, Arial, Helvetica, sans-serif; font-size: 12px; }
-->
</style>
	</head>

	<body>
		<span class="style8"></span>
		<div id="x1">
			<p>
				<em><strong>Chuy&#7875;n ti&#7873;n qua B&#432;u
						&#273;i&#7879;n (POS) </strong>
				</em>
			</p>
			<p>
				&nbsp;
			</p>
			<div align="justify">
				Qu&yacute; kh&aacute;ch &#273;&atilde; ch&#7885;n h&igrave;nh
				th&#7913;c thanh to&aacute;n b&#7857;ng c&aacute;ch chuy&#7875;n
				ti&#7873;n qua B&#432;u &#273;i&#7879;n (G&#7885;i t&#7855;t
				l&agrave; POS), vui l&ograve;ng th&#7921;c hi&#7879;n c&aacute;c
				b&#432;&#7899;c sau:
				<br />
				<ul>
					<li>
						Chuy&#7875;n ti&#7873;n b&#432;u &#273;i&#7879;n qua
						&#273;&#7883;a ch&#7881; v&agrave; th&ocirc;ng tin sau:
						<br />
						<br />
						<table cellspacing="0" cellpadding="0" width="80%" border="0">
							<tbody>
								<tr>
									<td width="150" bgcolor="#99CCCC" height="20">
										<span class="style8">&nbsp;&nbsp;T&ecirc;n c&ocirc;ng
											ty</span>
									</td>
									<td width="450" bgcolor="#e6f8d1" height="20">
										<span class="style8"><strong>&nbsp;&nbsp;<c:out
													value="${companynamepos}" />
										</strong>
										</span>
									</td>
								</tr>
								<tr>
									<td width="150" bgcolor="#99CCCC" height="20">
										<span class="style8">&nbsp;&nbsp;&#272;&#7883;a
											ch&#7881;</span>
									</td>
									<td width="450" bgcolor="#e6f8d1" height="20">
										<span class="style8"><strong></strong>&nbsp;&nbsp;<c:out
												value="${diachipos}" />
										</span>
									</td>
								</tr>
								<tr>
									<td width="150" bgcolor="#99CCCC" height="20">
										<span class="style8"> &nbsp;&nbsp;Ng&#432;&#7901;i
											nh&#7853;n ti&#7873;n</span>
									</td>
									<td width="450" bgcolor="#e6f8d1" height="20">
										<span class="style8">&nbsp;&nbsp;<c:out
												value="${nguoinhantienpos}" />
										</span>
									</td>
								</tr>
							</tbody>
						</table>
						<br />
					</li>
					<li>
						G&#7917;i th&ocirc;ng tin y&ecirc;u c&#7847;u d&#432;&#7899;i
						&#273;&acirc;y qua &#273;&#7883;a ch&#7881; email
						<a href="mailto:<c:out value="${emailpos}"/>"><c:out
								value="${emailpos}" /> </a> &#273;&#7875; ch&uacute;ng t&ocirc;i
						chu&#7849;n b&#7883; h&agrave;ng h&oacute;a v&agrave; ch&#259;m
						s&oacute;c &#273;&#417;n h&agrave;ng.
						<br />
						<br />
						<table cellspacing="0" cellpadding="0" width="80%" border="0">
							<tbody>
								<tr>
									<td width="600" bgcolor="#99CCCC">
										<p>
											<strong><br /> &nbsp;&nbsp;<span class="style8">Th&ocirc;ng
													tin v&#7873; kh&aacute;ch h&agrave;ng:</span>
											</strong><span class="style8"><br />
												&nbsp;&nbsp;&nbsp;H&#7885; t&ecirc;n v&agrave;
												&#273;&#7883;a ch&#7881; kh&aacute;ch h&agrave;ng: <br />
												&nbsp;&nbsp;&nbsp;Ng&agrave;y g&#7903;i ti&#7873;n qua POS:<br />
												<br /> <strong>&nbsp;&nbsp;Th&ocirc;ng tin
													v&#7873; H&oacute;a &#273;&#417;n Mua h&agrave;ng:</strong>
											<br /> &nbsp;&nbsp;&nbsp;Ng&#432;&#7901;i mua h&agrave;ng:<br />
												&nbsp;&nbsp;&nbsp;Ng&#432;&#7901;i nh&#7853;n h&agrave;ng:<br />
												&nbsp;&nbsp;&nbsp;&#272;i&#7879;n tho&#7841;i li&ecirc;n
												l&#7841;c: (Ch&uacute;ng t&ocirc;i c&#7847;n g&#7885;i
												&#273;i&#7879;n th&#7885;&nbsp;&nbsp;ai &#273;&#7875;
												x&aacute;c minh) <br /> &nbsp;&nbsp;&nbsp;&#272;&#7883;a
												ch&#7881; giao h&agrave;ng: (Xin vui l&ograve;ng nh&#7853;p
												l&#7841;i &#273;&#7875; g&#7903;i h&agrave;ng ch&iacute;nh
												x&aacute;c)<br /> &nbsp;&nbsp;&nbsp;S&#7889; h&oacute;a
												&#273;&#417;n POS:</span>
										</p>
										<p class="style8">
											&nbsp;&nbsp;&nbsp;
											<em><U>Ghi ch&uacute; :</U>
											</em> Vui l&ograve;ng g&#7903;i &#273;&#7847;y &#273;&#7911;
											th&ocirc;ng tin &#273;&#7871;n
											<a href="mailto:<c:out value="${emailpos}"/> "><c:out
													value="${emailpos}" /> </a>
										</p>
										<p>
											&nbsp;
										</p>
									</td>
								</tr>
							</tbody>
						</table>
						<br />
					</li>
					<li>
						Ch&uacute;ng t&ocirc;i x&#7869; g&#7917;i h&agrave;ng ngay khi
						qu&yacute; kh&aacute;ch chuy&#7875;n ti&#7873;n. R&#7845;t vui
						v&igrave; &#273;&#432;&#7907;c ph&#7909;c v&#7909; qu&yacute;
						kh&aacute;ch.
					</li>
				</ul>
				<br />
			</div>
			<strong>Th&ocirc;ng tin b&#7841;n c&#7847;n bi&#7871;t khi
				chuy&#7875;n ti&#7873;n qua b&#432;u &#273;i&#7879;n (POS)</strong>
			<ul>
				<li>
					<strong>a. Chuy&#7875;n ti&#7873;n B&#432;u ch&iacute;nh
						(Chuy&#7875;n th&#432;&#7901;ng)</strong>
					<br />
					L&agrave; di&#803;ch vu&#803; nh&acirc;&#803;n, g&#432;&#777;i,
					chuy&ecirc;&#777;n va&#768; tra&#777; ti&ecirc;&#768;n
					Vi&ecirc;&#803;t Nam &#273;&ecirc;&#769;n ng&#432;&#417;&#768;i
					nh&acirc;&#803;n trong n&#432;&#417;&#769;c th&ocirc;ng qua
					ma&#803;ng l&#432;&#417;&#769;i B&#432;u chi&#769;nh &ndash;
					Vi&ecirc;&#771;n th&ocirc;ng c&ocirc;ng c&ocirc;&#803;ng.
					<br />
					<br />
					Th&#7901;i gian d&#7921; ki&#7871;n:
					<br />
					- Ha&#768; N&ocirc;&#803;i &ndash;Tp. H&ocirc;&#768; Chi&#769; Minh
					: T&#7915; 3-5 ng&agrave;y
					<br />
					- Ca&#769;c trung t&acirc;m ti&#777;nh, TP kha&#769;c : T&#7915;
					5-7 ng&agrave;y
					<br />
					- Ca&#769;c huy&#7879;n , x&atilde; v&ugrave;ng s&acirc;u
					v&ugrave;ng xa : T&#7915; 7-9 ng&agrave;y
				</li>
				<li>
					<strong>b. Chuy&#7875;n ti&#7873;n nhanh:</strong>
					<br />
					L&agrave; di&#803;ch vu&#803; trong h&ecirc;&#803;
					th&ocirc;&#769;ng nghi&ecirc;&#803;p vu&#803; chuy&ecirc;&#777;n
					ti&ecirc;&#768;n cu&#777;a nga&#768;nh b&#432;u
					&#273;i&ecirc;&#803;n, &#273;&#432;&#417;&#803;c t&ocirc;&#777;
					ch&#432;&#769;c nh&acirc;&#803;n, g&#432;&#777;i,
					chuy&ecirc;&#777;n va&#768; pha&#769;t &#273;&ecirc;&#769;n
					ng&#432;&#417;&#768;i nh&acirc;&#803;n b&#259;&#768;ng
					ph&#432;&#417;ng ti&ecirc;&#803;n nhanh nh&acirc;&#769;t,
					&#273;a&#777;m ba&#777;o chi&#777; ti&ecirc;u th&#417;&#768;i gian
					&#273;a&#771; c&ocirc;ng b&ocirc;&#769;:
					<br />
					<br />
					Th&#7901;i gian d&#7921; ki&#7871;n:
					<br />
					- Ha&#768; N&ocirc;&#803;iTP-.H&ocirc;&#768; Chi&#769; Minh :
					Kh&ocirc;ng qua&#769; 12 gi&#417;&#768;
					<br />
					- Ca&#769;c trung t&acirc;m ti&#777;nh, TP kha&#769;c: Kh&ocirc;ng
					qua&#769; 48 gi&#417;&#768;
					<br />
				</li>
			</ul>
			<div class="luudonhang">
				<form action="<c:url value="/pages/completeOrder.do"/>"
					method="post">
					<div align="center">
						<input name="mtpay" type="hidden" value="pos" />
						<input name="" type="image" src="../images/checkout1.gif" />
						<!--<input name="sendOrder" type="submit" disabled="disabled" value="Gửi đơn hàng" />-->
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
