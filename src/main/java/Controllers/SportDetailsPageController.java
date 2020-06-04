package Controllers;

import Model.Sport;
import Services.SportService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SportDetailsPageController {
    @FXML
    private ImageView sportImage;

    @FXML
    private Text sportDescription;

    @FXML
    private Button viewTrainersButton;

    @FXML
    private Button backButton;

    private static Sport sport;

    @FXML
    private void initialize() throws IOException {
        Image img=new Image(sport.getImage());
        sportImage.setImage(img);
        sportDescription.setText(sport.getName()+ "\n"+ sport.getDescription());
    }

    @FXML
    void viewTrainers(ActionEvent event) {
    }

    @FXML
    void toSportPageAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MoviesPage.fxml"));
        Stage stage=new Stage();
        stage.setTitle("Sports Page");
        stage.setScene(new Scene(root, 1366,768));
        SportService.setSportButtons();
        stage.show();
        Stage stage1 = (Stage) backButton.getScene().getWindow();
        stage1.close();
    }


    public static void setSport(Sport s) {
        sport = s;
    }
}
