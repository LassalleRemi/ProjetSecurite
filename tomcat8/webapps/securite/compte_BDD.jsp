<%@ page pageEncoding="UTF-8" %>
<%@ page import="securite.Personne" %>
<%@ page import="java.io.*,javax.servlet.*,javax.servlet.http.*,javax.servlet.annotation.*,java.sql.*,org.apache.commons.lang3.StringEscapeUtils" %>
<html lang='fr'>
<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Administration</title>
<!-- Bootstrap core CSS --><link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
<link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
</head>
<body>
	
	<%
			session = request.getSession(true);
			Personne p = session.getAttribute("login");
			if (p==null) response.sendRedirect("Deconnection.jsp");
		%>

	<div class='container'>
		<div class='page-header'>
			<h1>Administration des informations.</h1>
		</div>
		<div class='row'>
			<div class='col-xs-12'>
	
	<%Connection con=null;
	try {
	    
	    // enregistrement du driver
	    Class.forName("org.sqlite.JDBC");
	    
	    // connexion a la base
	    //con = DriverManager.getConnection("jdbc:postgresql://psqlserv/n3p1","haliprer","moi");
		//con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/IUTsql", "postgres", "postgres");
		con = DriverManager.getConnection("jdbc:sqlite:../../database.db");
	    
	    String login = request.getParameter("login");
	    login = StringEscapeUtils.escapeHtml4(login);
	    String mdp = request.getParameter("mdp");
	    mdp = StringEscapeUtils.escapeHtml4(mdp);
	    String nom = request.getParameter("nom");
	    nom = StringEscapeUtils.escapeHtml4(nom);
	    String prenom = request.getParameter("prenom");
	    prenom = StringEscapeUtils.escapeHtml4(prenom);
	    
	    Statement stmt = con.createStatement();
	    
	    PreparedStatement ps = con.prepareStatement("update login set login=?, mdp=?, nom=?, prenom=?, role=? where login='"+login+"'");
	    ps.setString(1,request.getParameter("login"));
	    ps.setString(2,request.getParameter("mdp"));
	    ps.setString(3,request.getParameter("nom"));
	    ps.setString(4,request.getParameter("prenom"));
		ps.setString(5,request.getParameter("role"));
	    ps.executeUpdate();
	    
	    p.maj(login,mdp,nom, prenom);
	    %>
	    <div class='alert alert-success' role='alert'><%=prenom%> <%=nom%> , vos donnees ont ete mises a jour !</div>
	    <a href='Menu.jsp'><button type='button' class='btn btn-default btn-lg'>Retour au menu</button></a>
	    <%con.close();
	}catch (Exception e) {%>
		<div class='alert alert-warning' role='alert'>Erreur <%=e.getClass()%> : <%=e.getMessage()%> </div>
	<%
	}finally{
		try{
			con.close();
		} 
		catch (Exception e){
		}
	}
%>
</body>
</html>


