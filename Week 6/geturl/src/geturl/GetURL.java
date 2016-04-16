/*
 * GetURL.java
 * 
 * Created on Oct 15, 2007, 8:27:32 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package geturl;
import java.io.*;
import java.net.*;

/**
 *
 * @author evansrb1
 */
public class GetURL {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: GetURL url");
        } else {
            try {
                URL url = new URL(args[0]);
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(" " + line);
                }
                in.close();
            } catch (MalformedURLException mue) {
                // URL constructor
                System.out.println(args[0] + "is an invalid URL: " + mue);
            } catch (IOException ioe) {
                // Stream constructors
                System.out.println("IOException: " + ioe);
            }
        }
    }
}
