/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.12
 * Generated at: 2017-03-15 10:59:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import securite.Personne;
import securite.Codage;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import org.apache.commons.lang3.StringEscapeUtils;

public final class inscription_005fBDD_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang='fr'>\n");
      out.write("<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>\n");
      out.write("<title>Administration</title>\n");
      out.write("<!-- Bootstrap core CSS --><link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>\n");
      out.write("<link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div class='container'>\n");
      out.write("\t\t<div class='page-header'>\n");
      out.write("\t\t\t<h1>Inscription</h1>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class='row'>\n");
      out.write("\t\t\t<div class='col-xs-12'>\n");
      out.write("\t\n");
      out.write("\t");
	Codage code=new Codage();
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

      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
