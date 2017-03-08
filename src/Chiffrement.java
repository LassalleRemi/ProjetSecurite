import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chiffrement {
	public void encode(String message){
		String image="images/avion.bmp";
		String taille = "";
		String buf = "";
		try {
			Process process = Runtime.getRuntime().exec(new String[]{"./src_C/st_e","images/avion.bmp",message});
		} catch(IOException ioe) {
            ioe.printStackTrace();
        }
	}
	
	public String decode(int taille){
		Process process;
		String message="";
		try {
            String buf = "";
            process = Runtime.getRuntime().exec(new String[]{"./src_C/st_d","images/out.bmp",""+taille});
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                while((buf = reader.readLine()) != null) {
                    if(buf.contains("le message est : ")){
                        message=buf.split("le message est : ")[1];
                    }
                }
            } finally {
                reader.close();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
		return message;
	}
	
    public static void main(String[] args) throws IOException {
    	Chiffrement test=new Chiffrement();
    	if(args.length<2 || args.length>3){
    		System.out.println("erreur login/mdp");
    	}else{
    		String login=args[0];		
    		String mdp=args[1];
        	String message=login+":"+mdp;
        	int taille=message.length();
        	test.encode(message);
	        String dec=test.decode(taille);
	        System.out.println(dec);
	        
    	}
    }
}

