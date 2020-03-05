<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html5>
<html>
<head>
<title>year</title>
</head>
<style>
.b{
font-family: cursive;
font-size: 25;

}
</style>
<center>
<body background="assets/images/r1.jpg" class="b">
<h3> Search by Year</h3>
	<form action="SearchByServlet">
		<input type="hidden" name="filter" value="SEARCH_BY_YEAR" /> Enter
		Published-date : <input type="date" name="date">
		<button type="submit">submit</button>
	</form>
</body>
</center>
</html>