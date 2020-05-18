package Controllers;

import Services.UserService;
import javafx.event.ActionEvent;
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
import java.util.Objects;
public class LoginPageController {

    @FXML
    private Button loginB;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text text;
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    public void initialize() {
        choiceBox.getItems().addAll("Admin","Participant","Trainer");
        choiceBox.setValue("Admin");
    }


    public void handleLoginAction() {
        try {
            UserService.checkLoginCredentials(usernameField.getText(),passwordField.getText());
            Stage stage = (Stage) loginB.getScene().getWindow();
            stage.close();
            if(Objects.equals(choiceBox.toString(),"Admin"))
                setAdministratorPage();
            else
            if(Objects.equals(choiceBox.toString(),"Trainer"))
                setTrainerPage();
            else
                setParticipantPage();
        } catch (Exception e) {
            text.setText(e.getMessage());
        }
    }

    public void setParticipantPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().  getResource("Participantpage.fxml"));
        Stage stage=new Stage();
        stage.setTitle("ParticipantPage");
        stage.setScene(new Scene(root, 600,400));
        stage.setFullScreen(true);
        stage.show();
    }

    public void setTrainerPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("TrainerrPage.fxml"));
        Stage stage=new Stage();
        stage.setTitle("Trainer");
        stage.setScene(new Scene(root, 600,400));
        stage.setFullScreen(true);
        stage.show();
    }

    public void setAdministratorPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AdministratorPage.fxml"));
        Stage stage=new Stage();
        stage.setTitle("Administrator");
        stage.setScene(new Scene(root, 600,400));
        stage.setFullScreen(true);
        stage.show();
    }

    public void onLogin(ActionEvent actionEvent) {
        System.out.println("Yeeee");
    }
}
