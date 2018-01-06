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
import org.academiadecodigo.bootcamp.service.BootcampService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.UserService;
import org.academiadecodigo.bootcamp.utils.Gender;
import org.academiadecodigo.bootcamp.utils.Security;

import java.util.Calendar;
import java.util.Date;
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


        createbootcamps();


        fillBootcampTableCells();


    }

    //THIS METHOD IS TO DELETE LATER
    private void createbootcamps() {


        bootcampService.addBootCamp(new BootCamp(1,"location1", new GregorianCalendar(2018, 2,5), new GregorianCalendar(2018, 5, 8)));
        bootcampService.addBootCamp(new BootCamp(2,"location2", new GregorianCalendar(2018, 3,5), new GregorianCalendar(2018, 5, 9)));
        bootcampService.addBootCamp(new BootCamp(3,"location3", new GregorianCalendar(2018, 4,5), new GregorianCalendar(2018, 5, 10)));
        bootcampService.addBootCamp(new BootCamp(4,"location4", new GregorianCalendar(2018, 5,5), new GregorianCalendar(2018, 5, 11)));



        bootcampService.addCodeCaddet(bootcampService.findById(1),new CodeCadet(new User("b", Security.getHash("b"),
                "b@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));

        bootcampService.addCodeCaddet(bootcampService.findById(1),new CodeCadet(new User("c", Security.getHash("b"),
                "c@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(2),new CodeCadet(new User("d", Security.getHash("b"),
                "d@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(2),new CodeCadet(new User("e", Security.getHash("b"),
                "e@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(3),new CodeCadet(new User("f", Security.getHash("b"),
                "f@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(3),new CodeCadet(new User("g", Security.getHash("b"),
                "g@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(4),new CodeCadet(new User("h", Security.getHash("b"),
                "h@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(4),new CodeCadet(new User("i", Security.getHash("b"),
                "i@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(1),new CodeCadet(new User("j", Security.getHash("b"),
                "j@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(2),new CodeCadet(new User("k", Security.getHash("b"),
                "k@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
        bootcampService.addCodeCaddet(bootcampService.findById(3),new CodeCadet(new User("l", Security.getHash("b"),
                "l@a.com"), Gender.MALE, "address","city", "919191919", new GregorianCalendar(1996, 2,1)));
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