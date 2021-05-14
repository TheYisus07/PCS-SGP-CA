/**
 *
 * @author Javier Blas
 */
package dataacces;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conection {
    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/SGP-CA";
    private final String USERNAME = "blass";
    private final String PASSWORD = "Rocket_21";

    public Connection getConnection() throws SQLException {
        connect();
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void connect() throws SQLException {
        
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                
    }

    public void disconnect() {
       if(connection!=null){
           try{
               if(!connection.isClosed()){
                   connection.close();
               }
           }catch (SQLException ex){
               Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }

    public PreparedStatement prepareStatement(String insert_into_sgpcaresume__VALUES_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

