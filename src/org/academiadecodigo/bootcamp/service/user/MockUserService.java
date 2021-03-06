package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;

import java.util.*;

public class MockUserService implements UserService {

    private Map<String, User> userList = new HashMap<String, User>();

    @Override
    public Boolean authenticate(String name, String password) {
        if (userList.isEmpty()) {
            return false;
        }
        User user = findByName(name);

        if (user == null) {
            return false;
        }

        return user.getUsername().equals(name) && user.getPassWord().equals(password);
    }

    @Override
    public void addUser(User user) {
        if (user == null) {
            return;
        }
        userList.put(user.getUsername(), user);
    }

    @Override
    public User findByName(String name) {
        return userList.get(name);
    }

    @Override
    public int count() {

        return userList.size();
    }


}
