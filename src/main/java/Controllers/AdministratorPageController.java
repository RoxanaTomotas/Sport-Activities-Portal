package Controllers;

import Model.Application;
import Model.Date;
import Model.Participant;
import Services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.net.URL;

public class AdministratorPageController {

    @FXML
    private Tab tabRegistratinParticipants;
    @FXML
    private Tab tabRegistratinTrainers;
    @FXML
    private Tab tabContracts;
    @FXML
    private ScrollBar scrollBarContracts;
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
    private ChoiceBox<Object> choiceBoxYear;
    @FXML
    private TextField textFieldFirstName;
    @FXML
    private TextField textFieldLastName;
    @FXML
    private TextField textFieldAddress;
    @FXML
    private TextField textFieldUniversity;
    @FXML
    private TextField textFieldSpecialization;
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private CheckBox checkBoxMedicalApproval;
    @FXML
    private CheckBox checkBoxFitness;
    @FXML
    private CheckBox checkBoxAerobic;
    @FXML
    private CheckBox checkBoxJogging;
    @FXML
    private CheckBox checkBoxCulturism;
    @FXML
    private CheckBox checkBoxSwimming;
    @FXML
    private CheckBox checkBoxFotbal;
    @FXML
    private Button buttonParticipantRegister;
    @FXML
    private Button buttonTrainerRegister;
    @FXML
    private Button selectDates;
    @FXML
    private TextField textFieldFirstNameTrainer;
    @FXML
    private TextField textFieldLastNameTrainer;
    @FXML
    private TextField textFieldUniveristyTrainer;
    @FXML
    private TextField textFieldUsernameTrainer;
    @FXML
    private TextField textFieldPasswordTrainer;
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

    public void initialize() {
        choiceBoxYear.getItems().addAll("1","2","3","4","5","6","N/A");
        choiceBoxYear.setValue("N/A");
        initTableColumns();
        loadTableColumns();
    }

    /*********************************************************************************************
     *
     *
     *   This method has to check if the participant is not registered yet and to register him/her.
     *
     *
    * *******************************************************************************************/
    public void handleParticipantRegisterAction() {
        try {
            UserService.loadUsersFromFile();

            boolean healtApprovalLocal=false;

            if(checkBoxMedicalApproval.isSelected())
                healtApprovalLocal = true;

            UserService.addParticipant(textFieldFirstName.getText(),
                    textFieldLastName.getText(),
                    textFieldUsername.getText(),
                    textFieldPassword.getText(),
                    textFieldUniversity.getText(),
                    textFieldSpecialization.getText(),
                    textFieldID.getText(),
                    (String) choiceBoxYear.getValue(),
                    healtApprovalLocal);

            textFieldFirstName.clear();
            textFieldLastName.clear();
            textFieldAddress.clear();
            textFieldUsername.clear();
            textFieldPassword.clear();
            textFieldUniversity.clear();
            textFieldSpecialization.clear();
            textFieldID.clear();
            choiceBoxYear.setValue("N/A");
            checkBoxMedicalApproval.setSelected(false);
        } catch (Exception e) {
        }
    }


