/*
 * Main.java
 * 
 * Created on Oct 13, 2007, 12:59:04 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package echoserver;
import java.io.*;
import java.net.*;

/**
 *
 * @author evansrb1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(20019);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 20019.");
            System.exit(1);
        }

        Socket clientSocket = null;
        while (true) {
            clientSocket = serverSocket.accept();
            ClientThread thread = new ClientThread(clientSocket);
            thread.start();
        }
    }
}