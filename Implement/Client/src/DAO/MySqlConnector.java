/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author bin
 */
public class MySqlConnector extends Connector {
    public MySqlConnector()
    {
        connectionStr = "jdbc:mysql://localhost:3306/";
        driverStr = "com.mysql.jdbc.Driver";
        database = "hoteldb";
        user = "root";
        pass = "root";
    }
}
