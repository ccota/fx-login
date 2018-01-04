package org.academiadecodigo.bootcamp.model;


public class User {

   private String passWord;
    private String email;
   private String username;

    public User(String username, String passWord, String email) {
        this.passWord = passWord;
        this.email = email;
        this.username = username;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!email.equals(user.email)) return false;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + username.hashCode();
        return result;
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

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "username='" + username + '\'' +
                 ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
