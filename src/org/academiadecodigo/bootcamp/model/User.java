package org.academiadecodigo.bootcamp.model;

import java.sql.Timestamp;

public class User {

   private String passWord;
    private String email;
   private String username;

    public User(String username, String passWord, String email) {
        this.passWord = passWord;
        this.email = email;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPass(String password) {

        return this.passWord.equals(password);
    }

    public String getPassWord() {
        return passWord;
    }


}
