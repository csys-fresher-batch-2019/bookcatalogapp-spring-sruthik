<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.a{
font-family:cursive;
font-size:30px;

}
 body{
background-size: cover;
background-attachment: fixed;
}
</style>
<body background="assets/images/r1.jpg" class="b">
<jsp:include page="Titles.jsp"></jsp:include>
<h2 class="a">Search </h2>

<form action = "SearchByServlet" method = get class="a">
<select name="filter" class="a">
  <option value="RECENT_BOOKS">Recent Books</option>
  <option value="COURSE">Course Id</option>
  <option value="YEAR">Year</option>
</select>
</br>
</br>
<button type = "Submit"class="a" >Submit</button>




</form>
</body>
</html>