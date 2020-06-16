package Controllers;

import Services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private Button buttonParticipantRegister;
    @FXML
    private Button buttonTrainerRegister;

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
            boolean healtApprovalLocal=false;

            if(checkBoxMedicalApproval.isSelected())
                healtApprovalLocal = true;

        /*    UserService.addParticipant(
                    textFieldFirstName.getText(),
                    textFieldLastName.getText(),
                    textFieldUsername.getText(),
                    textFieldPassword.getText(),
                    textFieldUniversity.getText(),
                    textFieldSpecialization.getText(),
                    textFieldID.getText(),
                    (String) choiceBoxYear.getValue(),
                    healtApprovalLocal,
                    null, );*/

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
/*    public void handleTrainerRegisterAction() {
        try {

            UserService.addTrainer(textFieldFirstName.getText(),
         /*   UserService.addTrainer(textFieldFirstName.getText(),
                    textFieldLastName.getText(),
                    textFieldUsername.getText(),
                    textFieldPassword.getText(),
                    textFieldUniversity.getText(),
                    null,
                    text);*/
            //text.setText("Account created successfully!");
        //} catch (Exception e) {
            //text.setText(e.getMessage());


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
