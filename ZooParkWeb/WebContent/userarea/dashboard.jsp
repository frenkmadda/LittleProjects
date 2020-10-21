<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="zoopark.model.*"%>
    <%@ page import="java.util.*"%>
<% Utente user = (Utente) session.getAttribute("user"); 
   UtenteModelDM model=new UtenteModelDM();
   ArrayList<Utente> utenti= new ArrayList<Utente>();
   utenti.addAll(model.doRetrieveAll(null));
   int i=0,numUtenti=utenti.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">


<link rel="stylesheet" type="text/css" href="../css/layoutLogin.css"> 
<link rel="stylesheet" type="text/css" href="../css/layoutAboutUs.css"> 
<link rel="stylesheet" type="text/css" href="../css/mainLogin.css"> 
<link rel="stylesheet" type="text/css" href="../css/dashboard.css"> 
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
		<img src="../immagini/4_Natura_Viva.jpg" style="width:70%;" class="pic">
		
</div>

<div class= "left">
	<h2>In questa Area avete la possibilità di accedere a tutti nostri servizi!</h2>
	<img src="../immagini/logo.png" class="logo" style="width:110%;" >

</div>

<div class="main">
	<div id="login"> 
		<p>Benvenuto, <%=user.getNome() %>! </p>
		<% if(user.getHaveTicket()){ %>
			<br><p> Biglietto già prenotato! </p><br>
			<%} %>
		<% if(user.getIDRuolo().equals("admin")){ %>
			<br><p> Area Admin,Biglietto privilegiato già in saccoccia! </p><br>
			<%} %>	
		<% if(!user.getHaveTicket() && !user.getIDRuolo().equals("admin")){ %>
		<p>Acquista il tuo Biglietto!</p><br>
			<form action="./dashboard" id="loginForm" method="POST" > 
			  <ul>
				<li><p>NOME INTESTATARIO ACCOUNT</p><input type="text" id="email" name="nome" placeholder=<%=user.getNome() %> required></li>
			
			   <li><p>COGNOME INTESTATARIO ACCOUNT</p><input type="text" id="password" name="cognome" placeholder=<%=user.getCognome() %> required> </li>
			   <li> <p>NUMERO CARTA</p><input type="password" id="credito" name="NumeroCarta" placeholder="**** **** **** ****" required> </li>
			  </ul> <br>
			  <br>
			  <input type="submit" id="submitter" value="ACQUISTA">
		</form>
			<%} %>
		<form action="../logout" method="POST"><input type="submit" value="Log Out" id="buttonLogout"></form> 
</div>
<div class="mainPageP3">
		Nome: <%=user.getNome() %> <br>
		Cognome: <%=user.getCognome() %> <br>
		E-mail: <%=user.getEmail() %>
		<%if(user.getIDRuolo().equals("admin")){ %>
			<br><br>BENVENUTO SIG.ADMIN <%=user.getCognome()%><br><br>
			Capitale:1,50 EUR<br>
			Utenti Registrati: 
			<br><ul>
			<%while(i<numUtenti){ %>
			<li><br><%=utenti.get(i).getNome()%> <%=utenti.get(i).getCognome()%> <br> Ruolo: <%=utenti.get(i).getIDRuolo()%> - Email: <%=utenti.get(i).getEmail()%></li>
			<%i++;} %>
			
		</ul>
			<%} %>
</div>
</div>
	<footer> @MaddaPuglia Company, sede Università degli Studi di Salerno, via Giovanni Paolo II (SA) </footer>
</body>
</html>