<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<h2>Student form</h2>
	
	<form:form action="process-form" modelAttribute="student">
	
	First name: <form:input path="firstName" />
	
	<br><br>
	
	First name: <form:input path="lastName" />
	
	<br><br>
	
	Course Code: <form:input path="courseCode" />
	<form:errors path="courseCode" cssClass="alert alert-danger alert-dismissible fade show" />
	
	<br><br>
	
	Country:
	
	<form:select path="country">
	
		<%-- <form:options items="${student.countryOptions}" /> --%> 
		
		<form:options items="${theCountryOptions}" />
	
	</form:select>
	
	<br><br>
	
	Favorite Language:
	
	<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  /> 
	
	<br><br>
	
	Operating Systems:
	
	<br><form:checkbox path="operatingSystems" value="Linux" /> Linux 
	<br><form:checkbox path="operatingSystems" value="indows" /> Windows 
	<br><form:checkbox path="operatingSystems" value="MacOS" /> MacOS 
	
	<br><br>
	
	<input type="submit" value="Submit" />
	
	</form:form>

</body>

<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>

</html>