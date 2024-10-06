//kevon dawkins
//csci 340
//10/2/24
//textclient

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TextClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Socket sock = new Socket("127.0.0.1", 6013);
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader bin = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            while (true) {
                System.out.print("Enter a message to send to the server: ");
                String userInput = scanner.nextLine();
                pout.println(userInput);

                String serverResponse;
                while ((serverResponse = bin.readLine()) != null) {
                    System.out.println("Server Response: " + serverResponse);
                    break; // Break to allow the user to send another message
                }
            }

            // sock.close(); //  termination connection
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}