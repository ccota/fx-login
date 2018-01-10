package org.academiadecodigo.bootcamp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.BootCamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.bootcamp.BootcampService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.utils.Gender;
import org.academiadecodigo.bootcamp.utils.Security;

import java.util.GregorianCalendar;
import java.util.List;

public class BootcampListController implements Controller {

    private BootcampService bootcampService;

    @FXML
    private Button back;


    @FXML
    private TableView<BootCamp> tableview;

    @FXML
    private TableColumn<BootCamp, Integer> idCol;

    @FXML
    private TableColumn<BootCamp, String> locationCol;

    @FXML
    private TableColumn<BootCamp, String> startCol;

    @FXML
    private TableColumn<BootCamp, String> endCol;



    @FXML
    void onClick(MouseEvent event) {

        BootCamp selectedBootcamp = tableview.getSelectionModel().getSelectedItem();
        if (selectedBootcamp == null){
            return;
        }

        bootcampService.setSelectedBootcamp(selectedBootcamp);

        tableview.getSelectionModel().clearSelection();

        Navigation.getInstance().loadScreen("bootcamp");
    }


    @FXML
    private TableView<List> tableView;

    @FXML
    void goBack(ActionEvent event) {
        Navigation.getInstance().back();
    }


    public void initialize(){

        bootcampService =(BootcampService) ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE");
        fillBootcampTableCells();


    }




    private void fillBootcampTableCells() {



        ObservableList<BootCamp> bootCamps = FXCollections.observableList(bootcampService.listAllBootcamps());
        tableview.setItems(bootCamps);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("startString"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("endString"));
    }


}