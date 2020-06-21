package Controllers;

import Model.Application;
import Services.UserService;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParticipantPageControllerTest {
    private final Application application=new Application("ana","buzatu","Fitness","friday 13:0-14:0",0);
    public final GridPane gridPane=new GridPane();

    @Test
    public void addApplication() {
        UserService.setGridPane(gridPane);
        UserService.addApplicationAdmin();
    }
}