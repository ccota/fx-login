package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.model.BootCamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampService;
import org.academiadecodigo.bootcamp.service.bootcamp.MockBootcampService;
import org.academiadecodigo.bootcamp.service.user.JdbcUserService;
import org.academiadecodigo.bootcamp.service.user.MockUserService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.utils.Gender;
import org.academiadecodigo.bootcamp.utils.Security;

import java.sql.Connection;
import java.util.GregorianCalendar;

public class Main extends Application {

    private ConnectionManager connectionManager = new ConnectionManager();

    private Parent root;

    @Override
    public void init() throws Exception {




        ServiceRegistry.getInstance().addService("USERSERVICE", new JdbcUserService());
        ServiceRegistry.getInstance().addService("BOOTCAMPSERVICE", new MockBootcampService());

        ((JdbcUserService) ServiceRegistry.getInstance().getService("USERSERVICE")).setDbConnection(connectionManager.getConnection());


        // TO DELETE LATER


        ((UserService)  ServiceRegistry.getInstance().getService("USERSERVICE")).addUser(new User("a",  "a", "a@a.oma"));


        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addBootCamp(new BootCamp(1,"location1", new GregorianCalendar(2018, 2,5), new GregorianCalendar(2018, 5, 8)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addBootCamp(new BootCamp(2,"location2", new GregorianCalendar(2018, 3,5), new GregorianCalendar(2018, 5, 9)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addBootCamp(new BootCamp(3,"location3", new GregorianCalendar(2018, 4,5), new GregorianCalendar(2018, 5, 10)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addBootCamp(new BootCamp(4,"location4", new GregorianCalendar(2018, 5,5), new GregorianCalendar(2018, 5, 11)));



        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet( ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(1),new CodeCadet(new User("b", Security.getHash("b"),
                "b@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));

        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet( ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(1),new CodeCadet(new User("c", Security.getHash("b"),
                "c@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(2),new CodeCadet(new User("d", Security.getHash("b"),
                "d@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(2),new CodeCadet(new User("e", Security.getHash("b"),
                "e@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(3),new CodeCadet(new User("f", Security.getHash("b"),
                "f@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(3),new CodeCadet(new User("g", Security.getHash("b"),
                "g@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(4),new CodeCadet(new User("h", Security.getHash("b"),
                "h@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(4),new CodeCadet(new User("i", Security.getHash("b"),
                "i@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(1),new CodeCadet(new User("j", Security.getHash("b"),
                "j@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(2),new CodeCadet(new User("k", Security.getHash("b"),
                "k@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        ((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).addCodeCaddet(((BootcampService)  ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE")).findById(3),new CodeCadet(new User("l", Security.getHash("b"),
                "l@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));









    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        // set the primary stage
        Navigation.getInstance().setStage(primaryStage);

        Navigation.getInstance().loadScreen("login");

        UserService userService = new MockUserService();
    }


    @Override
    public void stop() throws Exception {
        super.stop();
        connectionManager.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


