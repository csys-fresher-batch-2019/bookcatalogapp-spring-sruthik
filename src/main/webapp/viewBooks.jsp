<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<html>

<title>BookCatalogue</title>




<jsp:include page="Titles.jsp"></jsp:include>
</br>
<center>
<body background="assets/images/r1.jpg" class="b">



<font size="5" >
<table border="1"style="font-size: 25">
<thead><tr><th> Title-Id </th><th> Publisher-Id </th><th> Author-Id </th><th> Subject-Id </th><th> Title </th><th> Version </th> <th> Price( in Rs)</th><th>Published Date</th></tr></thead>
<tbody>
<c:forEach items="${output}" var="book">
<tr>
	<td>${book.titleId}</td>
	<td>${book.pubId}</td>
	<td>${book.authorId}</td>
	<td>${book.subId}</td>
	<td>${book.title}</td>
	<td>${book.versionNumber}</td>
	<td>${book.price}</td>
	<td>${book.pubDate}</td>
</c:forEach>

</tbody>
</table>


</form>


</body>
</center>
</html>