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

    private static final String USERNAME = "eskerri1";
    private static final String PASSWORD = "webdev16";
    private static final String HOST = "localhost";
    private static final String DB = "derby";
    private static final int PORT = 1527;
    private static final String DB_NAME = "MyFirstDatabase";

    public Main() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver " + cnfe.getMessage());
        }
        try {
            String dbURL = "jdbc:" + DB + "://" + HOST + ":" + PORT + "/" + DB_NAME;
            Connection connection = DriverManager.getConnection(dbURL, USERNAME, PASSWORD);
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("Driver name: " + meta.getDriverName());
            System.out.println("Driver version: " + meta.getDriverVersion());
            
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            try {
                ResultSet resultSet = statement.executeQuery("select * from APP.People");
                System.out.println("People in the database are:");
                while (resultSet.next()) {
                    // first way...we'll use the column index
                    String firstName = resultSet.getString(2);
                    // second way...we'll use the column label
                    String lastName = resultSet.getString("LAST_NAME");
                    System.out.println("  " + firstName + " " + lastName);
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
