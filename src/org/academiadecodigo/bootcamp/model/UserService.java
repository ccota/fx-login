package org.academiadecodigo.bootcamp.model;

public interface UserService {

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
