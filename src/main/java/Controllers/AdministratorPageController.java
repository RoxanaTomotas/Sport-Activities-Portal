package Controllers;

import Model.Application;
import Model.Date;
import Services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javax.swing.*;
import java.util.Objects;

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
    private TextField textFieldFirstNameTrainer;
    @FXML
    private TextField textFieldLastNameTrainer;
    @FXML
    private TextField textFieldUniveristyTrainer;
    @FXML
    private TextField textFieldUsernameTrainer;
    @FXML
    private TextField textFieldPasswordTrainer;

    public void initialize() {
        choiceBoxYear.getItems().addAll("1","2","3","4","5","6","N/A");
        choiceBoxYear.setValue("N/A");
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
            //text.setText("Account created successfully!");
        } catch (Exception e) {
            //text.setText(e.getMessage());
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
            boolean fitnessTrainer=false;
            boolean aerobicTrainer=false;
            boolean fotbalTrainer=false;
            boolean joggingTrainer=false;
            boolean culturismTrainer=false;
            boolean swimmingTrainer=false;

            //List<Sport> trainerSports = new ArrayList<Sport>();

            if(checkBoxFitness.isSelected())
                fitnessTrainer = true;

            if(checkBoxAerobic.isSelected())
                aerobicTrainer = true;

            if(checkBoxCulturism.isSelected())
                culturismTrainer = true;

            if(checkBoxJogging.isSelected())
                joggingTrainer = true;

            if(checkBoxSwimming.isSelected())
                swimmingTrainer = true;

            if(checkBoxFotbal.isSelected())
                fotbalTrainer = true;

            if(fitnessTrainer == true)

                System.out.println("addParticipant-9");

            UserService.addTrainer(textFieldFirstNameTrainer.getText(),
                    textFieldLastNameTrainer.getText(),
                    textFieldUsernameTrainer.getText(),
                    textFieldPasswordTrainer.getText(),
                    textFieldUniveristyTrainer.getText(),
                    null ,
                    "",
                    null);
            System.out.println("Scrie in fisier1");
            //text.setText("Account created successfully!");
        } catch (Exception e) {
            //text.setText(e.getMessage());
        }
    }

    /*********************************************************************************************
     *
     *
     *   This method has to show the existing contracts.
     *
     *
     * *******************************************************************************************/
    void manageContracts()
    {

    }
}
