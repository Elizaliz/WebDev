/*
 * Main.java
 * 
 * Created on Nov 18, 2007, 8:58:37 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplejdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evansrb1
 */
public class Main {

    private static final String USERNAME = "johncolter";
    private static final String PASSWORD = "LetMeIn";
    private static final String HOST = "web6.jhuep.com";
    private static final String DB = "mysql";
    private static final int PORT = 3306;
    private static final String DB_NAME = "class";

    //example command line args
    //select reservation.First, reservation.Last, locations.location from reservation, guides, locations where reservation.guide = guides.idguides and reservation.location = locations.idlocations;
    
    
    
    public Main(String myString) {
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
                ResultSet resultSet = statement.executeQuery("SELECT StartDay FROM reservation Where StartDay > '2014-07-01';");
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
                }
            } catch (SQLException sqle) {
                System.err.println("error: " + sqle.getMessage());
            }


            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main database = new Main("hi");

        // TODO code application logic here
    }

}
