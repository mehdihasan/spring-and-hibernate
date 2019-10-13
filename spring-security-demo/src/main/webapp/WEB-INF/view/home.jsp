<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page</h2>
	<hr>
	
	Welcome to the company home page!
	
	<hr>
	
	<!-- displaying user name and role -->
	
	<p>
		User: <security:authentication property="principal.username" />
		
		<br>
		<br>
		
		Roles(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	<hr>
	
	<p>
		<form:form method="POST" action="${ pageContext.request.contextPath }/logout">
			<input type="submit" value="Logout" />
		</form:form>
	</p>

</body>

</html>