package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.academiadecodigo.bootcamp.model.UserService;

public class LoginController {
    private boolean isOnLogin = true;

    @FXML
    private ImageView logoImage;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField usernameTxtField;

    @FXML
    private TextField emailTxtField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button Register;

    @FXML
    private Label errorLabel;

    @FXML
    private Hyperlink registerLink;

    @FXML
    private Hyperlink cancelLink;



    @FXML
    void onLogin(ActionEvent event) {
    }

    @FXML
    void onRegister(ActionEvent event) {
    }

    private UserService userService;



    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    
}

