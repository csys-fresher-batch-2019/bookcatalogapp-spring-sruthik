<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>CourseId</title>


<style>
.b{
font-family: cursive;
font-size: 30;

}
.a{
font-size: 30;
}
</style>
<center>
<body background="assets/images/r1.jpg" class="b">
<font size="5" >
<table border="1">
<thead><tr><th>Publisher-Id</th><th>Author-Id</th><th>Subject-Id</th><th> Title </th> <th> Price( in Rs)</th><th>Version number</th><th>Published Date (yyyy-mm-dd)</tr></thead>
<tbody>
<c:forEach items="${output}" var="book">

 	<tr>
	<td>${book.publisherId}</td>
	<td>${book.authorId}</td>
	<td>${book.subjectId}</td>
	<td>${book.titleName}</td>
	<td>${book.price}</td>
	<td>${book.versionNumber}</td>
	<td>${book.publishedDate}</td>

</c:forEach>

</tbody>
</table>
</font>
</body>
</center>
</html>