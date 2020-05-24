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

            UserService.checkLoginCredentials(usernameField.getText(),passwordField.getText());

            Stage stage = (Stage) loginB.getScene().getWindow();
            System.out.println("Yeeee 3");
            stage.close();
            System.out.println("Yeeee 4");

            if(Objects.equals(choiceBox.toString(),"Admin")) {
                setAdministratorPage();
                System.out.println("Yeeee 5");
            }
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("ParticipantPage.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ParticipantPage");
        stage.setScene(new Scene(root, 600,400));
        stage.setFullScreen(false);
        stage.show();
    }

    public void setTrainerPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("TrainerPage.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Trainer");
        stage.setScene(new Scene(root, 600,400));
        stage.setFullScreen(false);
        stage.show();
    }

    public void setAdministratorPage() throws IOException {
        System.out.println("Yeeee 6");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/Administrator.fxml")));

        Stage stage = new Stage();
        stage.setTitle("Administrator");
        stage.setScene(new Scene(root, 600, 400));
        stage.setFullScreen(false);
        stage.showAndWait();
    }

    public void onLogin(ActionEvent actionEvent) {
        System.out.println("Yeeee");
    }
}
