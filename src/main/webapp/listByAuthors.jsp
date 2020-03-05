<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html5>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Author"%>
<%@page import="java.util.List"%>

<html>

<title>list By Authors</title>

<jsp:include page="Titles.jsp"></jsp:include>
</br>
<center>
<table border = "1" style="font-size: 25">
<thead><th>Author-id</th><th>Author-Name</th><th>Author-MailId</th><th>Author-PhoneNo</th></thead>
<center>

<body>
<c:forEach items="${output}" var="book">
<tr>
	<td>${book.authorId}</td>
	<td>${book.authorName}</td>
	<td>${book.authorMailId}</td>
	<td>${book.authorPhNo}</td>

</c:forEach>

<tbody>


</body>

</tbody>
</table>
</center>
</html>