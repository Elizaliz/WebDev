/*
 * ClientThread.java
 * 
 * Created on Nov 4, 2007, 2:11:49 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package echoserver;

import echoserver.Rates.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evansrb1
 */
public class ClientThread extends Thread {

    private final Socket socket;
    public ClientThread(Socket clientSocket) {
        this.socket = clientSocket;
    }
    public void run () {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //out.println("Welcome to en605481 echo server\n\rType \"bye\" to disconnect\n\r");
            //out.println("try to set up the server");
            String outputLine = null;
            while (!socket.isClosed()) {
//String output = trail + ":" + dateYear + ":" + dateMonth + ":" + dateDay + ":" + durationInput;
//"1:2008:7:1:4"
                  //System.out.println("step0");
                  outputLine = in.readLine();
                  System.out.println(outputLine);
                  //System.out.println("step1");
                if (outputLine == null) {
                    break;
                }
                
                try {
                    String[] tokens = outputLine.split(":");
                
                    int dateYear = Integer.parseInt(tokens[0]);
                    int dateMonth = Integer.parseInt(tokens[1]);
                    int dateDay = Integer.parseInt(tokens[2]);
                    int trail = Integer.parseInt(tokens[3]);
                    int durationDays = Integer.parseInt(tokens[4]);

                    BookingDay today = new BookingDay(2016, 04, 01); //today's date
                    BookingDay bookStartDay = new BookingDay(dateYear, dateMonth, dateDay);

                    HIKE hike = HIKE.GARDINER;

                    if (trail == 0) {
                        hike = HIKE.GARDINER;
                    }
                    if (trail == 1) {
                        hike = HIKE.HELLROARING;
                    }
                    if (trail == 2) {
                        hike = HIKE.BEATEN;
                    }
                    Rates rates = new Rates(hike);
                    rates.setBeginDate(bookStartDay);
                    boolean success = rates.setDuration(durationDays);

                    if (rates.isValidDates()) {
                        System.out.println("Cost of trip = " + rates.getCost());
                        System.out.println("Weekdays: " + rates.getNormalDays());
                        System.out.println("Weekends: " + rates.getPremiumDays());  
                        System.out.println("Total cost of trip = " + rates.getCost()); 
                        //out.println(rates.getCost() + " Quoted Rate"); 
                    } else {
                        System.out.println("Sorry, but " + rates.getDetails());
                        out.println("-0.01: " + rates.getDetails());
                    }           

                    if (bookStartDay.isValidDate() && bookStartDay.after(today) && rates.isValidDates()){
                        //statusLbl.setText("Valid Date:)");     
                        out.println(rates.getCost() + " Quoted Rate");
                    }
                    else if (!bookStartDay.isValidDate() || !bookStartDay.after(today)){
                        out.println("-0.01: " + rates.getDetails());  //Invalid Date, please enter again   
                    }
                    else if (!rates.isValidDates()){
                        out.println("-0.01: " + rates.getDetails());  //Invalid Date, please enter again  
                    }
                    break;
                }catch(IllegalArgumentException ex){
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
                catch(ArrayIndexOutOfBoundsException ex){
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                    //System.out.println("closing out");
                }
                if (in != null) {
                    in.close();
                    //System.out.println("closing in");
                }
                if (socket != null) {
                    socket.close();
                    //System.out.println("closing socket");
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
