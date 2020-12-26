import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket; // Server Socket
import java.net.Socket; // Client Socket

public class EchoServer {
    public static void main(String[] args){
    	System.out.println("Echo server started");
	
	try (ServerSocket sSocket = new ServerSocket(9999)) {
            System.out.println("Waiting for Connection...");
	    Socket cSocket = sSocket.accept(); // Accept Connection
            System.out.println("Client connected");

	    try (
	        BufferedReader br = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
	        PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
	    ) {
		String line;
		while ((line = br.readLine()) != null) {
		     System.out.println("Message from client: " + line);
	             out.println(line);
	        }		
	    } catch (IOException e) {
	        e.printStackTrace();
  	    }
        } catch (IOException e) {
    
        }
    }
}

