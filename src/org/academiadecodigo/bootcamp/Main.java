package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.service.MockBootcampService;
import org.academiadecodigo.bootcamp.service.MockUserService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.UserService;

public class Main extends Application {


    private Parent root;

    @Override
    public void init() throws Exception {
        ServiceRegistry.getInstance().addService("USERSERVICE", new MockUserService());
        ServiceRegistry.getInstance().addService("BOOTCAMPSERVICE", new MockBootcampService());


    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        // set the primary stage
        Navigation.getInstance().setStage(primaryStage);

        Navigation.getInstance().loadScreen("login");

        UserService userService = new MockUserService();
    }









    public static void main(String[] args) {
        launch(args);
    }
}
