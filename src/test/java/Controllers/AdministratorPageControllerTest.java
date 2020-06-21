package Controllers;

import Model.Application;
import Model.Date;
import Model.Participant;
import Model.Trainer;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class AdministratorPageControllerTest {

    final List<Application> applicationList = new ArrayList<Application>();
    final List<Date> dates = new ArrayList<Date>();


    final Participant participant = new Participant("Tomotas",
            "Roxana",
            "roxanausername",
            "roxanapassword",
            "UPT",
            "CTI",
            "25",
            "2",
            true,
            applicationList
    );

    final Trainer trainer = new Trainer("Szmecskas",
            "Lidia",
            "lidiausername",
            "lidiapassword",
            "UPT",
            applicationList,
            "fitness",
            dates
    );

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void initialize() {
    }

    @Test
    public void handleParticipantRegisterAction() {

        assertEquals("Tomotas", participant.getFirstName());
        assertEquals("Roxana", participant.getLastName());
        assertEquals("roxanausername", participant.getUsername());
        assertEquals("roxanapassword", participant.getPassword());
        assertEquals("UPT", participant.getUniversity());
        assertEquals("CTI", participant.getSpecialization());
        assertEquals("25", participant.getUniqueID());
        assertEquals("2", participant.getStudyYear());
    }

    @Test
    public void handleTrainerRegisterAction() {

        final Date date = new Date("luni",8,10,20,40);
        dates.add(date);

        assertEquals("Szmecskas", trainer.getFirstName());
        assertEquals("Lidia", trainer.getLastName());
        assertEquals("lidiausername", trainer.getUsername());
        assertEquals("lidiapassword", trainer.getPassword());
        assertEquals("UPT", trainer.getUniversity());
        assertEquals("fitness", trainer.getSports());
        assertEquals(dates, trainer.getDates());
    }

    @Test
    public void initTableColumns() {
    }

    @Test
    public void loadTableColumns() {
    }
}