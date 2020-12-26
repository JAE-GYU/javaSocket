import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket; 
import java.net.InetAddress;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args){
    	System.out.println("Echo client started");
	
	try {
	    InetAddress localAddress = InetAddress.getLocalHost();

	    try(
		Socket cSocket = new Socket(localAddress, 9999);
	        BufferedReader br = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
	        PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
	    ){

		System.out.println("Success to connect server");
		Scanner scanner = new Scanner(System.in);
	        
	        while (true) {
	            System.out.println("Enter message: ");
		    String line = scanner.nextLine();
		    if("quit".equalsIgnoreCase(line)) {
		        break;
		    }
	       	    out.println(line);
		    System.out.println("Message from server: " + br.readLine());
		}

		scanner.close();		
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	} catch (IOException e) {
	   
	}
    }
}
