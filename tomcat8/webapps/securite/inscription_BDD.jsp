<%@ page pageEncoding="UTF-8" %>
<%@ page import="securite.Personne" %>
<%@ page import="securite.Codage,java.io.*, javax.servlet.*, javax.servlet.http.*, javax.servlet.annotation.*,java.sql.*,org.apache.commons.lang3.StringEscapeUtils " %>
<html lang='fr'>
<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Administration</title>
<!-- Bootstrap core CSS --><link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
<link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>
</head>
<body>

	<div class='container'>
		<div class='page-header'>
			<h1>Inscription</h1>
		</div>
		<div class='row'>
			<div class='col-xs-12'>
	
	<%	Codage code=new Codage();
		Connection con=null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:../../database.db");
			String login = request.getParameter("login");
	    	login = StringEscapeUtils.escapeHtml4(login);
	    	String mdp = request.getParameter("mdp");
	    	mdp = StringEscapeUtils.escapeHtml4(mdp);
			if (con != null) {
				// Verification du login
				Statement stmt = con.createStatement();
				PreparedStatement ps = con.prepareStatement("select * from login where login=?");
				ps.setString(1,login);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) 
				{
					out.println("<div class='alert alert-danger' role='alert'>Le login "+ login +" est déja utilisé, veuillez en choisir un autre.</div>");
					out.println("<a href='new.jsp'><button type='button' class='btn btn-default btn-lg'>Retour</button></a>");
				}else{
					ps = con.prepareStatement("insert into login values (?,?,?,?,'M')");
					ps.setString(1,login);
					ps.setString(2,mdp);
					ps.setString(3,login);
					ps.setString(4,login);
					ps.executeUpdate();
					out.println("<div class='alert alert-success' role='alert'>Bienvenue, ! Votre compte à bien été créé !</div>");
					out.println("<a href='Login.jsp'><button type='button' class='btn btn-default btn-lg'>Connexion</button></a>");
			    	String message=login+":"+mdp+";";
			    	code.encode(message,"avion");
				}
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			out.println("<div class='alert alert-danger' role='alert'>Une erreur due a SQL est survenu : " + e.getMessage()+"</div>");
		}
%>
</body>
</html>

