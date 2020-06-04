package Controllers;

import Model.User;
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
import javafx.scene.layout.Pane;
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
    private ChoiceBox<Object> choiceBox;
    @FXML
    public void initialize() {
        choiceBox.getItems().addAll("Admin","Participant","Trainer");
        choiceBox.setValue("Admin");
    }

    public void handleLoginAction() {

        System.out.println("Yeeee 1");
        try {
            System.out.println("Yeeee 2");

            UserService.checkLoginCredentials(usernameField.getText(),passwordField.getText(),choiceBox.getValue().toString());

            Stage stage = (Stage) loginB.getScene().getWindow();
            System.out.println("Yeeee 3");
            stage.close();
            System.out.println("Yeeee 4");

            if(((String)choiceBox.getValue()).equals("Admin")) {
                setAdministratorPage();
                System.out.println("Yeeee 5");
            }
            else
            if(((String)choiceBox.getValue()).equals("Trainer"))
                setTrainerPage();
            else {
                System.out.println("Yeeee participant");
                setParticipantPage();
            }
        } catch (Exception e) {
    //          text.setText(e.getMessage());
        }
    }

    public void setParticipantPage() throws IOException {
        System.out.println("Yeeee participant 1");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("Participant.fxml")));
        System.out.println("Yeeee participant 222");
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
        System.out.println("Yeeee 6");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("Administrator.fxml")));
        System.out.println("Yeeee 100");
        Stage stage = new Stage();
        stage.setTitle("Administrator");
        stage.setScene(new Scene(root, 600, 400));
        stage.setFullScreen(false);
        stage.showAndWait();
    }

}
