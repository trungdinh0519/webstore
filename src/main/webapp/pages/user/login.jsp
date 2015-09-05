<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>

</head>
<body>
	<div id="loginform">
		<h2>Login</h2>
		<html:form action="/login.do">
			<p>
				<label>User Name:</label>
				<html:text property="username"></html:text>
			</p>
			<p>
				<label>Password:</label>
				<html:password property="password"></html:password>
			</p>
			<p>
				<html:submit>Submit</html:submit>
			</p>
		</html:form>		
	</div>
</body>
</html>