package org.academiadecodigo.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class MockUserService implements UserService {
    private List<User> userList = new ArrayList<User>();

    @Override
    public Boolean authenticate(String name, String password) {
        return findByName(name).getUsername().equals(name) && findByName(name).checkPass(password);
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public User findByName(String name) {
        User user = null;
        for (User u : userList){
            user = (user.getUsername().equals(name))? u : null;
        }

        return user;
    }

    @Override
    public int count() {

        return userList.size();
    }
}
