<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
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
  			form.action="user.do?method=addnew";
  			form.submit();
  		}
  		-->
  		</script>
	</head>
	<body>

		<div>
			<div>
				<form action="user.do?method=search" method="post" name="plform1">
					<fmt:message key="label.search" />
					<input type="text" name="keyword">
					<input type="submit" value="<fmt:message key="button.search"/>">
					<input type="submit"
						value="<fmt:message
									key="label.display.addnew" />"
						onclick="return addnew();">
				</form>

			</div>
			<display:table name="users" sort="external" id="row"
				requestURI="/admin/user.do" partialList="true"
				pagesize="${pageSize}" size="resultSize">
				<display:column property="username" href="user.do?method=edit"
					paramId="id" paramProperty="username" titleKey="label.username" />
				<display:column property="firstName" titleKey="label.firstname">
				</display:column>
				<display:column property="lastName" titleKey="label.lastname">
				</display:column>
				<display:column property="email">
				</display:column>

				<display:column>
				<a href="user.do?method=privileges&id=<c:out value="${row.username}"/>">Privileges</a>|
					<a href="user.do?method=edit&id=<c:out value="${row.username}"/>"><fmt:message
							key="label.display.edit" /> </a>|
					<a onClick="return checkDel();"
						href="user.do?method=del&id=<c:out value="${row.username}"/>"><fmt:message
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
					Không có thành viên nào
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
					thành viên
				</display:setProperty>
			</display:table>

		</div>

	</body>
</html>
