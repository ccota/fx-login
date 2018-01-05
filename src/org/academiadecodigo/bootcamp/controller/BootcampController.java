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
import org.academiadecodigo.bootcamp.service.BootcampService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.UserService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class BootcampController implements Controller {

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
    private TableColumn<BootCamp, Calendar> startCol;

    @FXML
    private TableColumn<BootCamp, Calendar> endCol;



    @FXML
    void onClick(MouseEvent event) {

        BootCamp selectedBootcamp = tableview.getSelectionModel().getSelectedItem();
        if (selectedBootcamp == null){
            return;
        }
        System.out.println(selectedBootcamp.getLocation());
        tableview.getSelectionModel().clearSelection();
    }


    @FXML
    private TableView<List> tableView;

    @FXML
    void goBack(ActionEvent event) {
        Navigation.getInstance().back();
    }
    public void initialize(){
        bootcampService =(BootcampService) ServiceRegistry.getInstance().getService("BOOTCAMPSERVICE");




        bootcampService.addBootCamp(new BootCamp(1,"location1", new GregorianCalendar(2018, 2,5), new GregorianCalendar(2018, 5, 8)));
        bootcampService.addBootCamp(new BootCamp(2,"location2", new GregorianCalendar(2018, 3,5), new GregorianCalendar(2018, 5, 9)));
        bootcampService.addBootCamp(new BootCamp(3,"location3", new GregorianCalendar(2018, 4,5), new GregorianCalendar(2018, 5, 10)));
        bootcampService.addBootCamp(new BootCamp(4,"location4", new GregorianCalendar(2018, 5,5), new GregorianCalendar(2018, 5, 11)));

        ObservableList<BootCamp> bootCamps = FXCollections.observableList(bootcampService.listAllBootcamps());
        tableview.setItems(bootCamps);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("end"));


    }


}