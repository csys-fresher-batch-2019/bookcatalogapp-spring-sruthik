<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html5>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sruthi.bookcatalogapp.domain.Publisher"%>
<%@page import="java.util.List"%>
<html>
<center>
<table border = "1"style="font-size: 25">

<body><h1></h1>
<c:forEach items="${output}" var="book">
<tr>

	<td>${book.pubId}</td>
	<td><a href= "Publisher?pub_name=${book.pubName}">${book.pubName}</a></td>
	<td>${book.pubMailId}</td>
	<td>${book.pubPhNo}</td>

</c:forEach>

<center>
<jsp:include page="Titles.jsp"></jsp:include>
</br>

<thead><th>Publisher-Id</th><th>Publisher-Name</th><th>Publisher-MailId</th><th>Publisher-PhoneNo</th></thead>
<tbody>

<tbody>


</body>

</tbody>
</table>
</center>
</html>