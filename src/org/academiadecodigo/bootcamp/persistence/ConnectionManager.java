package org.academiadecodigo.bootcamp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    Connection connection = null;
   private String pass;
  private String user;
   private String dbUrl;

    public ConnectionManager(){
        this.dbUrl = "jdbc:mysql://localhost:3306/ac?useSSL=false" ;
        this.user = "root";
        this.pass = "";
    }







    public Connection getConnection() {

        try {
            if (connection == null) {
                connection = DriverManager.getConnection(dbUrl, user, pass);
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }
        return connection;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }
}
