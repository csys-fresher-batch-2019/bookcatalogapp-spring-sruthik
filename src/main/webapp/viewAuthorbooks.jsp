<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<%@page import="com.sruthi.bookcatalogapp.factory.DAOFactory"%>
<%@page import="com.sruthi.bookcatalogapp.dao.TitleDAO"%>
<!DOCTYPE html5> 
<html>
<title>Title</title>
<% TitleDAO dao = DAOFactory.getTitleDAO();
String authorName=request.getParameter("author_name");
List<Title> list = dao.displayTitleForAuthorName(authorName);
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
<thead><tr><th> Title </th><th> Version </th><th> Price( in Rs)</tr></thead>
<tbody>
<%
for (Title title : list) {%>
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