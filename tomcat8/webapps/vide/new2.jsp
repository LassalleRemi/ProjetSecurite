<%@ page pageEncoding="UTF-8" %>
<%@ page import="securite.Personne" %>
<%@ page import="java.io.*, javax.servlet.*, javax.servlet.http.*, javax.servlet.annotation.*,java.sql.*,org.apache.commons.lang3.StringEscapeUtils " %>
<html lang='fr'>
<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Administration</title>
<!-- Bootstrap core CSS --><link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
<link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
</head>
<body>

	<div class='container'>
		<div class='page-header'>
			<h1>Administration des informations.</h1>
		</div>
		<div class='row'>
			<div class='col-xs-12'>
	
	<%	Connection con=null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:../../database.db");;
			String login = request.getParameter("login");
	    	login = StringEscapeUtils.escapeHtml4(login);
	    	String mdp = request.getParameter("mdp");
	    	mdp = StringEscapeUtils.escapeHtml4(mdp);
	    	String nom = request.getParameter("nom");
	    	nom = StringEscapeUtils.escapeHtml4(nom);
	   		String prenom = request.getParameter("prenom");
	    	prenom = StringEscapeUtils.escapeHtml4(prenom);
			if (con != null) {
				try {
					Statement stmt = con.createStatement();
					String query = "select * from login where login="+login;								
					ResultSet rs = stmt.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					//Affichage de la table souhaité
					while (rs.next()) {
						println("Login déjà utilisé");
						con.close();
					}
					query = "insert into login values ('"+login+"','"+mdp+"','"+nom+"','"+prenom+"','M')";	
					con.close();
				} catch (Exception e) {
					%> 
					<div class='alert alert-success' role='alert'>Login déjà utilisé !</div>
					<%
				}
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			out.println("Une erreur due a SQL est survenu.." + e.getMessage());
		}
%>
</body>
</html>

