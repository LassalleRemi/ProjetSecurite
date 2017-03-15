package securite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Codage
{
	public void encode(String message){
		String image="images/avion.bmp";
		String taille = "";
		String buf = "";
		try {
			Process process = Runtime.getRuntime().exec(new String[]{"./src_C/st_e","avion",message});
		} catch(IOException ioe) {
            ioe.printStackTrace();
        }
	}
	
	public String decode(String name){
		Process process;
		String message="";
		try {
            String buf = "";
            boolean reussi=false;
            while(!reussi){
	            process = Runtime.getRuntime().exec(new String[]{"./src_C/st_d",name,"200"});
	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            try {
	                while((buf = reader.readLine()) != null) {
	                    if(buf.contains("le message est : ")){	                    	
	                        if(buf.split(": ").length==2) {
	                        	message=buf.split("le message est : ")[1].split(";")[0];
	                        	
	                        	reussi=true;
	                        }
	                    }
	                }
	            } finally {
	                reader.close();
	            }
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
		return message;
	}
	
	public boolean verif(String image) {
		String dec=decode(image);
		System.out.println(dec);
		boolean authent=false;
		System.out.println("Recherche de l'utilisateur "+dec.split(":")[0]);
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:database.db");
			Statement stmt = con.createStatement();
			String query = "select * from login";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String util = rs.getString(1)+":"+rs.getString(2); 
				if(dec.equals(util)) authent=true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return authent;
	}
	
}

