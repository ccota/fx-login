package org.academiadecodigo.bootcamp.model;

import java.sql.Timestamp;

public class User {

    String passWord;
    String email;
    String username;

    public User(String passWord, String email, String username) {
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




}
