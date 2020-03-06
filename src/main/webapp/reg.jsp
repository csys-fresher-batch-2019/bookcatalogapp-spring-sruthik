<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
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
<form action = "RegisterUserServlet" class="a">
<body>

<c:if test="${not empty errormessage1}">
<font color="red"style="font-style: normal"" class="a">${errormessage1}
</c:if>
</font>
<c:if test="${not empty errormessage }">
<font color="red"style="font-style: normal"" class="a">${errormessage}
</c:if>
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