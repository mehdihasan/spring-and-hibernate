<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page</h2>
	<hr>
	
	Welcome to the company home page!
	
	<hr>
	<hr>
	
	<p>
		<form:form method="POST" action="${ pageContext.request.contextPath }/logout">
			<input type="submit" value="Logout" />
		</form:form>
	</p>

</body>

</html>