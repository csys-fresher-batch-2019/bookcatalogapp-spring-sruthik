
<!DOCTYPE html5>
<%@page import="com.sruthi.bookcatalogapp.domain.Author"%>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.factory.DAOFactory"%>
<%@page import="com.sruthi.bookcatalogapp.dao.AuthorDAO"%>
<html>

<title>list By Authors</title>
<%
AuthorDAO dao = DAOFactory.getAuthorDAO();
List<Author> list = dao.displayNumberOfAuthors();
%>
<jsp:include page="Titles.jsp"></jsp:include>
</br>
<center>
<table border = "1" style="font-size: 25">
<thead><th>Author-id</th><th>Author-Name</th><th>Author-MailId</th><th>Author-PhoneNo</th></thead>
<center>
<body >

<tbody>
<%
for(Author author:list){%>
<tr>
	<td> <%=author.getAuthorId() %></td>
	<td> <a href= "viewAuthorbooks.jsp?author_name=<%=author.getAuthorName() %>"><%=author.getAuthorName() %></a></td>
	<td> <%=author.getAuthorMailId()%></td>
	<td> <%=author.getAuthorPhNo()%></td>
	</tr>
<%}
%>
</body>

</tbody>
</table>
</center>
</html>