<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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

<h2 class="a">Register</h2>
<form action = "RegisterUserServlet" class="a">

<c:if test="${not empty errorMessage}">
				<font color="red" style="font-style: normal" " class="a">${errorMessage}</font>
			</c:if>
<br/>
Enter username :<input type="text" name="username" required>
<br/>
<br/>
Enter user mail-id : <input type="email" name="mailId" required>
<br/>
<br/>
Enter Password : <input type="password" name="password" pattern="{6,}"required >
<br/>
<br/>
Confirm Password : <input type = "password" name="cpassword"  pattern="{6,}"required>
<br/>
<br/>
Enter Phone-number : <input type = "text" name="phNo" required  maxlength="10" pattern="\d{10}">
<br/>
<br/>
<button type = "submit">Submit</button>
<br/>
<br/>
<a href="login.jsp"><font style="color: blue">Already registered ?</font></a>
</form>


</body>
</html>