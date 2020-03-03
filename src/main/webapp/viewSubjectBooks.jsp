<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<%@page import="com.sruthi.bookcatalogapp.factory.DAOFactory"%>
<%@page import="com.sruthi.bookcatalogapp.dao.TitleDAO"%>
<!DOCTYPE html5>
<html>
<head>
<title>By subjects</title>
</head>
<% TitleDAO dao = DAOFactory.getTitleDAO();
String subName=request.getParameter("sub_name");
List<Title> list = dao.displayTitleForSubName(subName);
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
<table border="1"style="font-size: 25">
<thead><tr><th>Publisher-id</th><th>Author-id</th><th> Title </th><th> Version </th><th> Price( in Rs)</tr></thead>
<tbody>
<%
for (Title title : list) {%>
	<tr>
	<td><%= title.getPubId() %>
	<td><%= title.getAuthorId() %>
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