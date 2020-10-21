<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% if(session.getAttribute("user") != null)
	response.sendRedirect("./userarea/dashboard.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="./css/homepage.css">
<link rel="stylesheet" type="text/css" href="./css/layoutLogin.css"> 
<link rel="stylesheet" type="text/css" href="./css/mainLogin.css"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<title>ZooParkWeb</title>
</head>
<body>
 <script>
		function alert() {
  			alert("Hello! I am an alert box!");
		}
</script>

<header>
	<h1>ZooPark MaddaPuglia</h1>
</header>


<div class="menù">
	   <a href="zooPark.html">Pagina Iniziale </a>
	   <a href="AboutUs.html">Su di noi</a>
	   <a href="parchi.jsp" >I Nostri Parchi</a>
	   <a href= "login.jsp" class="active">Area Clienti</a>
</div>

<div class="right">
	<h1>Benvenuti nella nostra Area Utente!</h1>
		<img src="immagini/4_Natura_Viva.jpg" style="width:70%;" class="pic">
		
</div>

<div class= "left">
	<h2>In questa Area avete la possibilità di accedere a tutti nostri servizi!</h2>
	<img src="immagini/logo.png" class="logo" style="width:110%;" >

</div>

<div class="main">
	<div id="presentazione">
		<div id="login"> 
		<p>Sei un utente registrato? Accedi per prenotare un Biglietto! </p>
		<form action="./login" id="loginForm" method="POST" onSubmit="return validateLogin()"> 
			  <ul>
				<li><input type="email" id="email" name="email" placeholder="email" required></li>
			
			   <li> <input type="password" id="password" name="password" placeholder="password" required> </li>
			  </ul> 
			  <br>
			  <input type="submit" id="submitter" value="LOG IN">
		</form>
		<br><p>Non sei ancora registrato?Cosa Aspetti?!</p><a href="registration.jsp" class="Registration">Clicca qui!</a>
	</div>
	<% if(session.getAttribute("userExists")!=null && session.getAttribute("userExists").equals("false")) {
	 %> 
	 <% session.invalidate();} %>			
	</div>
		<footer> @MaddaPuglia Company, sede Università degli Studi di Salerno, via Giovanni Paolo II (SA) </footer>
</div>	

</body>
</html>