    /*********************************************************************************************
     *
     *
     *   This method has to check if the trainer is not registered yet and to register him/her.
     *
     *
     * *******************************************************************************************/
    public void handleTrainerRegisterAction() {

        try {
            String chosenSport="";
            List<Date> chosenDates = new ArrayList<Date>();

            if(checkBoxFitness.isSelected())
                chosenSport = "fitness";

            if(checkBoxAerobic.isSelected())
                chosenSport = "aerobic";

            if(checkBoxCulturism.isSelected())
                chosenSport = "culturism";

            if(checkBoxJogging.isSelected())
                chosenSport = "jogging";

            if(checkBoxSwimming.isSelected())
                chosenSport = "innot";

            if(checkBoxFotbal.isSelected())
                chosenSport = "fotbal";

            if(monday_8_30_10.isSelected())
            {
                chosenDates.add(new Date("luni", 8,10,30,0));
            }
            if(tuesday_8_30_10.isSelected())
            {
                chosenDates.add(new Date("marti", 8,10,30,0));
            }
            if(wednesday_8_30_10.isSelected())
            {
                chosenDates.add(new Date("miercuri", 8,10,30,0));
            }
            if(thursday_8_30_10.isSelected())
            {
                chosenDates.add(new Date("joi", 8,10,30,0));
            }
            if(friday_8_30_10.isSelected())
            {
                chosenDates.add(new Date("vineri", 8,10,30,0));
            }

            if(monday_10_30_12.isSelected())
            {
                chosenDates.add(new Date("luni", 10,12,30,0));
            }
            if(tuesday_10_30_12.isSelected())
            {
                chosenDates.add(new Date("marti", 10,12,30,0));
            }
            if(wednesday_10_30_12.isSelected())
            {
                chosenDates.add(new Date("miercuri", 10,12,30,0));
            }
            if(thursday_10_30_12.isSelected())
            {
                chosenDates.add(new Date("joi", 10,12,30,0));
            }
            if(friday_10_30_12.isSelected())
            {
                chosenDates.add(new Date("vineri", 10,12,30,0));
            }

            if(monday_12_30_14.isSelected())
            {
                chosenDates.add(new Date("luni", 12,14,30,0));
            }
            if(tuesday_12_30_14.isSelected())
            {
                chosenDates.add(new Date("marti", 12,14,30,0));
            }
            if(wednesday_12_30_14.isSelected())
            {
                chosenDates.add(new Date("miercuri", 12,14,30,0));
            }
            if(thursday_12_30_14.isSelected())
            {
                chosenDates.add(new Date("joi", 12,14,30,0));
            }
            if(friday_12_30_14.isSelected())
            {
                chosenDates.add(new Date("vineri", 12,14,30,0));
            }

            if(monday_14_30_16.isSelected())
            {
                chosenDates.add(new Date("luni", 14,16,30,0));
            }
            if(tuesday_14_30_16.isSelected())
            {
                chosenDates.add(new Date("marti", 14,16,30,0));
            }
            if(wednesday_14_30_16.isSelected())
            {
                chosenDates.add(new Date("miercuri", 14,16,30,0));
            }
            if(thursday_14_30_16.isSelected())
            {
                chosenDates.add(new Date("joi", 14,16,30,0));
            }
            if(friday_14_30_16.isSelected())
            {
                chosenDates.add(new Date("vineri", 14,16,30,0));
            }

            if(monday_16_30_18.isSelected())
            {
                chosenDates.add(new Date("luni", 16,18,30,0));
            }
            if(tuesday_16_30_18.isSelected())
            {
                chosenDates.add(new Date("marti", 16,18,30,0));
            }
            if(wednesday_16_30_18.isSelected())
            {
                chosenDates.add(new Date("miercuri", 16,18,30,0));
            }
            if(thursday_16_30_18.isSelected())
            {
                chosenDates.add(new Date("joi", 16,18,30,0));
            }
            if(friday_16_30_18.isSelected())
            {
                chosenDates.add(new Date("vineri", 16,18,30,0));
            }

            UserService.addTrainer(textFieldFirstNameTrainer.getText(),
                    textFieldLastNameTrainer.getText(),
                    textFieldUsernameTrainer.getText(),
                    textFieldPasswordTrainer.getText(),
                    textFieldUniveristyTrainer.getText(),
                    null,
                    chosenSport,
                    chosenDates);

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
        } catch (Exception e) {
        }
    }

    /*********************************************************************************************
     *
     *
     *   This method initializes the contracts table.
     *
     *
     * *******************************************************************************************/
    public void initTableColumns()
    {
        participantTableColumn.setCellValueFactory(new PropertyValueFactory<>("Participant"));
        trainerTableColumn.setCellValueFactory(new PropertyValueFactory<>("Trainer"));
        sportTableColumn.setCellValueFactory(new PropertyValueFactory<>("Sport"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("ChosenDate"));
        editableColumns();
    }


    /*********************************************************************************************
     *
     *
     *   This method has to show the existing contracts.
     *
     *
     * *******************************************************************************************/
    public void loadTableColumns()
    {
        ObservableList<Application> applicationTable = FXCollections.observableArrayList();
        List<Participant> participants;
        List<Application> participantApplication;

        participants = UserService.getParticipants();

        for (Participant participant: participants) {
            participantApplication = participant.getApplications();
            if(!(participantApplication.isEmpty()))
                for(Application application : participantApplication) {
                        System.out.println(application.getStatus() + application.getSport());
                        if (application.getStatus() == 2) //Accepted => Contract
                        {
                            applicationTable.add(application);
                        }
                }
        }

        tableView.setItems(applicationTable);
    }

    private void editableColumns(){

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

}
