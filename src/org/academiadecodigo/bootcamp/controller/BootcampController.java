
package org.academiadecodigo.bootcamp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.BootCamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.service.BootcampService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.utils.Gender;

import java.awt.event.ActionEvent;

public class BootcampController implements Controller {

    private BootcampService bootcampService;

    @FXML
    private Button back;

    @FXML
    private TableView<CodeCadet> tableview;

    @FXML
    private TableColumn<CodeCadet, String> NameCol;

    @FXML
    private TableColumn<CodeCadet, Gender> genderCol;

    @FXML
    private TableColumn<CodeCadet, String> addressCol;

    @FXML
    private TableColumn<CodeCadet,  String> cityCol;

    @FXML
    private TableColumn<CodeCadet, String> phoneCol;


    @FXML
    private TableColumn<CodeCadet, Integer> bootcampCol;

    @FXML
    private Label titleLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private Label startLabel;

    @FXML
    void goBootcampList(ActionEvent event) {

        Navigation.getInstance().bootcampList();

    }


    public void initialize(){

        bootcampService =(BootcampService) ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE");
/*

        ObservableList<CodeCadet> codeCadets = FXCollections.observableList(bootcampService.listAllCodeCadets(bootCamp));
        tableview.setItems(codeCadets);




        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("end"));
*/


    }

}
