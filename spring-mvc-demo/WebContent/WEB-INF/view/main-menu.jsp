<!DOCTYPE html>
<html>

<head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

	<div class="container-fluid">
	<h2>Spring MVC Demo - Home Page</h2>
	
	<a href="show-form">Hello World form!</a>
	<br>
	<a href="silly/show-form">Silly World form!</a>
	<br>
	<a href="student/show-form">Student form!</a>
	<br>
	<a href="customer/show-form">Customer form!</a>
	
	<br><br>
	
	<img src="${pageContext.request.contextPath}/resources/images/mvc.png">

	</div>
</body>

<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>

</html>