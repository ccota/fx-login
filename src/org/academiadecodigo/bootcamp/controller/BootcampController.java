package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.service.BootcampService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.UserService;

import java.util.List;

public class BootcampController implements Controller {

    private BootcampService bootcampService;

    @FXML
    private Button back;



    @FXML
    private TableView<List> tableView;

    @FXML
    void goBack(ActionEvent event) {
        Navigation.getInstance().back();
    }
    public void initialize(){
        bootcampService =(BootcampService) ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE");
    }


}