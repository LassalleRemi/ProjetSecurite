/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.12
 * Generated at: 2017-03-15 10:35:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import securite.Codage;
import securite.Personne;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

public final class authen_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang='fr'>\n");
      out.write("<head>\n");
      out.write("<meta charset='utf-8'>\n");
      out.write("<meta http-equiv='X-UA-Compatible' content='IE=edge'>\n");
      out.write("<meta name='viewport' content='width=device-width, initial-scale=1'>\n");
      out.write("<title>Page de login</title>\n");
      out.write("<link href='//getbootstrap.com/dist/css/bootstrap.min.css'\n");
      out.write("\trel='stylesheet'>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");

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
	
      out.write("\n");
      out.write("\t<div class='container'>\n");
      out.write("\t\t<div class='page-header'>\n");
      out.write("\t\t\t<h1>Authentification</h1>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class='row'>\n");
      out.write("\t\t\t<div class='col-xs-12'>\n");
      out.write("\t\t\t\t<div class='alert alert-danger' role='alert'>Login ou mot de\n");
      out.write("\t\t\t\t\tpasse incorrect.</div>\n");
      out.write("\t\t\t\t");
con.close();
      out.write("\n");
      out.write("\t\t\t\t<a href='login.jsp'><button type='button'\n");
      out.write("\t\t\t\t\t\tclass='btn btn-default btn-lg'>Retour</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t");
}
      out.write("\n");
      out.write("\t</center>\n");
      out.write("\t");

	}catch (Exception e) {
      out.write("\n");
      out.write("\t<div class='alert alert-warning' role='alert'>\n");
      out.write("\t\tErreur\n");
      out.write("\t\t");
      out.print(e.getClass());
      out.write("\n");
      out.write("\t\t: \"");
      out.print(e.getMessage());
      out.write("</div>\n");
      out.write("\t");
}
		finally
	    {
		try{
			con.close();
		} catch (Exception e){}
	    }
		}
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
