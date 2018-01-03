package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.Controller;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.model.MockUserService;
import org.academiadecodigo.bootcamp.model.UserService;

public class Main extends Application {


    private Parent root;

    @Override
    public void init() throws Exception {




        //Wire the controller to the service



    }

    @Override
    public void start(Stage primaryStage) throws Exception{


        // set the primary stage
        Navigation.getInstance().setStage(primaryStage);

        Navigation.getInstance().loadScreen("login");

        UserService userService = new MockUserService();
        ((LoginController) Navigation.getInstance().getController("login")).setUserService(userService);
    }









    public static void main(String[] args) {
        launch(args);
    }
}
