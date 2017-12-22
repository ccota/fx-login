package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.academiadecodigo.bootcamp.model.User;
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
    void onLogin(ActionEvent event) {
        if (usernameTxtField.getText().isEmpty() && passwordField.getText().isEmpty()) {
            errorLabel.setText("Please set your user name and password ");
            return;
        }
        if (!isOnLogin && emailTxtField.getText().isEmpty()) {
            errorLabel.setText("Please set your Email ");
            return;
        }

        if (!isOnLogin) {
            userService.addUser(new User(usernameTxtField.getText(), passwordField.getText(), emailTxtField.getText()));
            loginButton.setText("Login");
            registerLink.setText("Register");
            emailLabel.setVisible(false);
            emailTxtField.setVisible(false);
            setOnLogin();

            return;
        }
        System.out.println(usernameTxtField.getText());

        if (userService.authenticate(usernameTxtField.getText(), passwordField.getText())) {
            errorLabel.setText("Log in successfull");
        } else{
            errorLabel.setText("fail to login");
    }

    }

    @FXML
    void onRegister(ActionEvent event) {
        if (isOnLogin){
            loginButton.setText("Register");
            registerLink.setText("Cancel");
            emailLabel.setVisible(true);
            emailTxtField.setVisible(true);
            setOnLogin();
            return;
        }
        loginButton.setText("Login");
        registerLink.setText("Register");
        emailLabel.setVisible(false);
        emailTxtField.setVisible(false);
        setOnLogin();


    }

    private UserService userService;



    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private void setOnLogin() {
        isOnLogin = !isOnLogin;
    }

}

