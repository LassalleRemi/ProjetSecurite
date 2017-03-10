<%@ page pageEncoding="UTF-8" %>
<%@ page import="securite.Personne" %>
<%@ page import="java.io.*,javax.servlet.*,javax.servlet.http.*,javax.servlet.annotation.*,java.sql.*" %>
	<html lang='fr'>
	<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>
	
	<title>Menu</title>
	<link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
	</head>
	<body>
	
	<%
			try {
				session = request.getSession(true);
				Personne p = (Personne)session.getAttribute("login");
				if (p==null) 
			response.sendRedirect("Deconnection.jsp");
				else
				{	
			if(p.role.equals("A")){
		%>
				<div class='container'>
				<div class='page-header'>
				<h1>Bonjour <%=p.prenom%> <%=p.nom%>, que voulez-vous faire ?</h1>
				</div>
			
				<div class='row'
				<div class='col-xs-6 col-xs-offset-3'
				<nav>
				<ul class='nav nav-pills nav-justified'>
					<li role='presentation' class='btn btn-default btn-lg'><a href='etudiant.jsp'>Membres du site</a></li>
					<li role='presentation' class='btn btn-default btn-lg'><a href='etudiant.jsp'>Méssages des membres</a></li>
					<li role='presentation' class='btn btn-default btn-lg'><a href='compte.jsp'>Paramètre</a></li>
					<li role='presentation' class='btn btn-default btn-lg'><a href='deconnection.jsp'>Déconnexion</a></li>
				</ul>
				</nav>
				</div>
				</div>
		  <%}
			if(p.role.equals("M")){%>
				<div class='container'>
				<div class='page-header'>
				<h1>Bonjour <%=p.prenom%> <%=p.nom%>, que voulez-vous faire ?</h1>
				</div>
			
				<div class='row'
				<div class='col-xs-6 col-xs-offset-3'
				<nav>
				<ul class='nav nav-pills nav-justified'>
					<li role='presentation' class='btn btn-default btn-lg'><a href='prof.jsp'>Appel</a></li>
					<li role='presentation' class='btn btn-default btn-lg'><a href='compte.jsp'>Modifier vos infos</a></li>
					<li role='presentation' class='btn btn-default btn-lg'><a href='deconnection.jsp'>Déconnexion</a></li>
				</ul>
				</nav>
				</div>
				</div>
		  <%}
	}}catch (Exception e){%>
				<div class='alert alert-warning' role='alert'>Erreur "<%=e.getClass()%>" : "<%=e.getMessage()%>"</div>
		<%}finally{
			try{} 
			catch (Exception e){}	
	}%>
  
    </body></html>




