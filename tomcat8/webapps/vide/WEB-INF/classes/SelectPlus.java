import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.Properties;
import java.io.*;

@WebServlet("/servlet/SelectPlus")
public class SelectPlus extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("/home/infoetu/haliprer/Documents/tomcat8/webapps/vide/WEB-INF/classes/settings.txt");
			prop.load(input);
		        Class.forName("org.sqlite.JDBC");
			Connection con = con = DriverManager.getConnection("jdbc:sqlite:database.db");
			String table = req.getParameter("table");
			String ahrefMod;
			String ahrefDel;
			if (con != null) {
				try {
					Statement stmt = con.createStatement();
					String query = "";
					if (table != null && table.length() > 0) {
						query = "select * from " + table;
					}else{
						out.println("Aucune table rentrer en paramametre ou la table n'existe pas !");
					}										
					ResultSet rs = stmt.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					
					out.println("<TABLE  class=\"table-centered table-hover table-condensed\"><tr>"); //Bootstrap
					//Afficher les noms des collones en gras.
					for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
						out.println("<th>"+rsmd.getColumnName(i)+"</th>");
					}
					out.println("</tr>");
					//Affichage de la table souhaité
					while (rs.next()) {
						out.println("<tr>");
						for (int i = 1; i < rsmd.getColumnCount()+1; i++) {
							out.println("<td>"+rs.getObject(i).toString()+"</td>");
						}
						ahrefDel = "<td><a href=\"ExDeletePlus?table="+table; 
						ahrefMod = "<td><a href=\"FormUpdatePlus?table="+table;
						for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
							ahrefDel += "&"+rsmd.getColumnName(i)+"="+rs.getObject(i).toString();
							ahrefMod += "&"+rsmd.getColumnName(i)+"="+rs.getObject(i).toString();
						}
						ahrefDel += "\">Del</a></td>";
						ahrefMod += "\">Mod</a></td>";
						out.println(ahrefDel+ahrefMod);
						out.println("</tr>");
					}
					
					//Création du formulaire
					out.println("<form action=ExInsertPlus method=get><tr>");
					for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
						out.println("<td><input type=text name="+rsmd.getColumnName(i)+"></td>");
					}
					out.println("</tr></TABLE><INPUT TYPE=hidden NAME=table VALUE="+table+"> ");
					out.println("<input type=submit value=\"Valider\" >");
					out.println("</form>");
					//
					
					res.setContentType( "text/html" );
					out.println("<head><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\"></head>");  //Bootstrap
					out.println( "<html><title>SelectPlus</title><body>" );
					out.println("</body></html>");
					con.close();
				} catch (Exception e) {
					out.println("Une erreur due a SQL est survenu.." + e.getMessage());
				}
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			out.println("Une erreur due a SQL est survenu.." + e.getMessage());
		}

	}
}
