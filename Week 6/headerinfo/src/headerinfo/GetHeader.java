/*
 * GetHeader.java
 * 
 * Created on Oct 15, 2007, 8:39:44 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package headerinfo;
import java.net.*;
import java.io.*;


/**
 *
 * @author evansrb1
 */
public class GetHeader extends NetworkClient {
    private String url = null;
    
    public GetHeader(String host, int port, String url) {
        super(host, port);
        if (url == null) {
            url = "index.html";
        } else {
            this.url = url;
        }
    }
    
    @Override
    protected void handleConnection(Socket uriSocket) throws IOException {
        String line;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(uriSocket.getInputStream()));
            out = new PrintWriter(uriSocket.getOutputStream(), true);
            out.println("HEAD " + url + " HTTP/1.1\n");
            while ((line=in.readLine()) != null && line.length() != 0) {
                System.out.println(" " + line);
            }
        } catch (IOException ioe) {
            System.err.println("Problem in communicating with socket: " + ioe.getMessage());
        } finally {
            if (out != null) out.close();
            if (in != null) in.close();
            System.out.println("----");
        }
    }

    public static void main(String[] args) {
        if (args.length !=3) {
            System.err.println("Usage: GetHeader host port url");
        }
        int port = 80;
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            // ignore it, we'll use 80
            System.out.println("Unrecognized port number, using 80 as the default");
        }
        GetHeader gh = new GetHeader(args[0], port, args[2]);
        gh.connect();
    }
}
