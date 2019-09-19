<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>

	<h2>Student confirmation</h2>
	
	<p>The student is confirmed: ${student.firstName} ${student.lastName}</p>
	<p>You are from ${student.country}</p>
	<p>Your Favorite programming language is: ${student.favoriteLanguage} </p>
	<p>Your favorite system(s):</p>
	<ul>
		<c:forEach var="item" items="${ student.operatingSystems }">
			<li>${ item }</li>
		</c:forEach>
	</ul>

</body>

</html>