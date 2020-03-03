
<!DOCTYPE html5>
<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.factory.DAOFactory"%>
<%@page import="com.sruthi.bookcatalogapp.dao.TitleDAO"%>
<html>


<title>Recent Books</title>
<% TitleDAO dao = DAOFactory.getTitleDAO();
List<Title> list = dao.displayByRecentBooks();
%>
<style>
.b{
font-family: cursive;
font-size: 30;

}
</style>
<center>
<body background="assets/images/r1.jpg" class="b"><h3>Recent Books : </h3>
<table border="1"style="font-size: 25">
<thead><tr><th>Publisher-Id</th><th>Author-Id</th><th>Subject-Id</th><th> Title </th> <th>Version number</th><th> Price( in Rs)</th><th>Published Date</tr></thead>
<tbody>
<%
for (Title title : list) {%>
	<tr>
	<td><%= title.getPubId() %></td>
	<td><%= title.getAuthorId() %></td>
	<td><%= title.getSubId()%></td>
	<td><%= title.getTitle() %></td>
	<td><%= title.getVersionNumber() %></td>
	<td><%= title.getPrice() %></td>
	<td><%= title.getPubDate() %></td>
	</tr>
<%}
%>

</tbody>
</table>


</body>
</center>
</html>