<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html5>
<html>
<head>
<title>Add Publishers</title>
</head>

<style>
.b{
font-family: cursive;
font-size: 25;

}
</style>
<center>
<body background="assets/images/r1.jpg" class="b">
<form action="AddPublisherServlet">
<c:if test="${not empty errorMessage2}">
<font color="red" style="font-style: normal"" class="a">${errorMessage2}
		</c:if>

</br>
</font>

Enter publisher Name : <input type="text" name="pubName" required>
<br/>
<br/>
Enter publisher Mail-Id : <input type="email" name="pubMail" required>
<br/>
<br/>
Enter Phone-number : <input type = "name" name="pubPhNo" required  maxlength="10" pattern="\d{10}">
<br/>
<br/>
<button type="submit" class="b">submit</button>
</form>
</body>
</center>
</html>