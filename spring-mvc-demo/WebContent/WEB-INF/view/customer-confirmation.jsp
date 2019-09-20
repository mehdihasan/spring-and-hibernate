<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	
	<title>Customer Confirmation</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<h3><i>Great!.</i></h3>

	<div class="container-fluid">
	
		<P>The customer is confirmed: ${customer.firstName} ${customer.lastName}</P>
		
		<p>You have used total of your ${ customer.freePasses } free passes</p>
		
		<p>Your postal code is: ${ customer.postalCode }</p>
		
		<p>Your course code is: ${student.courseCode} </p>
	
	</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</html>