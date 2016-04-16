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

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String HOST = "localhost";
    private static final String DB = "derby";
    private static final int PORT = 1527;
    private static final String DB_NAME = "MyFirstDatabase";
    private Database database = null;
    
    public Main() {
        try {
            Database database = new Database(DB, HOST, PORT, DB_NAME);
            Connection connection = database.getConnection(USERNAME, PASSWORD);
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("Driver name: " + meta.getDriverName());
            System.out.println("Driver version: " + meta.getDriverVersion());
            
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            try {
                ResultSet resultSet = statement.executeQuery("select * from People");
                System.out.println("People in the database are:");
                resultSet.first();
                while (!resultSet.isAfterLast()) {
                    // first way...we'll use the column index
                    String firstName = resultSet.getString(2);
                    // second way...we'll use the column label
                    String lastName = resultSet.getString("LAST_NAME");
                    System.out.println("  " + firstName + " " + lastName);
                    resultSet.next();
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
        Main main = new Main();

        // TODO code application logic here
    }

}
