<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="zoopark.model.Utente"%>
<% Utente user = (Utente) session.getAttribute("user"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">


<link rel="stylesheet" type="text/css" href="../css/layoutLogin.css"> 
<link rel="stylesheet" type="text/css" href="../css/mainLogin.css"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<title>ZooParkWeb</title>
</head>
<body>
<header>
	<h1>ZooPark MaddaPuglia</h1>
</header>


<div class="menù">
	   <a href="../zooPark.html">Pagina Iniziale </a>
	   <a href="../AboutUs.html">Su di noi</a>
	   <a href="../parchi.jsp" >I Nostri Parchi</a>
	   <a href= "../login.jsp" class="active">Area Clienti</a>
</div>

<div class="right">
	<h1>Benvenuti nella nostra Area Utente!</h1>
		<img src="../immagini/4_Natura_Viva.jpg" style="width:70%;">
		
</div>

<div class= "left">
	<h2>In questa Area avete la possibilità di accedere a tutti nostri servizi!</h2>
	<img src="../immagini/logo.png" class="logo" style="width:110%;" >

</div>

<div class="main">
	<div id="login"> 
	<p>Complimenti <%=user.getNome()%>! Il tuo biglietto è stato prenotato con successo!</p>
	<br>Per continuare <a href="./dashboard.jsp">Clicca qui</a>
	</div>
</div>
<footer> @MaddaPuglia Company, sede Università degli Studi di Salerno, via Giovanni Paolo II (SA) </footer>
</body>
</html>