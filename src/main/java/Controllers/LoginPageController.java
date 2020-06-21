package Controllers;

import Exceptions.EmptyFieldException;
import Services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginPageController {

    public static String username;
    @FXML
    public Button loginB;
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Text text;
    @FXML
    public ChoiceBox<Object> choiceBox;

    public void initialize() {
        choiceBox.getItems().addAll("Admin","Participant","Trainer");
        choiceBox.setValue("Admin");
    }

    public void handleLoginAction() throws EmptyFieldException{

        try {
            UserService.checkLoginCredentials(usernameField.getText(),passwordField.getText(),choiceBox.getValue().toString());

            Stage stage = (Stage) loginB.getScene().getWindow();
            stage.close();

            if(((String)choiceBox.getValue()).equals("Admin")) {
                if(usernameField.getText().equals("Admin") && passwordField.getText().equals("Admin")){
                    setAdministratorPage();
                }
                else
                    throw new EmptyFieldException();
            }
            else
            if(((String)choiceBox.getValue()).equals("Trainer")) {
                username = usernameField.getText();
                setTrainerPage();
            }
            else {
                setParticipantPage();
            }
        } catch (Exception e) {
            //          text.setText(e.getMessage());
        }
    }

    public static void setParticipantPage() throws IOException {
        Parent root= FXMLLoader.load((LoginPageController.class.getClassLoader().getResource("Participant.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ParticipantPage");
        stage.setScene(new Scene(root, 600,400));
        stage.setFullScreen(false);
        stage.show();
    }

    public void setTrainerPage() throws IOException {
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("Trainer.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Trainer");
        stage.setScene(new Scene(root, 600,400));
        stage.setFullScreen(false);
        stage.show();
    }

    public void setAdministratorPage() throws IOException {
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("Administrator.fxml")));
        Stage stage = new Stage();
        stage.setTitle("Administrator");
        stage.setScene(new Scene(root, 600, 400));
        stage.setFullScreen(false);
        stage.showAndWait();
    }

}