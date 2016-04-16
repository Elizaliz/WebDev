/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbevans.bookingrate;
import java.io.*;
import java.net.*;
/**
 *
 * @author lizskerritt
 */
public class Module6Networking {

    public static void main(String[] args) throws IOException {

        Socket classSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            System.out.println("Making the Socket...");
            classSocket = new Socket("128.220.101.240", 20025);
            System.out.println("Making the PrintWriter...");            
            out = new PrintWriter(classSocket.getOutputStream(), true);
            System.out.println("Making the BufferedReader...");                        
            in = new BufferedReader(new InputStreamReader(
                                        classSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: web9.apl.jhu.edu");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: class computer.");
            System.exit(1);
        }
        System.out.println("Reading stdIn....");
	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
        String line;             
        try {
            out.println(stdIn.readLine());//"1:2008:7:1:3");
            while ((line=in.readLine()) != null && line.length() != 0) {
                if (line.startsWith("-0.01"))
                {
                    System.out.println("Error! " + line.substring(6));
                }
                else
                {
                    System.out.println("Success! " + line);
                }
            }
        } catch (IOException ioe) {
            System.err.println("Problem in communicating with socket: " + ioe.getMessage());
        } finally {
            if (out != null) out.close();
            if (in != null) in.close();
            System.out.println("----");
        }
        
//	//String userInput;
// 
//        String echo;
//	while ((echo=stdIn.readLine()) != null) {
//	    //out.println(echo);
//            //echo = in.readLine();
//            if (echo == null) {
//                System.out.println("Disconnected!");
//                break;
//            } else {
//                System.out.println("echo: " + echo);
//            }
//	}

//	out.close();
//	in.close();
//	stdIn.close();
	classSocket.close();
    }
}