<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>reg</title>
</head>
<style>
.a{
text-align: center;
font-size: 25;
font-family: cursive;
}
body{
background-size: cover;
background-attachment: fixed;
}
</style>


<body background="assets/images/lib2.webp">
<font style="font-family: cursive">
<h2 class="a">Register</h2>
<body>
<form action = "RegisterUserServlet" class="a">
<%String errorMessage1 = (String)request.getAttribute("errorMessage1");
if(errorMessage1 !=null)
{%>
<font color="red"style="font: bold"" class="a"><%=errorMessage1%>
<%}%>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<font color="red"style="font: bold"" class="a"><%=errorMessage%>
<%}%>
</font>
</br>
Enter username :<input type="name" name="username" required>
</br>
</br>
Enter user mail-id : <input type="email" name="mailId" required>
</br>
</br>
Enter Password : <input type="password" name="password" pattern="{6,}"required >
</br>
</br>
Confirm Password : <input type = "password" name="cpassword"  pattern="{6,}"required>
</br>
</br>
Enter Phone-number : <input type = "name" name="phNo" required  maxlength="10" pattern="\d{10}">
</br>
</br>
<button type = "submit">Submit</button>
</br>
</br>
<a href="login.jsp"><font style="color: blue">Already registered ?</font></a>
</form>

</font>
</body>
</html>