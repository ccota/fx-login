package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.Service;

public interface UserService extends Service {

    /**
     *
     * @param name
     * @param password
     * @return
     */

    public Boolean authenticate(String name, String password);

    /**
     *
     * @param user
     */
    public void addUser(User user);


    /**
     *
     * @param name
     * @return
     */
   public User findByName(String name);

    /**
     *
     * @return
     */
    public int  count();



}
