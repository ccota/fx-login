package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.UserService;

public class MainWindowController implements Controller {

    @FXML
    private Button back;

    @FXML
    void goBack(ActionEvent event) {
        Navigation.getInstance().back();
    }


}