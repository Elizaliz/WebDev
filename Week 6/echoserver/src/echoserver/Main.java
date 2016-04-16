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
        String outputLine = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        while (true) {
            try {
                serverSocket = new ServerSocket(80);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 8888.");
                System.exit(1);
            }

            Socket clientSocket = null;
            try {
                while (true) {
                    clientSocket = serverSocket.accept();

                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    while (!clientSocket.isClosed()) {
                        outputLine = in.readLine();
                        if (outputLine == null) {
                            break;
                        }
                        out.println(outputLine);
                    }
                    out.close();
                    in.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
            } finally {
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            }
        }
    }
}