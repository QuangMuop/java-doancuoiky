/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bin
 */
public abstract class Connector {
    protected String connectionStr = "";
    protected String driverStr = "";
    protected Connection connection;
    protected String database = "";
    protected String user = "";
    protected String pass = "";
    
    public Connection getConnection()
    {
        return connection;
    }

    public void openConnection()
    {
        try {
            // TODO code application logic here
            //register driver
            Class.forName(driverStr);
            // Create connection
            connection = (Connection) DriverManager.getConnection(
                    connectionStr + database, user, pass);

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}