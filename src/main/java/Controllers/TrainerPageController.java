package Controllers;

import Model.Application;
import Model.Date;
import Model.Participant;
import Model.Trainer;
import Services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.swing.text.html.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TrainerPageController implements Initializable {

    @FXML
    private CheckBox monday_8_30_10;
    @FXML
    private CheckBox tuesday_8_30_10;
    @FXML
    private CheckBox wednesday_8_30_10;
    @FXML
    private CheckBox thursday_8_30_10;
    @FXML
    private CheckBox friday_8_30_10;
    @FXML
    private CheckBox monday_10_30_12;
    @FXML
    private CheckBox tuesday_10_30_12;
    @FXML
    private CheckBox wednesday_10_30_12;
    @FXML
    private CheckBox thursday_10_30_12;
    @FXML
    private CheckBox friday_10_30_12;
    @FXML
    private CheckBox monday_12_30_14;
    @FXML
    private CheckBox tuesday_12_30_14;
    @FXML
    private CheckBox wednesday_12_30_14;
    @FXML
    private CheckBox thursday_12_30_14;
    @FXML
    private CheckBox friday_12_30_14;
    @FXML
    private CheckBox monday_14_30_16;
    @FXML
    private CheckBox tuesday_14_30_16;
    @FXML
    private CheckBox wednesday_14_30_16;
    @FXML
    private CheckBox thursday_14_30_16;
    @FXML
    private CheckBox friday_14_30_16;
    @FXML
    private CheckBox monday_16_30_18;
    @FXML
    private CheckBox tuesday_16_30_18;
    @FXML
    private CheckBox wednesday_16_30_18;
    @FXML
    private CheckBox thursday_16_30_18;
    @FXML
    private CheckBox friday_16_30_18;
    @FXML
    private TableView<Application> tableView;
    @FXML
    private TableColumn<Application, String> participantTableColumn;
    @FXML
    private TableColumn<Application, String> trainerTableColumn;
    @FXML
    private TableColumn<Application, String> sportTableColumn;
    @FXML
    private TableColumn<Application, String> dateTableColumn;
    @FXML
    private TableColumn<Application, String> statusTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTableColumns();
        loadTableColumns();
    }

    /*********************************************************************************************
     *
     *
     *   This method updates the trainer's dates.
     *
     *
     * *******************************************************************************************/
    public void updateSportDates(){

        List<Date> chosenDates = new ArrayList<Date>();
        List<Trainer> trainersList;

        if(monday_8_30_10.isSelected())
        {
            chosenDates.add(new Date("luni", 8, 10, 30, 0));
        }
                if(tuesday_8_30_10.isSelected())

        {
            chosenDates.add(new Date("marti", 8, 10, 30, 0));
        }
                if(wednesday_8_30_10.isSelected())

        {
            chosenDates.add(new Date("miercuri", 8, 10, 30, 0));
        }
                if(thursday_8_30_10.isSelected())

        {
            chosenDates.add(new Date("joi", 8, 10, 30, 0));
        }
                if(friday_8_30_10.isSelected())

        {
            chosenDates.add(new Date("vineri", 8, 10, 30, 0));
        }

                if(monday_10_30_12.isSelected())

        {
            chosenDates.add(new Date("luni", 10, 12, 30, 0));
        }
                if(tuesday_10_30_12.isSelected())

        {
            chosenDates.add(new Date("marti", 10, 12, 30, 0));
        }
                if(wednesday_10_30_12.isSelected())

        {
            chosenDates.add(new Date("miercuri", 10, 12, 30, 0));
        }
                if(thursday_10_30_12.isSelected())

        {
            chosenDates.add(new Date("joi", 10, 12, 30, 0));
        }
                if(friday_10_30_12.isSelected())

        {
            chosenDates.add(new Date("vineri", 10, 12, 30, 0));
        }

                if(monday_12_30_14.isSelected())

        {
            chosenDates.add(new Date("luni", 12, 14, 30, 0));
        }
                if(tuesday_12_30_14.isSelected())

        {
            chosenDates.add(new Date("marti", 12, 14, 30, 0));
        }
                if(wednesday_12_30_14.isSelected())

        {
            chosenDates.add(new Date("miercuri", 12, 14, 30, 0));
        }
                if(thursday_12_30_14.isSelected())

        {
            chosenDates.add(new Date("joi", 12, 14, 30, 0));
        }
                if(friday_12_30_14.isSelected())

        {
            chosenDates.add(new Date("vineri", 12, 14, 30, 0));
        }

                if(monday_14_30_16.isSelected())

        {
            chosenDates.add(new Date("luni", 14, 16, 30, 0));
        }
                if(tuesday_14_30_16.isSelected())

        {
            chosenDates.add(new Date("marti", 14, 16, 30, 0));
        }
                if(wednesday_14_30_16.isSelected())

        {
            chosenDates.add(new Date("miercuri", 14, 16, 30, 0));
        }
                if(thursday_14_30_16.isSelected())

        {
            chosenDates.add(new Date("joi", 14, 16, 30, 0));
        }
                if(friday_14_30_16.isSelected())

        {
            chosenDates.add(new Date("vineri", 14, 16, 30, 0));
        }

                if(monday_16_30_18.isSelected())

        {
            chosenDates.add(new Date("luni", 16, 18, 30, 0));
        }
                if(tuesday_16_30_18.isSelected())

        {
            chosenDates.add(new Date("marti", 16, 18, 30, 0));
        }
                if(wednesday_16_30_18.isSelected())

        {
            chosenDates.add(new Date("miercuri", 16, 18, 30, 0));
        }
                if(thursday_16_30_18.isSelected())

        {
            chosenDates.add(new Date("joi", 16, 18, 30, 0));
        }
                if(friday_16_30_18.isSelected())

        {
            chosenDates.add(new Date("vineri", 16, 18, 30, 0));
        }

        monday_8_30_10.setSelected(false);
        tuesday_8_30_10.setSelected(false);
        wednesday_8_30_10.setSelected(false);
        thursday_8_30_10.setSelected(false);
        friday_8_30_10.setSelected(false);
        monday_10_30_12.setSelected(false);
        tuesday_10_30_12.setSelected(false);
        wednesday_10_30_12.setSelected(false);
        thursday_10_30_12.setSelected(false);
        friday_10_30_12.setSelected(false);
        monday_12_30_14.setSelected(false);
        tuesday_12_30_14.setSelected(false);
        wednesday_12_30_14.setSelected(false);
        thursday_12_30_14.setSelected(false);
        friday_12_30_14.setSelected(false);
        monday_14_30_16.setSelected(false);
        tuesday_14_30_16.setSelected(false);
        wednesday_14_30_16.setSelected(false);
        thursday_14_30_16.setSelected(false);
        friday_14_30_16.setSelected(false);
        monday_16_30_18.setSelected(false);
        tuesday_16_30_18.setSelected(false);
        wednesday_16_30_18.setSelected(false);
        thursday_16_30_18.setSelected(false);
        friday_16_30_18.setSelected(false);

         trainersList = UserService.getTrainers();
         for (Trainer trainer : trainersList) {
             if (LoginPageController.username.equals(trainer.getUsername())) {
                 if (!(chosenDates.isEmpty()))
                     trainer.setDates(chosenDates);
             }
         }
        }

    /*********************************************************************************************
     *
     *
     *   This method initializes the applications table.
     *
     *
     * *******************************************************************************************/
    public void initTableColumns() {
        participantTableColumn.setCellValueFactory(new PropertyValueFactory<>("Participant"));
        trainerTableColumn.setCellValueFactory(new PropertyValueFactory<>("Trainer"));
        sportTableColumn.setCellValueFactory(new PropertyValueFactory<>("Sport"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("ChosenDate"));

        editableColumns();
    }


    /*********************************************************************************************
     *
     *
     *   This method has to show the existing applications.
     *
     *
     * *******************************************************************************************/
    public void loadTableColumns() {
        ObservableList<Application> applicationTable = FXCollections.observableArrayList();
        List<Participant> participants;
        List<Application> participantApplication;

        participants = UserService.getParticipants();

        for (Participant participant: participants) {
            participantApplication = participant.getApplications();
            if(!(participantApplication.isEmpty()))
                for(Application application : participantApplication) {
                    if (application.getTrainer().equals(LoginPageController.username) && application.getStatus() == 2) //Status = Pending
                    {
                        applicationTable.add(application);
                    }
                }
        }
        tableView.setItems(applicationTable);
    }

    /*********************************************************************************************
     *
     *
     *   This method makes the columns of the table view editable.
     *
     *
     * *******************************************************************************************/
    private void editableColumns(){

        tableView.setEditable(true);
        statusTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        statusTableColumn.setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setStatus(Integer.parseInt(e.getNewValue())));

        participantTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        participantTableColumn.setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setParticipant(e.getNewValue()));

        trainerTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        trainerTableColumn.setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setTrainer(e.getNewValue()));

        sportTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sportTableColumn.setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setSport(e.getNewValue()));

        dateTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateTableColumn.setOnEditCommit(e ->
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setChosenDate(e.getNewValue()));
    }

    /*********************************************************************************************
     *
     *
     *   This method changes the application's status.
     *
     *
     * *******************************************************************************************/
    public void changeApplicationStatus(TableColumn.CellEditEvent edittedCell){

        Application applicationSelected = tableView.getSelectionModel().getSelectedItem();
        applicationSelected.setStatus(Integer.parseInt((String) edittedCell.getNewValue()));
    }

}
