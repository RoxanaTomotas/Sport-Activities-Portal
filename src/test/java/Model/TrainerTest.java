package Model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrainerTest {
    private Trainer trainer;
    private Trainer copy;
    private final String firstName = "ion";
    private final String lastName = "george";
    private final String username = "ion";
    private final String password = "ion";
    private final String university = "UPT";
    private final String sport = "Bodybuilding";
    private final Date date=new Date("monday",14,15,0,0);
    private final Application application=new Application("ana","buzatu","Fitness","friday 13:0-14:0",0);

    @Before
    public void setUp() throws Exception {
        trainer=new Trainer(firstName,lastName,username,password,university,(List<Application>) application,sport,(List<Date>) date);
    }

    @Test
    public void getFirstName() {
        assertEquals(trainer.getFirstName(),firstName);
    }

    @Test
    public void getLastName() {
        assertEquals(trainer.getLastName(),lastName);
    }

    @Test
    public void getUsername() {
        assertEquals(trainer.getUsername(),username);
    }

    @Test
    public void getPassword() {
        assertEquals(trainer.getPassword(),password);
    }

    @Test
    public void getUniversity() {
        assertEquals(trainer.getUniversity(),university);
    }

    @Test
    public void getSports() {
        assertEquals(trainer.getSports(),sport);
    }

    @Test
    public void testEquals() {
        assertEquals(trainer,copy);
        assertNotEquals(trainer,null);
    }

    @Test
    public void testToString() {
        assertEquals(trainer.toString(),toString());
    }
}