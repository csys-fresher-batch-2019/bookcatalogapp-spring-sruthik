<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html5>
<html>
<head>
<title>Add Titles</title>
</head>

<style>
.b{
font-family: cursive;
font-size: 25;

}
</style>

<body background="assets/images/r1.jpg" class="b">
<form action="AddTitleServlet">

</br>
</font>
Enter Author Id: <input type="number" name="authorId" required>
<br/>
<br/>
Enter Publisher Id : <input type="number" name="pubId" required>
<br/>
<br/>
Enter Subject Id : <input type="number" name="subId" required>
<br/>
<br/>
Enter Published date :<input type="date" name="pubDate" required>
<br/>
<br/>
Enter Title name : <input type="text" name="title" required>
<br/>
<br/>
Enter Version : <input type="number" name="version" required>
<br/>
<br/>
Enter Price (in Rs): <input type="number" name="price" required>
<br/>

<c:if test="${not empty errorMessage2}">
<font color="red" style="font-style: normal"" class="a">${errorMessage2}
		</c:if>
</br>
<button type="submit" class="b">submit</button>

</form>

</body>

</html>