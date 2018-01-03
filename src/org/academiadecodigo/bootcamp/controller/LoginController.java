package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.UserService;
import org.academiadecodigo.bootcamp.utils.Security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements Controller {
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


    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    @FXML
    void onLogin(ActionEvent event) {


        if ((isOnLogin)) {
            login();
        } else {
            register();
        }
    }


    @FXML
    void onRegister(ActionEvent event) {
        if (isOnLogin){
            setOnRegister();
            return;
        }
        setOnLogin();


    }

    private boolean checkTextFieldContents() {
        if (usernameTxtField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            errorLabel.setText("Please set your user name and password ");
            return true;
        }
        if (!isOnLogin && emailTxtField.getText().isEmpty()) {
            errorLabel.setText("Please set your Email ");
            return true;
        }

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(emailTxtField.getText());
        if (!isOnLogin && !matcher.matches()) {
            emailTxtField.clear();
            errorLabel.setText("Invalid email format");
            return true;
        }
        return false;
    }



    private void login(){

        if (checkTextFieldContents()) return;

        if (!userService.authenticate(usernameTxtField.getText(),Security.getHash(passwordField.getText()) )){
          errorLabel.setText(  "username or password does not exist");
            return;
        }

        errorLabel.setText("Login successful");
        Navigation.getInstance().loadScreen("mainWindow");
    }


    private void register(){

        if (checkTextFieldContents()) return;

        if (userService.findByName(usernameTxtField.getText()) != null){
            usernameTxtField.clear();
            errorLabel.setText("Username already taken");
            return;
        }

        userService.addUser(new User(usernameTxtField.getText(), Security.getHash(passwordField.getText()), emailTxtField.getText()));
        errorLabel.setText("Register successful");

        setOnLogin();

    }

    private UserService userService;




    private void setOnRegister(){
        isOnLogin = false;
        loginButton.setText("Register");
        registerLink.setText("Cancel");

        usernameTxtField.clear();
        passwordField.clear();
        emailTxtField.clear();
        errorLabel.setText("");

        emailLabel.setVisible(true);
        emailTxtField.setVisible(true);

    }

    private void setOnLogin() {
        isOnLogin = true;
        loginButton.setText("Login");
        registerLink.setText("Register");

        usernameTxtField.clear();
        passwordField.clear();
        emailTxtField.clear();

        emailLabel.setVisible(false);
        emailTxtField.setVisible(false);
    }

    public void setUserService(UserService userService) {
            this.userService = userService;
    }
}

