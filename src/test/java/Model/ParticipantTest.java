package Model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public abstract class ParticipantTest {
    private Participant participant;
    private Participant copy;
    private final String firstName = "ion";
    private final String lastName = "george";
    private final String username = "ion";
    private final String password = "ion";
    private final String university = "UPT";
    private final String specialization = "AC";
    private final String uniqueID = "123";
    private final String studyYear = "2";
    private final boolean healthAppropval = true;
    private final Application application=new Application("ana","buzatu","Fitness","friday 13:0-14:0",0);

    @Before
    public void setUp() throws Exception {
        participant=new Participant(firstName,lastName,username,password,university,specialization,uniqueID,studyYear,healthAppropval, (List<Application>) application);
        copy=new Participant(firstName,lastName,username,password,university,specialization,uniqueID,studyYear,healthAppropval, (List<Application>) application);
    }

    @Test
    public void setApplication() {
        participant.setApplications((List<Application>) application);
    }


    @Test
    public void getFirstName() {
        assertEquals(participant.getFirstName(),firstName);
    }

    @Test
    public void getLastName() {
        assertEquals(participant.getLastName(),lastName);
    }

    @Test
    public void getUsername() {
        assertEquals(participant.getUsername(),username);
    }

    @Test
    public void getPassword() {
        assertEquals(participant.getPassword(),password);
    }

    @Test
    public void getUniversity() {
        assertEquals(participant.getUniversity(),university);
    }

    @Test
    public void getSpecialization() {
        assertEquals(participant.getSpecialization(),specialization);
    }

    @Test
    public void getUniqueID() {
        assertEquals(participant.getUniqueID(),uniqueID);
    }

    @Test
    public void getStudyYear() {
        assertEquals(participant.getStudyYear(),studyYear);
    }


    @Test
    public void testEquals() {
        assertEquals(participant,copy);
        assertNotEquals(participant,null);
    }

    @Test
    public void testToString() {
        assertEquals(participant.toString(),toString());
    }
}
