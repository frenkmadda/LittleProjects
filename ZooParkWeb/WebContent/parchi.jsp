<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="zoopark.model.*"%> 
<%@ page import="java.util.*"%> 
<% 
    ParkModelDM park=new ParkModelDM();
    ArrayList<Park> parks = new ArrayList<Park>();
    parks.addAll(park.doRetrieveAll(null));
    int i=0,numParchi=parks.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
	
	<link href="css/homepage.css" rel="stylesheet">
	<link href="css/layoutParchi.css" rel="stylesheet">
<title>ZooParkWeb</title>
</head>
<body>
<header>
	<h1> ZooPark MaddaPuglia</h1>	
</header>
<div class="menù">
	   <a href="zooPark.html">Pagina Iniziale </a>
	   <a href="AboutUs.html">Su di noi</a>
	   <a href="parchi.jsp" class="active" id="first">I Nostri Parchi</a>
	   <a href= "login.jsp">Area Clienti</a>
</div>

<div class="welcome">
	<h1>Benvenuti nell'area dedicata ai Parchi!</h1>
	<div class="video">
		<img src="immagini/immagine3.jpg" style="width:70%;">
	</div>
</div>
	
	<div class= "left">
		<h2>Vieni a Trovarci!</h2>
		<img src="immagini/logo.png" class="logo" style="width:110%;" >
	</div>
	
	<div class="main">
	<div id="presentazione">
		<img src="immagini/map.jpg" style="scale:100%;">
	<div class="mainPageP2">
		I nostri Parchi:
		<br><ul>
			<%while(i<numParchi){ %>
			<li><%=parks.get(i).getName()%> - Luogo: <%=parks.get(i).getLocation()%> <br> Orari: <%=parks.get(i).getOpening()%> - <%=parks.get(i).getClosure()%></li>
			<%i++;} %>
		</ul>
		<br>Allora sei pronto? Acquista un biglietto <a href="./login.jsp"> qui </a>
	</div>
	</div>
	
</div>
<footer> @MaddaPuglia Company, sede Università degli Studi di Salerno, via Giovanni Paolo II </footer>

</body>

</html>