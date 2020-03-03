<%@page import="com.sruthi.bookcatalogapp.domain.Title"%>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.factory.DAOFactory"%>
<%@page import="com.sruthi.bookcatalogapp.dao.TitleDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>CourseId</title>

<% TitleDAO dao1 = DAOFactory.getTitleDAO();
String courseId = request.getParameter("CourseId");
int id = Integer.valueOf(courseId);
System.out.println(id);
List<Title> list1 = dao1.displayTitleForCourseId(id);
%>
<style>
.b{
font-family: cursive;
font-size: 30;

}
.a{
font-size: 30;
}
</style>
<center>
<body background="assets/images/r1.jpg" class="b">
<font size="5" >
<table border="1">
<thead><tr><th>Publisher-Id</th><th>Author-Id</th><th>Subject-Id</th><th> Title </th> <th> Price( in Rs)</th><th>Version number</th><th>Published Date (yyyy-mm-dd)</tr></thead>
<tbody>
<%
for (Title title : list1) {%>
	<tr>
	<td><%=title.getPubId() %></td>
	<td><%= title.getAuthorId() %></td>
	<td><%= title.getSubId()%></td>
	<td><%= title.getTitle() %></td>
	<td><%= title.getPrice() %></td>
	<td><%= title.getVersionNumber() %></td>
	<td><%= title.getPubDate() %></td>
	</tr>
<%}
%>

</tbody>
</table>
</font>
</body>
</center>
</html>