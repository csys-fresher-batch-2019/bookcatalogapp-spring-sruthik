<%@page import="com.sruthi.bookcatalogapp.domain.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.sruthi.bookcatalogapp.factory.DAOFactory"%>
<%@page import="com.sruthi.bookcatalogapp.dao.SubjectDAO"%>

<!DOCTYPE html5>

<title>list By Subjects</title>

<%
SubjectDAO dao = DAOFactory.getSubjectDAO();
List<Subject> list = dao.displaySubjectwiseTitles();
%>
<jsp:include page="Titles.jsp"></jsp:include>
</br>
<center>
<table border = "1"style="font-size: 25">
<thead><th>Subject-Id</th><th>Subject-Name</th></thead>

<body>
<tbody>
<%
for(Subject sub:list){%>
<tr>
	<td> <%=sub.getSubId() %></td>
	<td> <a href= "viewSubjectBooks.jsp?sub_name=<%=sub.getSubName() %>"><%=sub.getSubName() %></a></td>
	</tr>
<%}
%>
</body>
</center>
</html>