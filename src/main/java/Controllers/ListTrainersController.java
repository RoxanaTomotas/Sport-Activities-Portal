package Controllers;

import Services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class ListTrainersController {
    @FXML
    private ChoiceBox trainer;

    @FXML
    private ChoiceBox date;
    @FXML
    private Button createContract;
    private static String sport;

    @FXML
    private void initialize(){
        UserService.injecltc(this);
        UserService.setTrainers(sport);
    }


    public ChoiceBox getTrainer() {
        return trainer;
    }

    public ChoiceBox getDate() {
        return date;
    }

    public static void setSport(String sprt) {
        sport=sprt;
    }

}
