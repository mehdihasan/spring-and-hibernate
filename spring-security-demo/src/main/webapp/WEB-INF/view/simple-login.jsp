<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom Login</title>
</head>

<body>

<h3>My Custom Login page</h3>

<form:form action="${ pageContext.request.contextPath }/authenticateTheUser" method="POST">

	<p>
		User name: <input type="text" name="username" />
	</p>
	
	<p>
		User password: <input type="password" name="password" />
	</p>
	
	<input type="submit" value="Login" />

</form:form>

</body>
</html>