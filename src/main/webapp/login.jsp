\<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html5>
<html>
<title>Login</title>
<body style="background-color: rgb(255, 192, 203); font-family: cursive">

	<style>
.b {
	text-align: center;
	font-size: 25;
}

.button {
	background-color: rgb(255, 20, 147);
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

body {
	background-size: cover;
	background-attachment: fixed;
}
</style>
	<form action="LoginServlet" class="b">

		<h2 class="b">Login</h2>

		<body background="assets/images/lib2.webp">
			<c:if test="${not empty errormessage }">
				<font color="red" style="font-style: normal" " class="a">${errormessage}
			</c:if>

			</br>
			</font> Enter User Mail-id :
			<input type="email" name="usermail">
			</br>
			</br> Enter Password :
			<input type="password" name="password">
			</br>
			</br>


			<button type="submit" class="b">submit</button>


			</br>
			<a href="reg.jsp" class="b">New User ?</a>

		</body>
	</form>


</body>
</html>