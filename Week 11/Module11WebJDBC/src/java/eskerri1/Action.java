package eskerri1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import eskerri1.DatabaseInformation;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;

/**
 *
 * @author evansrb1
 */
//practice commit for git
public class Action extends HttpServlet {
    public static final String TRAIL="trail";
    public static final String DURATION = "duration";
    public static final String DATE = "date";
    private static final String USERNAME = "johncolter";
    private static final String PASSWORD = "LetMeIn";
    private static final String HOST = "web6.jhuep.com";
    private static final String DB = "mysql";
    private static final int PORT = 3306;
    private static final String DB_NAME = "class";
    //public static final String DETAILS = "details";
    
    
    public String[] setUpDatabase(String myQuery) {
        
        String[] myResults = null;
        int i = 0;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver " + cnfe.getMessage());
        }
        try {
            //String dbURL = "jdbc:" + DB + "://" + HOST + ":" + PORT + "/" + DB_NAME;
            String dbURL = "jdbc:" + DB + "://" + HOST + ":" + PORT + "/" + DB_NAME;
            dbURL = "jdbc:mysql://web6.jhuep.com:3306/class";
            Connection connection = DriverManager.getConnection(dbURL, USERNAME, PASSWORD);
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("Driver name: " + meta.getDriverName());
            System.out.println("Driver version: " + meta.getDriverVersion());
            
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            try {
                //ResultSet resultSet = statement.executeQuery("select * from APP.People");
                ResultSet resultSet = statement.executeQuery(myQuery);
                //ResultSet resultSet = statement.executeQuery("select reservation.First, reservation.Last, locations.location from reservation, guides, locations where reservation.guide = guides.idguides and reservation.location = locations.idlocations;");
                System.out.println("Reservations:");
                while (resultSet.next()) {
                    // first way...we'll use the column index
                    //String firstName = resultSet.getString(1);
                    // second way...we'll use the column label
                    //String lastName = resultSet.getString("Last");
                    //String location = resultSet.getString("location");
                    String startDay = resultSet.getString("StartDay");
                    System.out.println(" " + startDay);
                    myResults[i++] = startDay;
                }
            } catch (SQLException sqle) {
                System.err.println("error: " + sqle.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myResults;
    }
    
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
        DatabaseInformation signup = (DatabaseInformation) session.getAttribute("startDateSubmitter");
        if (signup == null) {
            signup = new DatabaseInformation();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            System.out.println("initial setup of the web page");
        } else {
            
            try{
            String date = request.getParameter(DATE);
            //String details = request.getParameter(DETAILS);            
            
            String[] dateSplit = date.split("-");
            int dateMonth = Integer.parseInt(dateSplit[0]);
            int dateDay = Integer.parseInt(dateSplit[1]);
            int dateYear = Integer.parseInt(dateSplit[2]);
            
//            int durationInt = Integer.parseInt(duration);
            String[] details = setUpDatabase("SELECT StartDay FROM reservation Where StartDay > '2014-06-04';");  
            
            signup.setDetails(details[0]);
            //setUpDatabase("SELECT StartDay FROM reservation Where StartDay > '" + dateSplit[2] + "-" + dateSplit[0] + "-" +dateSplit[1] +  "';");            
            
//            signup.setDuration(durationInt);
//            
//            signup.setTrail(trail);
//            signup.setDate(dateMonth, dateDay, dateYear); 
            
//            try {
                //String[] tokens = outputLine.split(":");

//                int dateYear = Integer.parseInt(tokens[0]);
//                int dateMonth = Integer.parseInt(tokens[1]);
//                int dateDay = Integer.parseInt(tokens[2]);
//                int durationDays = Integer.parseInt(tokens[4]);

//                BookingDay today = new BookingDay(2016, 04, 01); //today's date
//                BookingDay bookStartDay = new BookingDay(dateYear, dateMonth, dateDay);
//
//                if (trail == null) {
//                    trail = "<none entered>";
//                }
//                System.out.println(trail + " Trail ");
//                
//                HIKE hike = HIKE.GARDINER;
//                if (trail.equals("Gardiner"))
//                {
//                    hike = HIKE.GARDINER;
//                }
//                if (trail.equals("Hellroaring"))
//                {
//                    hike = HIKE.HELLROARING;
//                }
//                if (trail.equals("Beaten"))
//                {
//                    hike = HIKE.BEATEN;
//                }  
//                
//                Rates rates = new Rates(hike);
//                rates.setBeginDate(bookStartDay);
//                boolean success = rates.setDuration(durationInt);
//                String details = null;
//                double cost = 0;
//                double normalDayRate = 0;
//                double premiumDayRate = 0;
//                int normalDays = 0;
//                int premiumDays = 0;
//                GregorianCalendar beginDate = null;
//                GregorianCalendar endDate = null;
//                
//                if (rates.isValidDates()) {
//                    System.out.println("Cost of trip = " + rates.getCost());
//                    System.out.println("Weekdays: " + rates.getNormalDays());
//                    System.out.println("Weekends: " + rates.getPremiumDays());
//                    System.out.println("normal rate: " + rates.getBaseRate());
//                    System.out.println("premium rate: " + rates.getPremiumRate());
//                    System.out.println("Total cost of trip = " + rates.getCost());
//                    success = true;
//                    details = rates.getDetails();
//                    cost = rates.getCost();
//                    beginDate = rates.getBeginDate();
//                    endDate = rates.getEndDate();
//                    normalDays = rates.getNormalDays();
//                    normalDayRate = rates.getBaseRate();
//                    premiumDays = rates.getPremiumDays();
//                    premiumDayRate = rates.getPremiumRate();
//                    
//                    //out.println(rates.getCost() + " Quoted Rate"); 
//                } else {
//                    System.out.println("Sorry, but " + rates.getDetails());
//                    //out.println("-0.01: " + rates.getDetails());
//                    success = false;
//                    details = rates.getDetails();
//                }           
//
//                if (bookStartDay.isValidDate() && bookStartDay.after(today) && rates.isValidDates()){
//                    //statusLbl.setText("Valid Date:)");     
//                    //out.println(rates.getCost() + " Quoted Rate");
//                    success = true;
//                    details = rates.getDetails();
//                    cost = rates.getCost();
//                }
//                else if (!bookStartDay.isValidDate() || !bookStartDay.after(today)){
//                    success = false;
//                    details = rates.getDetails();
//                    //out.println("-0.01: " + rates.getDetails());  //Invalid Date, please enter again   
//                }
//                else if (!rates.isValidDates()){
//                    success = false;
//                    details = rates.getDetails();                    
//                    //out.println("-0.01: " + rates.getDetails());  //Invalid Date, please enter again  
//                }
////            }catch(IllegalArgumentException ex){
////                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
////            }
////            catch(ArrayIndexOutOfBoundsException ex){
////                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
////            }
//                signup.setSuccess(success);
//                signup.setDetails(details);
//                signup.setCost(cost); 
//                signup.setBeginDate(beginDate);
//                signup.setEndDate(endDate);
//                signup.setNormalDays(normalDays);
//                signup.setNormalDayRate(normalDayRate);
//                signup.setPremiumDays(premiumDays);
//                signup.setPremiumDayRate(premiumDayRate);
//
//            if (success == true) {
//                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/results.jsp");
//                dispatcher.forward(request, response);
//                System.out.println("succeeded");
//            }
//            else if (success == false) {
//                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/results_1.jsp");
//                dispatcher.forward(request, response);
//                System.out.println("failed");
//            }
//            if (signup.getSuccess()) {
//                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/welcome_1.jsp");
//                dispatcher.forward(request, response);
//            } else {
//                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/DatabaseInformation.jsp");
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
            
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/DatabaseInformation.jsp");
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
