<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html5>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminLogin</title>
</head>
<style>
.b{
font-family: cursive;
font-size: 25;

}
body{
background-size: cover;
background-attachment: fixed;
}

</style>
<center>
<body background="assets/images/lib2.webp" class="b">
<h3>Admin Login</h3>
<form action="AdminServlet">
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<font color="red"style="font-style: normal"" class="a"><%=errorMessage%>
<%}%>
</font>
</br>
Enter  Mail-Id : <input type="email" name="adminMail">
<br/>
</br>
Enter password : <input type="password" name="adminPassword">
<br/>
<br/>
<button type="submit" class="b">Submit</button>
</form>
</body>
</center>
</html>