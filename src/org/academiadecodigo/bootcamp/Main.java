package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.model.MockUserService;
import org.academiadecodigo.bootcamp.model.UserService;

public class Main extends Application {


    private Parent root;

    @Override
    public void init() throws Exception {


        //Instantiate the view and controller
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/login.fxml"));
        root = fxmlLoader.load();

        UserService userService = new MockUserService();

        //Wire the controller to the service
            LoginController loginController =  fxmlLoader.getController();
            loginController.setUserService(userService);



    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        if (root == null){
            throw new  IllegalStateException("Root view not properly loaded");
        }

            primaryStage.setTitle("<Academia de Código_>");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();






    }


    public static void main(String[] args) {
        launch(args);
    }
}
