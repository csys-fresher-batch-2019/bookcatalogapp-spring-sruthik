
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<html>
<head>

<title>Title</title>
</head>
<% 

%>
<style>
.b{
font-family: cursive;
font-size: 30;

}
</style>
<center>
<body background="assets/images/r1.jpg" class="b">

<font size="5" >
<table border="1" style="font-size: 25">
<thead><tr><th> Title </th><th> Version </th><th> Price( in Rs)</tr></thead>
<tbody>
<c:forEach items="${output}" var="book">
<tr>
	
	<td>${book.title}</td>
	<td>${book.versionNumber}</td>
	<td>${book.price}</td>
	
</c:forEach>

</tbody>
</table>
</body>
</center>
</html>