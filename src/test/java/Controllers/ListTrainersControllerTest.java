package Controllers;

import Model.Application;
import Model.Date;
import Model.Participant;
import Model.Trainer;
import Services.ApplicationService;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListTrainersControllerTest {
    @FXML
    private ChoiceBox<String> trainer;
    @FXML
    private ChoiceBox date;
    private static String sport="Fitness";
    private static String participant1="ana martin";
    private static String trainerChosen="dan chirila";
    private static String date1="monday 9:0-10:0";
    private static Participant participant2;
    private static int status=0;
    private static Application application=new Application("marisa daneti","chirila cel mare","Fitness","monday 8:0-9:0",0);


    @Before
    public void setUp() throws Exception {
        trainer.getItems().addAll("Admin");
        trainer.setValue("Admin");
        date.getItems().addAll("monday 12:0-13:0");
        date.setValue("monday 12:0-13:0");
        participant2=new Participant("ana","parastasie","ana","ana","UPT","AC","123","2",true,(List<Application>) application);
    }

    @Test
    public void onButtonCreateApplication() throws Exception {
        ApplicationService.addApplication(participant1,trainerChosen,sport,date1,status);
    }

    @Test
    public void setActiveParticipant() {
        Application.getParticipant();
        assertEquals(participant1,ListTrainersController.setStringActiveParticipant(participant2));
    }

}