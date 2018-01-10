package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.utils.Security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUserService implements UserService {
   private Connection dbConnection;


    @Override
    public Boolean authenticate(String name, String password) {
        User user = findByName(name);
       if (user == null){
           return false;
       }
        System.out.println("to autenticate: name: " + name + " pass:" + password);

        return user.getUsername().equals(name) && user.getPassWord().equals(password);
    }

    @Override
    public void addUser(User user) {

        if (findByName(user.getUsername()) != null){
            return;
        }

        Statement statement;


        try {


            statement = dbConnection.createStatement();

            String query = "INSERT INTO users (user_name, user_pass, user_email) VALUES (" +"'"  +  user.getUsername()+ "'" +
                    "," +"'" + user.getPassWord() +"'" + "," +"'" + user.getEmail() +"'"  + ");";

            System.out.println("Insert statement: " + query);

            statement.executeUpdate(query);


        } catch (SQLException e) {
            System.err.println("Failed to add a user to database");
            e.printStackTrace();
        }


    }

    @Override
    public User findByName(String name) {
        Statement statement;
        User user = null;

        try {
            statement = dbConnection.createStatement();

            String query = "SELECT user_name, user_pass, user_email FROM users WHERE user_name LIKE " + "'" + name +"'" ;

            System.out.println("query: " + query);
            ResultSet resultSet = statement.executeQuery(query);

            // user exists
            if (resultSet.next()) {

                String usernameValue = resultSet.getString("user_name");
                String passwordValue = resultSet.getString("user_pass");
                String emailValue = resultSet.getString("user_email");

                user = new User(usernameValue, passwordValue, emailValue);
                System.out.println("fetched username: " + usernameValue + " pass: " + passwordValue);
            }
        } catch (SQLException e) {
            System.err.println("Failed to query the database");
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int count() {

        int result = 0;

        // create a new statement
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();


            // create a query
            String query = "SELECT COUNT(*) FROM users";

            // execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // get the results
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
