
package org.academiadecodigo.bootcamp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.BootCamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.utils.Gender;


public class BootcampController implements Controller {

    private BootcampService bootcampService;

    @FXML
    private Button back;

    @FXML
    private TableView<CodeCadet> tableview;

    @FXML
    private TableColumn<CodeCadet, User> nameCol;

    @FXML
    private TableColumn<CodeCadet, Gender> genderCol;

    @FXML
    private TableColumn<CodeCadet, String> addressCol;

    @FXML
    private TableColumn<CodeCadet, String> cityCol;

    @FXML
    private TableColumn<CodeCadet, String> phoneCol;

    @FXML
    private TableColumn<CodeCadet, String> birthDateCol;


    @FXML
    private TableColumn<CodeCadet, BootCamp> bootcampCol;

    @FXML
    private Label titleLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private Label startLabel;

    @FXML
    private Label endLabel;


    @FXML
    void goToBootcampList(ActionEvent event) {

        Navigation.getInstance().bootcampList();
    }


    public void initialize() {

        bootcampService = (BootcampService) ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE");

        ObservableList<CodeCadet> codeCadets = FXCollections.observableList(bootcampService.listAllCodeCadets(bootcampService.getSelectedBootcamp()));

        tableview.setItems(codeCadets);
        tableview.setMinSize(400, 200);
        fillTableAndLabels(codeCadets);


    }

    private void fillTableAndLabels(ObservableList<CodeCadet> codeCadets) {

        idLabel.setText(Integer.toString(codeCadets.get(0).getBootCamp().getId()));
        locationLabel.setText(codeCadets.get(0).getBootCamp().getLocation());
        startLabel.setText(codeCadets.get(0).getBootCamp().getStartString());
        endLabel.setText(codeCadets.get(0).getBootCamp().getEndString());

        nameCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        birthDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDateString"));
        bootcampCol.setCellValueFactory(new PropertyValueFactory<>("bootCamp"));
    }

}
