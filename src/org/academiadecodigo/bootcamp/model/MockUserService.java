package org.academiadecodigo.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class MockUserService implements UserService {
    private List<User> userList = new ArrayList<User>();

    @Override
    public Boolean authenticate(String name, String password) {
        if (userList.size() ==0){
            return false;
        }
        if (findByName(name) == null){
            return false;
        }
        System.out.println("name " + name);

        System.out.println(findByName(name).getUsername() + findByName(name).checkPass(password));

        return findByName(name).getUsername().equals(name) && findByName(name).checkPass(password);
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public User findByName(String name) {
        if (userList.size() == 0){
            return null;
        }
        User user = null;
        for (User u : userList){
            if (u.getUsername().equals(name)){
                return u;
            }
        }

        return user;
    }

    @Override
    public int count() {

        return userList.size();
    }
}
