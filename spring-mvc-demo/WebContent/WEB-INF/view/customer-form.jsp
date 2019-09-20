<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	
	<title>Customer Registration Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<h3><i>Fill out the form. Asterisk (*) means required.</i></h3>

	<div class="container-fluid">
	
		<form:form action="process-form" modelAttribute="customer">
		
			First Name: <form:input path="firstName" />
			
			<br><br>
			
			Last Name (*): <form:input path="lastName" />
			<form:errors path="lastName" cssClass="alert alert-danger alert-dismissible fade show" />
			
			<br><br>
			
			Free Passes: <form:input path="freePasses" />
			<form:errors path="freePasses" cssClass="alert alert-danger alert-dismissible fade show" />
			
			<br><br>
						
			Postal Code: <form:input path="postalCode" />
			<form:errors path="postalCode" cssClass="alert alert-danger alert-dismissible fade show" />
			
			<br><br>
	
			Course Code: <form:input path="courseCode" />
			<form:errors path="courseCode" cssClass="alert alert-danger alert-dismissible fade show" />
			
			<br><br>
			
			<input type="submit" value="Submit" />
		
		</form:form>
	
	</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</html>