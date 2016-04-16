/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import com.rbevans.Rates.*;
import java.io.*;
import java.net.*;
import java.util.GregorianCalendar;

import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;

/**
 *
 * @author evansrb1
 */
public class Controller extends HttpServlet {
    public static final String TRAIL="trail";
    public static final String DURATION = "duration";
    public static final String DATE = "date";
    //public static final String DETAILS = "details";
    
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ServletContext servletContext = getServletContext();
        SignUp signup = (SignUp) session.getAttribute("trailz");
        if (signup == null) {
            signup = new SignUp();
            //session.setAttribute(TRAIL, signup);
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/SignUp.jsp");
            dispatcher.forward(request, response);
            System.out.println("gotten to the first sugar");
        } else {
            
            try{
            String trail = request.getParameter(TRAIL);
            String duration = request.getParameter(DURATION);
            String date = request.getParameter(DATE);
            //String details = request.getParameter(DETAILS);            
            
            String[] dateSplit = date.split("/");
            int dateMonth = Integer.parseInt(dateSplit[0]);
            int dateDay = Integer.parseInt(dateSplit[1]);
            int dateYear = Integer.parseInt(dateSplit[2]);
            
            int durationInt = Integer.parseInt(duration);
            
            
            signup.setDuration(durationInt);
            
            signup.setTrail(trail);
            signup.setDate(dateMonth, dateDay, dateYear); 
            
//            try {
                //String[] tokens = outputLine.split(":");

//                int dateYear = Integer.parseInt(tokens[0]);
//                int dateMonth = Integer.parseInt(tokens[1]);
//                int dateDay = Integer.parseInt(tokens[2]);
//                int durationDays = Integer.parseInt(tokens[4]);

                BookingDay today = new BookingDay(2016, 04, 01); //today's date
                BookingDay bookStartDay = new BookingDay(dateYear, dateMonth, dateDay);

                if (trail == null) {
                    trail = "<none entered>";
                }
                System.out.println(trail + " Trail ");
                
                HIKE hike = HIKE.GARDINER;
                if (trail.equals("Gardiner"))
                {
                    hike = HIKE.GARDINER;
                }
                if (trail.equals("Hellroaring"))
                {
                    hike = HIKE.HELLROARING;
                }
                if (trail.equals("Beaten"))
                {
                    hike = HIKE.BEATEN;
                }  
                
                Rates rates = new Rates(hike);
                rates.setBeginDate(bookStartDay);
                boolean success = rates.setDuration(durationInt);
                String details = null;
                double cost = 0;
                double normalDayRate = 0;
                double premiumDayRate = 0;
                int normalDays = 0;
                int premiumDays = 0;
                GregorianCalendar beginDate = null;
                GregorianCalendar endDate = null;
                
                if (rates.isValidDates()) {
                    System.out.println("Cost of trip = " + rates.getCost());
                    System.out.println("Weekdays: " + rates.getNormalDays());
                    System.out.println("Weekends: " + rates.getPremiumDays());
                    System.out.println("normal rate: " + rates.getBaseRate());
                    System.out.println("premium rate: " + rates.getPremiumRate());
                    System.out.println("Total cost of trip = " + rates.getCost());
                    success = true;
                    details = rates.getDetails();
                    cost = rates.getCost();
                    beginDate = rates.getBeginDate();
                    endDate = rates.getEndDate();
                    normalDays = rates.getNormalDays();
                    normalDayRate = rates.getBaseRate();
                    premiumDays = rates.getPremiumDays();
                    premiumDayRate = rates.getPremiumRate();
                    
                    //out.println(rates.getCost() + " Quoted Rate"); 
                } else {
                    System.out.println("Sorry, but " + rates.getDetails());
                    //out.println("-0.01: " + rates.getDetails());
                    success = false;
                    details = rates.getDetails();
                }           

                if (bookStartDay.isValidDate() && bookStartDay.after(today) && rates.isValidDates()){
                    //statusLbl.setText("Valid Date:)");     
                    //out.println(rates.getCost() + " Quoted Rate");
                    success = true;
                    details = rates.getDetails();
                    cost = rates.getCost();
                }
                else if (!bookStartDay.isValidDate() || !bookStartDay.after(today)){
                    success = false;
                    details = rates.getDetails();
                    //out.println("-0.01: " + rates.getDetails());  //Invalid Date, please enter again   
                }
                else if (!rates.isValidDates()){
                    success = false;
                    details = rates.getDetails();                    
                    //out.println("-0.01: " + rates.getDetails());  //Invalid Date, please enter again  
                }
//            }catch(IllegalArgumentException ex){
//                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            catch(ArrayIndexOutOfBoundsException ex){
//                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
//            }
                signup.setSuccess(success);
                signup.setDetails(details);
                signup.setCost(cost); 
                signup.setBeginDate(beginDate);
                signup.setEndDate(endDate);
                signup.setNormalDays(normalDays);
                signup.setNormalDayRate(normalDayRate);
                signup.setPremiumDays(premiumDays);
                signup.setPremiumDayRate(premiumDayRate);

            if (success == true) {
                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/results.jsp");
                dispatcher.forward(request, response);
                System.out.println("succeeded");
            }
            else if (success == false) {
                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/results_1.jsp");
                dispatcher.forward(request, response);
                System.out.println("failed");
            }
//            if (signup.getSuccess()) {
//                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/welcome_1.jsp");
//                dispatcher.forward(request, response);
//            } else {
//                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/SignUp.jsp");
//                dispatcher.forward(request, response);
//            }
            }catch(IllegalArgumentException ex){
                //Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("caught 1!");
            }
            catch(ArrayIndexOutOfBoundsException ex){
                //Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("caught 2!");
            }
            
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/SignUp.jsp");
            dispatcher.forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
