import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_exec {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec(new String[]{"./src_C/st_e","images/avion.bmp","bonjour tout le monde, comment ça va ?"});
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String buf = "";
            String taille = "";
            try {
                while((buf = reader.readLine()) != null) {
                    if(buf.contains("la longeur du message est de : ")){
                        taille = buf.split(": ")[1];
                    }
                }
                process = Runtime.getRuntime().exec(new String[]{"./src_C/st_d","images/out.bmp",taille});
                reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while((buf = reader.readLine()) != null) {
                    if(buf.contains("le message est : ")){
                        System.out.println(buf);
                    }
                }
            } finally {
                reader.close();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}