<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom Login</title>
</head>

<body>

<h3>My Custom Login page</h3>

<form:form action="${ pageContext.request.contextPath }/authenticateTheUser" method="POST">

	<!-- check for login error -->
	
	<c:if test="${param.error != null}">
		<i>Sorry! You have entered wrong username / password!</i>
	</c:if>

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