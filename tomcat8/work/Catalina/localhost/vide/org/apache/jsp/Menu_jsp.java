/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.12
 * Generated at: 2017-03-03 08:02:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import securite.Personne;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

public final class Menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<html lang='fr'>\n");
      out.write("\t<head><meta charset='utf-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'>\n");
      out.write("\t\n");
      out.write("\t<title>Menu</title>\n");
      out.write("\t<link href='//getbootstrap.com/dist/css/bootstrap.min.css' rel='stylesheet'>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\n");
      out.write("\t");

	try {
		session = request.getSession(true);
		Personne p = (Personne)session.getAttribute("login");
		if (p==null) 
			response.sendRedirect("Deconnection.jsp");
		else
		{	
			if(p.role.equals("A")){
      out.write("\n");
      out.write("\t\t\t\t<div class='container'>\n");
      out.write("\t\t\t\t<div class='page-header'>\n");
      out.write("\t\t\t\t<h1>Bonjour ");
      out.print(p.prenom);
      out.write(' ');
      out.print(p.nom);
      out.write(", que voulez-vous faire ?</h1>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<div class='row'\n");
      out.write("\t\t\t\t<div class='col-xs-6 col-xs-offset-3'\n");
      out.write("\t\t\t\t<nav>\n");
      out.write("\t\t\t\t<ul class='nav nav-pills nav-justified'>\n");
      out.write("\t\t\t\t\t<li role='presentation' class='btn btn-default btn-lg'><a href='etudiant.jsp'>Membres du site</a></li>\n");
      out.write("\t\t\t\t\t<li role='presentation' class='btn btn-default btn-lg'><a href='etudiant.jsp'>Méssages des membres</a></li>\n");
      out.write("\t\t\t\t\t<li role='presentation' class='btn btn-default btn-lg'><a href='Maj.jsp'>Paramètre</a></li>\n");
      out.write("\t\t\t\t\t<li role='presentation' class='btn btn-default btn-lg'><a href='Deconnection.jsp'>Déconnexion</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t  ");
}
			if(p.role.equals("M")){
      out.write("\n");
      out.write("\t\t\t\t<div class='container'>\n");
      out.write("\t\t\t\t<div class='page-header'>\n");
      out.write("\t\t\t\t<h1>Bonjour ");
      out.print(p.prenom);
      out.write(' ');
      out.print(p.nom);
      out.write(", que voulez-vous faire ?</h1>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<div class='row'\n");
      out.write("\t\t\t\t<div class='col-xs-6 col-xs-offset-3'\n");
      out.write("\t\t\t\t<nav>\n");
      out.write("\t\t\t\t<ul class='nav nav-pills nav-justified'>\n");
      out.write("\t\t\t\t\t<li role='presentation' class='btn btn-default btn-lg'><a href='prof.jsp'>Appel</a></li>\n");
      out.write("\t\t\t\t\t<li role='presentation' class='btn btn-default btn-lg'><a href='Maj.jsp'>Modifier vos infos</a></li>\n");
      out.write("\t\t\t\t\t<li role='presentation' class='btn btn-default btn-lg'><a href='Deconnection.jsp'>Déconnexion</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t  ");
}
	}}catch (Exception e){
      out.write("\n");
      out.write("\t\t\t\t<div class='alert alert-warning' role='alert'>Erreur \"");
      out.print(e.getClass());
      out.write("\" : \"");
      out.print(e.getMessage());
      out.write("\"</div>\n");
      out.write("\t\t");
}finally{
			try{} 
			catch (Exception e){}	
	}
      out.write("\n");
      out.write("  \n");
      out.write("    </body></html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
