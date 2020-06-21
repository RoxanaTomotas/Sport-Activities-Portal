package Controllers;

import Model.Participant;
import Model.Trainer;
import Services.ApplicationService;
import Services.UserService;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class ListTrainersController {
    @FXML
    private ChoiceBox<java.lang.String> trainer;

    @FXML
    private ChoiceBox date;

    private static String sport;

    private static Participant participant;

    private static Trainer trainerChosen;


    @FXML
    private void initialize(){
        UserService.injecltc(this);
        UserService.setTrainers(sport);
        trainer.getSelectionModel()
                .selectedItemProperty()
                .addListener( (ObservableValue<? extends java.lang.String> observable, java.lang.String oldValue, java.lang.String newValue) ->
                {
                    date.getItems().clear();
                    UserService.setDate(newValue);
                    setChosenTrainer(UserService.setByTrainer(newValue));
                });

    }

    private void setChosenTrainer(Trainer setByTrainer) {
        trainerChosen=setByTrainer;
    }

    public void onButtonCreateApplication() throws Exception {
        ApplicationService.addApplication(participant.getFirstName()+" "+participant.getLastName(),trainerChosen.getFirstName()+" "+trainerChosen.getLastName(),sport,date.getValue().toString(),2);
    }
    public static void setActiveParticipant(Participant p) {
        participant=p;
    }

    public static String setStringActiveParticipant(Participant p) {
        setActiveParticipant(p);
        return p+"";
    }

    public ChoiceBox getTrainer() {
        return trainer;
    }

    public ChoiceBox getDate() {
        return date;
    }

    public static void setSport(java.lang.String sprt) {
        sport=sprt;
    }

}