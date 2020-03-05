<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html5> 
<html>
<title>Title</title>

<style>
.b{
font-family: cursive;
font-size: 30;

}
</style>
<center>
<body background="assets/images/r1.jpg" class="b">
<% ArrayList<Title> a = (ArrayList)request.getAttribute("output");
%>
<font size="5" >
<table border="1"style="font-size: 25">
<thead><tr><th> Title </th><th> Version </th><th> Price( in Rs)</tr></thead>
<tbody>
<%
for (Title title : a) {%>
	<tr>
	
	<td><%= title.getTitle() %></td>
	<td><%= title.getVersionNumber() %></td>
	<td><%= title.getPrice() %></td>
	
	</tr>
<%}
%>

</tbody>
</table>

</body>
</center>
</html>