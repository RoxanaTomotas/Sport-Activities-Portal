package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

public class ParticipantPageController {
    @FXML
    private TilePane tilePane;
    @FXML
    private Button Fitness;

    public void goToFitness() throws IOException {
        ListTrainersController.setSport("Fitness");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

}
