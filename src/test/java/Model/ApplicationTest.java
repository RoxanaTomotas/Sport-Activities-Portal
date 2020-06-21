package Model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ApplicationTest extends TestCase {
    private Application application;
    private Application copy;
    private final String participant = "Lidia Szmecskas";
    private final String trainer = "Roxana Tomotas";
    private final String sport = "Football";
    private final String choseDate = "Monday 13:00";
    private final int status = 1;

    @Before
    public void setUp() throws Exception {
        application=new Application(participant,trainer,sport,choseDate,status);
        copy=new Application(participant,trainer,sport,choseDate,status);
    }

    @Test
    public void testGetParticipant() {
        assertEquals(application.getParticipant(),participant);
    }

    @Test
    public void testGetTrainer() {
        assertEquals(application.getTrainer(),trainer);
    }

    @Test
    public void testGetSport() {
        assertEquals(application.getSport(),sport);
    }

    @Test
    public void testGetChosenDate() {
        assertEquals(application.getChosenDate(),choseDate);
    }

    @Test
    public void testGetStatus() {
        assertEquals(application.getStatus(),status);
    }

    @Test
    public void testTestEquals() {
        assertEquals(application,copy);
        assertNotEquals(application,null);
    }

    @Test
    public void testTestToString() {
        assertEquals(application.toString(),toString());
    }
}