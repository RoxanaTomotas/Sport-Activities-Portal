package Services;

import Exceptions.CouldNotWriteUsersException;
import Model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ApplicationService {
    private static List<Application> applications=new ArrayList<>();

    private static final Path applications_PATH = FileSystemService.getPathToFile("config", "applications.json");

    public static void loadApplicationsFromFile() throws IOException {

        if (!Files.exists(applications_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(UserService.class.getClassLoader().getResource("applications.json")), applications_PATH.toFile());
        }

        ObjectMapper objectMapperparticipants = new ObjectMapper();

        applications = objectMapperparticipants.readValue(applications_PATH.toFile(), new TypeReference<List<Application>>() {
        });
    }

    public static void addApplication(String participant, String trainer, String sport, java.lang.String chosenDate, int status)throws Exception {

        applications.add(new Application(participant,  trainer,  sport,  chosenDate, status ));
        persistApplication();
        UserService.sentParticiapnt(participant,new Application(participant,  trainer,  sport,  chosenDate, status ));
    }

    private static void persistApplication() {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(applications_PATH.toFile(), applications);

        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }


}
