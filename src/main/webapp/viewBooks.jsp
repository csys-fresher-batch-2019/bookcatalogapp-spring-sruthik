
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<%@page import="com.sruthi.bookcatalogapp.factory.DAOFactory"%>
<%@page import="com.sruthi.bookcatalogapp.dao.TitleDAO"%>
<html>

<title>BookCatalogue</title>


<% TitleDAO dao = DAOFactory.getTitleDAO();
List<Title> list = dao.displayTitleWithPrice();
%>

<jsp:include page="Titles.jsp"></jsp:include>
</br>
<center>
<body background="assets/images/r1.jpg" class="b">
<font size="5" >
<table border="1"style="font-size: 25">

<thead><tr><th> Title-Id </th><th> Publisher-Id </th><th> Author-Id </th><th> Subject-Id </th><th> Title </th><th> Version </th> <th> Price( in Rs)</th><th>Published Date</th></tr></thead>
<tbody >
<%

for (Title title : list) {%>
       
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