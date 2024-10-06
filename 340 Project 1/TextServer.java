//kevon dawkins
//csci 340
//10/2/24
//textserver
import java.net.*;
import java.io.*;

public class TextServer {
    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6013);
            while (true) {
                Socket client = sock.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received from client: " + clientMessage);
                    pout.println("Server received: " + clientMessage);
		     pout.println("Server's current date and time: " +  
      new java.util.Date().toString()); 

                }

                client.close();
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}