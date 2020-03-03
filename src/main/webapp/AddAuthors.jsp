
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
<form action="AddAuthorServlet">
<%String errorMessage2 = (String)request.getAttribute("errorMessage2");
if(errorMessage2 !=null)
{%>
<font color="red" style="font-style: normal"" class="a"><%=errorMessage2%>
<%}%>
</br>
</font>
Enter Author Name : <input type="text" name="authorName" required>
<br/>
<br/>
Enter Author Mail-Id : <input type="email" name="authorMail" required>
<br/>
<br/>
Enter Phone-number : <input type = "text" name="authorPhNo" required  maxlength="10" pattern="\d{10}">
<br/>
<br/>
<button type="submit" class="b">submit</button>
</form>
</body>
</center>
</html>