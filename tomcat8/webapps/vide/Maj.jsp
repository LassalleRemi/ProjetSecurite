<%@ page pageEncoding="UTF-8" %>
<%@ page import="securite.Personne" %>
<%@ page import="java.io.*, javax.servlet.*, javax.servlet.http.*, javax.servlet.annotation.*,java.sql.* " %>
<html lang='fr'>
<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Page de login</title>
<link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
</head>
<body>

	<title>Administration</title>	
	<!-- Bootstrap core CSS --><link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
	
	</head>
	<body>

	<%session = request.getSession(true);
	Personne p = (Personne)session.getAttribute("login");
	if (p==null) response.sendRedirect("Deconnection.jsp");%>
	
	<div class='container'>
	<div class='page-header'>
	<h1>Modifier vos informations</h1>
	</div>
	<div class='row'>
		<div class='col-xs-12'>
		     <form class='form-horizontal' method='get' action='Maj2.jsp'>
			<div class='form-group'>
				<label for='inputLogin' class='col-sm-2 control-label'>Login</label>
				<div class='col-sm-10'>
				<input type='text' class='form-control' readonly='readonly' name='login' value='<%=p.login%>'>
			</div>
		</div>
	 	<div class='form-group'>
		<label for='inputPassword' class='col-sm-2 control-label'>Mot de passe</label>
		<div class='col-sm-10'>
		<input type='text' class='form-control' id='inputPassword' name='mdp' value='<%=p.mdp%>'>
		</div>
		</div>
		<div class='form-group'>
			<label for='inputNom' class='col-sm-2 control-label'>Nom</label>
			<div class='col-sm-10'>
				<input type='text' class='form-control' id='inputNom' name='nom' value='<%=p.nom%>'>
			</div>
		</div>
		<div class='form-group'>
			<label for='inputPrenom' class='col-sm-2 control-label'>Prenom</label>
			<div class='col-sm-10'>
				<input type='text' class='form-control' id='inputPrenom' name='prenom' value='<%=p.prenom%>'>
			</div>
		</div>
		<input type='hidden' name='type' value='<%=p.role%>'>
		<div class='form-group'>
		     <div class='col-sm-offset-2 col-sm-10'>
			  <button type='submit' class='btn btn-primary'>Mettre a jour</button>
		     </div>
		</div>
		</form>
		<a href='Menu.jsp'><button class='btn btn-default'>Retour au menu</button></a>	
	</div>
	</div>
	</div>	
</body>
</html>



