package Controllers;

import Exceptions.EmptyFieldException;
import Services.FileSystemService;
import Services.UserService;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

public class LoginPageControllerTest {

    public static final String TEST_USER = "user";
    public static final String TEST_PASSWORD = "pass";
    private LoginPageController ltc;

    @BeforeClass
    public static void setupClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-cinema";
        FileSystemService.initApplicationHomeDirIfNeeded();
        UserService.loadUsersFromFile();
    }

    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        UserService.loadUsersFromFile();

        ltc.usernameField = new TextField();
        ltc.passwordField = new PasswordField();
        ltc.loginB= new Button();
        ltc.text= new Text();

        ltc.passwordField.setText(TEST_PASSWORD);
        ltc.usernameField.setText(TEST_USER);
    }


    @Test
    public void testLoginCorrectCredentialsForUser() throws EmptyFieldException {
        ltc.handleLoginAction();
        assertNotEquals("Incorrect credentials",ltc.text.getText());
    }

    @Test
    public void testLoginCorrectCredentialsForAdmin() throws EmptyFieldException {
        ltc.usernameField.setText("Admin");
        ltc.passwordField.setText("Admin");
        ltc.choiceBox.setValue("Admin");
        ltc.handleLoginAction();
        assertNotEquals("Incorrect credentials",ltc.text.getText());
    }

    @Test
    public void testLoginIncorrectCredentials() throws EmptyFieldException {
        ltc.handleLoginAction();
        assertEquals("Incorrect credentials",ltc.text.getText());
    }
}
