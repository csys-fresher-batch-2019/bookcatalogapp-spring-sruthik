<!DOCTYPE html5>
<html>
<title>index</title>
<style>
.a{
font-family:cursive;
font-size:40px;
color:black;
}

.button {
  background-color: rgb(255,20,147);
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
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 12px 16px;
  text-decoration: none;
  font-size: 35;
}

li a:hover {
  background-color: #111;
}
body{
background-size: cover;
background-attachment: fixed;
}
</style>


<font style="font-family: inherit" size="20"class="a">
<center>
<body background="assets/images/lib2.webp" class="a">

<ul>
  
  <li><a href="reg.jsp">Register</a>
  <li><a href="login.jsp">User Login</a></li>
  <li><a href="AdminLogin.jsp">Admin Login</a></li>
  
</ul>

</br>
<jsp:include page="slide.jsp"></jsp:include>
</body>

</center>
</html>