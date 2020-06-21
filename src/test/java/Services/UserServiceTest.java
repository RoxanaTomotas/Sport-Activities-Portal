package Services;

import Exceptions.EmptyFieldException;
import Model.Participant;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {



    @BeforeClass
    public static void setupClass() {
        FileSystemService.APPLICATION_FOLDER = ".sportactivitiesportal";
        FileSystemService.initApplicationHomeDirIfNeeded();
    }

    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        UserService.addParticipant("ana", "maria","ana","ana","upt","cti","123","2",true);
    }

    @Test
    public void testLoadUserFromFile() throws IOException {
        UserService.loadUsersFromFile();
        assertNotNull(UserService.participants);
        UserService.loadUsersFromFile();
        assertNotNull(UserService.trainers);
        assertEquals(1, UserService.trainers.size());
    }

    @Test
    public void testAddParticipant() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addParticipant("ana", "maria","ana","ana","upt","cti","123","2",true);
        assertNotNull(UserService.participants);
        assertEquals(2, UserService.participants.size());
    }


    @Test
    public void testAddParticipantAlreadyExists() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addParticipant("ana", "maria","ana","ana","upt","cti","123","2",true);
        assertNotNull(UserService.participants);
        UserService.checkUsernameAlreadyExist("ane",1);
    }

    @Test(expected = EmptyFieldException.class)
    public void testEmtyField() throws Exception {
        UserService.checkEmptyField("","");
    }

    @Test
    public void testCheckLoginCredentials() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addParticipant("ana", "maria","ana","ana","upt","cti","123","2",true);
        assertNotNull(UserService.participants);
        UserService.checkLoginCredentials("ane","ane","Participant");
    }

    @Test
    public void testAddUserIsPersisted() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addParticipant("ana", "maria","ana","ana","upt","cti","123","2",true);
        List<Participant> users = new ObjectMapper().readValue(UserService.participants_PATH.toFile(), new TypeReference<List<Participant>>() {
        });
        assertNotNull(users);
        assertEquals(2, users.size());
    }


    @Test
    public void testPasswordEncoding() {
        assertNotEquals("pass1", UserService.encodePassword("user", "pass1"));
    }
}