
<!DOCTYPE html5>
<%@page import="com.sruthi.bookcatalogapp.dao.TitleDAO"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Publisher"%>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.factory.DAOFactory"%>
<%@page import="com.sruthi.bookcatalogapp.dao.PublisherDAO"%>
<html>


<%
PublisherDAO dao = DAOFactory.getPublisherDAO();
List<Publisher> list = dao.displayPubId();
%>
<body>
<center>
<jsp:include page="Titles.jsp"></jsp:include>
</br>
<table border = "1"style="font-size: 25">
<thead><th>Publisher-Id</th><th>Publisher-Name</th><th>Publisher-MailId</th><th>Publisher-PhoneNo</th></thead>
<tbody>
<%
for(Publisher pub:list){%>
<tr>
	<td> <%=pub.getPubId() %></td>
	<td> <a href= "viewpublisherbooks.jsp?pub_name=<%=pub.getPubName() %>"><%=pub.getPubName() %></a></td>
	<td> <%=pub.getPubMailId() %></td>
	<td> <%=pub.getPubPhNo() %></td>
	</tr>
<%}
%>
</tbody>
</table>
</body>
</center>
</html>