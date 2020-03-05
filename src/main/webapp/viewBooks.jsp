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
<% ArrayList<Title> a = (ArrayList)request.getAttribute("output");
%>
<font size="5" >
<table border="1"style="font-size: 25">

<thead><tr><th> Title-Id </th><th> Publisher-Id </th><th> Author-Id </th><th> Subject-Id </th><th> Title </th><th> Version </th> <th> Price( in Rs)</th><th>Published Date</th></tr></thead>
<tbody >
<%

for (Title title : a) {%>
       
	<tr>
	<td><%= title.getTitleId() %></td>
	<td><%= title.getPubId() %></td>
	<td><%= title.getAuthorId() %></td>
	<td><%= title.getSubId() %></td>
	<td> <%= title.getTitle() %></td>
	<td><%= title.getVersionNumber() %></td>
	<td><%= title.getPrice() %></td>
	<td><%= title.getPubDate() %></td>
	
	</tr>
	
<%}



%>

</tbody>
</table>


</form>


</body>
</center>
</html>