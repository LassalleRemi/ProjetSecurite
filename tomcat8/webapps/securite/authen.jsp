<%@ page pageEncoding="UTF-8"%>
<%@ page
	import="securite.Codage,securite.Personne,java.io.*,javax.servlet.*,javax.servlet.http.*,javax.servlet.annotation.WebServlet,java.sql.*"%>
<html lang='fr'>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Page de login</title>
<link href='//getbootstrap.com/dist/css/bootstrap.min.css'
	rel='stylesheet'>
</head>
<body>
	<%
		Codage code=new Codage();
		Connection con=null;
		String image=request.getParameter("image");
		if(code.verif(image)){
		try {
		    String message=code.decode(image);
		    // enregistrement du driver
		    Class.forName("org.sqlite.JDBC");
		    
		    // connexion a la base
		    //con = DriverManager.getConnection("jdbc:postgresql://psqlserv/n3p1?	allowMultiQueries=true","haliprer","moi");
		      con = DriverManager.getConnection("jdbc:sqlite:database.db");
						
			
		    // execution de la requete
		    Statement stmt = con.createStatement();
		    PreparedStatement ps = con.prepareStatement("select * from login where login=? and mdp=?");
		    ps.setString(1,message.split(":")[0]);
		    ps.setString(2,message.split(":")[1]);
		    ResultSet rs = ps.executeQuery();
		    
		    
		    if(rs.next()) {
		session = request.getSession(true);
		Personne p = new Personne(rs.getString("login"),rs.getString("mdp"),rs.getString("nom"),rs.getString("prenom"),rs.getString("role"));
		session.setAttribute("login", p);
		con.close();
		response.sendRedirect("menu.jsp");
		    } else {
	%>
	<div class='container'>
		<div class='page-header'>
			<h1>Authentification</h1>
		</div>
		<div class='row'>
			<div class='col-xs-12'>
				<div class='alert alert-danger' role='alert'>Login ou mot de
					passe incorrect.</div>
				<%con.close();%>
				<a href='login.jsp'><button type='button'
						class='btn btn-default btn-lg'>Retour</button>
			</div>
		</div>
	</div>
	<%}%>
	</center>
	<%
	}catch (Exception e) {%>
	<div class='alert alert-warning' role='alert'>
		Erreur
		<%=e.getClass()%>
		: "<%=e.getMessage()%></div>
	<%}
		finally
	    {
		try{
			con.close();
		} catch (Exception e){}
	    }
		}%>
</body>
</html>



