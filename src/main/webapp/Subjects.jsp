<%@page import="java.util.ArrayList"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Subject"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html5>

<title>list By Subjects</title>


<jsp:include page="Titles.jsp"></jsp:include>
</br>
<center>
<table border = "1"style="font-size: 25">
<thead><th>Subject-Id</th><th>Subject-Name</th></thead>

<body>
<% ArrayList<Subject> a = (ArrayList)request.getAttribute("output");
%>
<tbody>
<%
for(Subject sub:a){%>
<tr>
	<td> <%=sub.getSubId() %></td>
	<td> <a href= "Subject?sub_name=<%=sub.getSubName() %>"><%=sub.getSubName() %></a></td>
	</tr>
<%}
%>
</body>
</center>
</html>