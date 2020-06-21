package Services;

import Model.Application;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static Services.ApplicationService.persistApplication;
import static org.junit.Assert.*;

public class ApplicationServiceTest {
    private Application application;
    private final String participant="ama";
    private static List<Application> applications=new ArrayList<>();
    private static final Path applications_PATH = FileSystemService.getPathToFile("C:\\Users\\Lidia\\gitsport\\Sport-Activities-Portal\\src\\main\\resources", "applications.json");

    @Before
    public void setUp() throws Exception {
        ApplicationService.loadApplicationsFromFile();
        application=new Application("ana","chirila","Fitness","monday 10:0-11:0",0);
    }

    @Test
    public void addApplication() {
        applications.add(application);
        persistApplication();
        UserService.sentParticiapnt(participant,application);
    }
}