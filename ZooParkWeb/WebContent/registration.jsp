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


<link rel="stylesheet" type="text/css" href="./css/layoutLogin.css"> 
<link rel="stylesheet" type="text/css" href="./css/mainLogin.css"> 
<link rel="stylesheet" type="text/css" href="./css/registration.css"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<title>ZooParkWeb</title>
</head>
<body>

<header>
	<h1>ZooPark MaddaPuglia</h1>
</header>


<div class="menù">
	   <a href="zooPark.html">Pagina Iniziale </a>
	   <a href="AboutUs.html">Su di noi</a>
	   <a href="parchi.html" >I Nostri Parchi</a>
	   <a href= "login.jsp" class="active">Area Clienti</a>
</div>

<div class="right">
	<h1>Benvenuti nella nostra Area Utente!</h1>
		<img src="immagini/4_Natura_Viva.jpg" style="width:70%;">
		
</div>

<div class= "left">
	<h2>In questa Area avete la possibilità di accedere a tutti nostri servizi!</h2>
	<img src="immagini/logo.png" class="logo" style="width:110%;" >

</div>

<div class="main">
	<div id="registrationForm">
		<form action="" id="regForm" method="POST">
			<table id="regTable">
				<tr><th colspan="2"> Registrazione </th></tr>
				<tr>					
					<td><label class="column" for="nome">Nome</label></td>
					
					<td><input type="text" name="nome" id="nome" placeholder="Mario" required></td>
				</tr>
				<tr><td id="errorName" colspan="2"><p id="error">Il nome non deve contenere numeri!</p></td></tr>
				
				<tr> 
					<td><label class="column" for="cognome">Cognome</label></td>
					<td><input type="text" name="cognome" id="cognome" placeholder="Rossi" required></td>
				</tr>
				<tr><td id="errorSurname" colspan="2"><p id="error">Il cognome non deve contenere numeri!</p></td></tr>
				<tr> 
					<td><label class="column" for="email">Email</label></td>
					<td><input type="email" name="email" id="email" placeholder="mario.rossi2@gmail.com" required></td>
				</tr>
				<tr><td id="errorEmail" colspan="2"><p id="error">La mail è già in uso!</p></td></tr>
				
				<tr> 
					<td><label for="password">Password</label></td>
					<td><input type="password" name="password" id="password" placeholder="minimo 10 caratteri"required></td>
				</tr>
				<tr><td id="errorPassword" colspan="2"><p id="error">La password deve essere contenere almeno 10 caratteri e massimo 50!</p></td></tr>
				<tr>
					<td colspan="2"><input type="submit" id="submitter" value="Registrati"> </td>
				</tr>
			
			</table> 

		</form>
	</div>
	<div id="success">  <br> 
		<p> La registrazione è avvenuta con successo, sarai a breve rediretto alla Homepage... </p>
		<p> Se la redirezione non avviene in automatico, clicca <a href="zooPark.html"> qui </a>
    </div>
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script>

$(document).ready(function(){ // Funzione che viene caricata appena la pagina è pronta
	$("#regForm").submit(function(){
		if(validate($("regForm"))){
			
			$.ajax({
				url: "./Registration",
				data: $("#regForm").serialize(),
				type: "POST",
				dataType: "json",
				success: function(e){
					if(e.stato.localeCompare("ok")==0){//controllo sul successo della registrazione
						$("#registrationForm").hide();// il valore stato è inserito nella servlet a secodna dell'esito
						$("#success").show(); //mostra il messaggio di registrazione avvenuta con successo
						window.setTimeout(function() {//timeout per il reindirizzamento alla home
						    window.location.href = './zooPark.html';
						}, 6000);
					}
						
					else if(e.stato.localeCompare("email")==0){ //Mostra l'errore di duplicato email
						$("#errorEmail").show();
					}
					else {
						window.location.href = "./registration.jsp";
					}
				},
			});
		}
		return false;
	});
});


function checkNameSurname(inputTxt){ //controlla che il nome e cognome siano esenti da numeri
	var name=/^[A-Za-z]+$/; //intervallo delle lettere
	if(inputTxt.length<=50 && inputTxt.length>0 && inputTxt.match(name)){
		return true;
	}
	else {
		return false;
	}
}

function checkPassword(inputTxt){ //controlla la lunghezza della password
	if(inputTxt.length>=50 || inputTxt.length<=10){
		return false;
	}
	else return true;
}

function validate(obj){ //controlli sui singoli campi del form
	var valid = true;
	var name = $("#nome").val();
	if(!checkNameSurname(name)){ //Controllo sul nome
		valid = false;
		$("#errorName").show("fast");
	}
	else 	$("#errorName").hide();
	
	var cognome = $("#cognome").val(); //cognome
	if(!checkNameSurname(cognome)){
		valid = false;
		$("#errorSurname").show("fast");
	}
	else $("#errorSurname").hide();
	
	var password = $("#password").val(); //password
	if(!checkPassword(password)){
		valid = false;
		$("#errorPassword").show("fast");
	}
	else $("#errorPassword").hide();

	return valid;
	
}

</script>

<footer> @MaddaPuglia Company, sede Università degli Studi di Salerno, via Giovanni Paolo II (SA) </footer>
</body>
</html>