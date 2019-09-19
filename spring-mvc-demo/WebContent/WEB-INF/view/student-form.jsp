<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<body>

	<h2>Student form</h2>
	
	<form:form action="process-form" modelAttribute="student">
	
	First name: <form:input path="firstName" />
	
	<br><br>
	
	First name: <form:input path="lastName" />
	
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
	
	<input type="submit" value="Submit" />
	
	</form:form>

</body>

</html>