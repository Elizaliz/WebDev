/*
 * Database.java
 * 
 * Created on Nov 23, 2007, 7:45:43 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplejdbc;

import java.sql.Connection;
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
public class Database {
    private final String database;
    private final String host;
    private final int port;
    private final String dbName;
    private final String url;
    private Connection connection = null;
    private Statement statement = null;
    
    public Database(String database, String host, int port, String dbName) {
        this.database = database;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.url = "jdbc:" + database + "://" + host + ":" + port + "/" + dbName;
    }
    
    public Connection getConnection(String username, String password) throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
            initializeDatabase();
        }
        return connection;
    }

    private void dropTables() {
        try {
            statement = connection.createStatement();
            System.out.println("Database: dropping table People...");
            statement.executeUpdate("drop table People");
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            statement = connection.createStatement();
            System.out.println("Database: dropping table Cameras...");
            statement.executeUpdate("drop table Cameras");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializeDatabase() throws SQLException {
        dropTables();
        connection.setAutoCommit(false);
        statement = connection.createStatement();
        
        // create a batch statement and add SQL commands to it
        statement.addBatch("create table PEOPLE (PERSON int, FIRST_NAME varchar(20), LAST_NAME varchar(20), ADDRESS varchar(20), CITY varchar(20), STATE varchar(2), ZIP int)");
        statement.addBatch("insert into PEOPLE values(1, 'Bob', 'Evans', '123 Beartooth Hwy', 'Cooke City', 'WY', 12345)");
        statement.addBatch("insert into PEOPLE values(2, 'Tom', 'Smith', '11100 Johns Hopkins', 'Laurel', 'MD', 20723)");
        statement.addBatch("insert into PEOPLE values(3, 'John', 'Doe', '15682 Port Dr', 'Garden Grove', 'CA', 92643)");
        statement.addBatch("insert into PEOPLE values(4, 'Mickey', 'Mouse', '33 Royal Street', 'Anaheim', 'CA', 92802)");
        statement.addBatch("insert into PEOPLE values(5, 'Walter', 'Knott', '8039 Beach Blvd', 'Buena Park', 'CA', 90620)");
        statement.addBatch("insert into PEOPLE values(6, 'John', 'Wayne', '18601 Airport Way', 'Santa Ana', 'CA', 92707)");
        statement.addBatch("create table CAMERAS (CAMERA int, MFG varchar(20), Model varchar(20), PERSON int)");
        statement.addBatch("insert into CAMERAS values (1, 'Canon', '30D', 1)");
        statement.addBatch("insert into CAMERAS values (2, 'Canon', '40D', 5)");
        statement.addBatch("insert into CAMERAS values (3, 'Nikon', 'D70', 4)");

        // submits a batch of commands to the database for execution
        int[] updateCounts = statement.executeBatch();

        // Makes all changes made since the previous commit/rollback permanent
        // and releases any database locks currently held by this Connection object. 
        // This method should be used only when auto-commit mode has been disabled.
        System.out.print("Database: rebuilding database...");
        connection.commit();
            
        // Sets this connection's auto-commit mode to true. If a connection 
        // is in auto-commit mode, then all its SQL statements will be executed and 
        // committed as individual transactions. Otherwise, its SQL statements are 
        // grouped into transactions that are terminated by a call to either the method 
        // commit or the method rollback. By default, new connections are in auto-commit mode.
        connection.setAutoCommit(true);
        System.out.println("...rebuilt!");

    }
    
    public Statement getStatement()  {
        return statement;
    }
}
