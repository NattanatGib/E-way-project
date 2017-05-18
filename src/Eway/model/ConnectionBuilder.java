
package Eway.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Volk
 * 
 */
public class ConnectionBuilder {
    public static Connection mainConnection = null;
    public static Connection getConnection() {
       Connection con = null;
       String url = "jdbc:mysql://10.4.56.21:3306/eway";
       String username = "eway";
       String password = "eway";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con  =  DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }         
            return con;
    }
}
