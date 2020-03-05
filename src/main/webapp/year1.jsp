<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Yearwise</title>
</head>
<style>
.b{
font-family: cursive;
font-size: 25;

}
</style>
<center>
<body background="assets/images/r1.jpg" class="b">
<%
 ArrayList<Title> a = (ArrayList)request.getAttribute("output");%>


<font size="5" >

<table border="1">

<thead><tr><th>Publisher-Id</th><th>Author-Id</th><th>Subject-Id</th><th> Title </th> <th> Price( in Rs)</th><th>Version number</th></thead>
<tbody>
<%
for (Title title : a) {%>
	<tr>
	<td><%=title.getPubId() %></td>
	<td><%= title.getAuthorId() %></td>
	<td><%= title.getSubId()%></td>
	<td><%= title.getTitle() %></td>
	<td><%= title.getPrice() %></td>
	<td><%= title.getVersionNumber() %></td>
	
	</tr>
<%}
%>

</tbody>
</table>

</body>
</center>
</html>