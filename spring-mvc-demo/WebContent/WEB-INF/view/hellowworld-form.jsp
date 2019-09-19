<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<h2>Spring MVC Demo - Input Form</h2>

	<!-- <form action="view-form-end-result" method="get"> -->
	<form action="process-form" method="get">
	
		<input type="text" name="studentName" placeholder="What's your name?" />
		
		<br />
		
		<input type="text" name="studentAge" placeholder="What's your age?" />
		
		<br />
		
		<input type="submit" />
	
	</form>

</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</html>