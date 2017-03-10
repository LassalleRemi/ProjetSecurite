<%@ page pageEncoding="UTF-8" %>
<%@ page import="securite.Personne" %>
<%@ page import="java.io.*, javax.servlet.*, javax.servlet.http.*, javax.servlet.annotation.*,java.sql.* " %>
	<html lang='fr'>
	<body>
	
    <%session = request.getSession(true);
		session.invalidate();
		response.sendRedirect("login.jsp");%>
    
    </body></html>




