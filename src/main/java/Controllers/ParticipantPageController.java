package Controllers;

import Services.UserService;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import java.io.IOException;

public class ParticipantPageController {

    @FXML
    private TilePane tilePane;
    @FXML
    private  ScrollPane scrollPane;

    @FXML
    private void initialize() {
        UserService.injectppc(this);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        tilePane.setHgap(30);
        tilePane.setVgap(30);
    }


    public void goToFitness() throws IOException {
        ListTrainersController.setSport("Fitness");
        Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage = new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void goToFootball() throws IOException {
        ListTrainersController.setSport("Football");
        Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage = new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void goToSwim() throws IOException {
        ListTrainersController.setSport("Swim");
        Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage = new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void goToBodybuilding() throws IOException {
        ListTrainersController.setSport("Bodybuilding");
        Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage = new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void goToAerobic() throws IOException {
        ListTrainersController.setSport("Aerobic");
        Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage = new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void goToJogging() throws IOException {
        ListTrainersController.setSport("Jogging");
        Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage = new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }


    public TilePane getTilePane() {
        return tilePane;
    }


    public void addApplication(Event event) {
        UserService.addApplicationAdmin();
    }
}