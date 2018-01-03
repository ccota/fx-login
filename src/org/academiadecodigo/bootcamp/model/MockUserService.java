package org.academiadecodigo.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class MockUserService implements UserService {
    // it's said that a hashMap works better...  O MAPA É FIXE
    private List<User> userList = new ArrayList<User>();

    @Override
    public Boolean authenticate(String name, String password) {
        if (userList.isEmpty()){
            return false;
        }
        User user = findByName(name);

        if (user == null){
            return false;
        }

        return user.getUsername().equals(name) && user.getPassWord().equals(password);
    }

    @Override
    public void addUser(User user) {
        if (user == null){
            return;
        }
        userList.add(user);
    }

    @Override
    public User findByName(String name) {
        if (userList.isEmpty()){
            return null;
        }
        for (User user : userList){
            if (user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public int count() {

        return userList.size();
    }


}
