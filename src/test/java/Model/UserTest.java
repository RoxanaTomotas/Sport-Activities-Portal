package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user;
    private User copy;
    private final String username = "ion";
    private final String password = "ion";
    private final String role = "participant";

    @Before
    public void setUp() throws Exception {
        user=new User(username,password,role);
        copy=new User(username,password,role);
    }

    @Test
    public void getUsername() {
        assertEquals(user.getUsername(),username);
    }

    @Test
    public void getPassword() {
        assertEquals(user.getPassword(),password);
    }

    @Test
    public void getRole() {
        assertEquals(user.getRole(),role);
    }

    @Test
    public void testEquals() {
        assertEquals(user,copy);
        assertNotEquals(user, null);
    }
}