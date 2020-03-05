<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>


<font style="font-family: inherit" size="30"class="a">
<center>
<body style="background-color:  rgb(255,192,203)">

<ul>
  <li><a class="active" href="index.jsp">Home</a></li>
  <li><a href="login.jsp">User Login</a></li>
  <li><a href="AdminLogin.jsp">Admin Login</a></li>
  
</ul>

</br>

</body>

</center>
</html>