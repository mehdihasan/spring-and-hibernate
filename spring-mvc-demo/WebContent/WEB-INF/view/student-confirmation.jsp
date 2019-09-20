<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<h2>Student confirmation</h2>
	
	<p>The student is confirmed: ${student.firstName} ${student.lastName}</p>
	<p>Your course code is: ${student.courseCode} </p>
	<p>You are from ${student.country}</p>
	<p>Your Favorite programming language is: ${student.favoriteLanguage} </p>
	<p>Your favorite system(s):</p>
	<ul>
		<c:forEach var="item" items="${ student.operatingSystems }">
			<li>${ item }</li>
		</c:forEach>
	</ul>

</body>

<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>

</html>