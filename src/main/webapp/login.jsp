<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title><fmt:message key="label.login" />
		</title>
	
<style type="text/css">
#login td {
	text-align: left;
	padding-left: 5px;
	padding-top: 2px;
	padding-bottom: 2px;
}
#login th {
	text-align: right;
	padding-right: 5px;
	font-weight: bold;
}
.line {
	display: block;
}

#login #buttonbar {
	text-align: center;
}
#heading {
	font-size: 150%;
	font-weight: bold;
	color: #996633;
	padding:0;
}
</style>


<script type="text/javascript"
			src="<c:url value="/scripts/login.js"/>">
			
		</script>
	</head>
	<body onLoad="initValidation();">
    <div align="left" style="margin-left:200px;">	
	 <div id="heading" class="line">
        <!--     <fmt:message key="label.login" /> -->
            </div>
	  	
      <div class="line">
        <form name="loginForm" action="<c:url value='/login_check'/>"
			onSubmit="return validateStandard(this);" method="POST">
         
        <table cellspacing="0" cellpadding="0" id="login">
          <tr>
            <td colspan="2">
              
              <c:if test="${param.login_error != null}">
                <li class="error">
                  <img src="<c:url value="/images/iconWarning.gif"/>"
                  alt="<fmt:message key="icon.warning"/>">
                  <fmt:message key="errors.password.mismatch" />
                  </li>
			    </c:if>              </td>
	        </tr>
          <tr>
            <th >
              <label for="j_username" class="desc">
                <fmt:message key="label.username" />
              </label>              </th>
		      <td >
			      <input type='text' name='j_username' class="text medium"
							id="j_username"
							<c:if test="${not empty param.login_error}">value='<c:out value="${ACEGI_SECURITY_LAST_USERNAME}"/>'</c:if>>		      </td>
	        </tr>
          <tr>
            <th >
              <label for="j_password" class="desc">
                <fmt:message key="label.password" />
              </label>              </th>
		      <td >
			      <input type='password' name='j_password' class="text medium"
							id="j_password"/>		      </td>
	        </tr>
          <tr>
            <th>&nbsp;              </th>
		      <td>&nbsp;
			      <input type="checkbox" name="rememberMe">
			      &nbsp;
			      <label>
			        <fmt:message key="label.rememberMe" />
		          </label>		      </td>
	        </tr>
          <tr>
            <td colspan="2"  id="buttonbar">
              <input name="submit" type="submit"
							value="Đăng nhập">
              &nbsp;
            <a href="<c:url value='/pages/losspass.jsp'/>"><fmt:message
								key="label.retrive.lostpassword" /> </a>              </td>
          </tr>
          </table>
		    </form>
      </div>
    </div>
	</body>
</html>
