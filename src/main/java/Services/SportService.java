package Services;

import Controllers.SportDetailsPageController;
import Controllers.ParticipantPageController;
import Model.Sport;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SportService {
    private  static ParticipantPageController mpc;
    private  static SportDetailsPageController mdpc;
    private static List<Sport> sports=new ArrayList<>();
    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "movies.json");
    private static List<Button> sportButton=new ArrayList<>();



    public static void loadSportsFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(SportService.class.getClassLoader().getResource("movies.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        sports = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<Sport>>() {
        });
    }

    public static void injectmp(ParticipantPageController u) {
        mpc= u;
    }
    public static void injectmdpc(SportDetailsPageController u) {
        mdpc= u;
    }

    public static ImageView DesignImage(String url){

        Image image= new Image(url);
        ImageView imageView= new ImageView(image);
        imageView.setFitWidth(260);
        imageView.setFitHeight(370);
        imageView.setStyle("-fx-padding-top: 10px;");
        Rectangle clip=new Rectangle();
        clip.setWidth(260);
        clip.setHeight(370);

        clip.setArcWidth(40);
        clip.setArcHeight(40);

        clip.setStroke(Color.BLACK);
        imageView.setClip(clip);


        return  imageView;
    }
    public static Button setSport(Sport sport){

        ImageView imageView = DesignImage(sport.getImage());

        Button button=new Button("",imageView);
        button.setPrefSize(285,390);
        button.setStyle("-fx-border-color: transparent;-fx-background-color: transparent; ");
        button.setTooltip(new Tooltip(sport.getName()));
        button.setOnAction(e -> {
            try {
                setSportDetails(sport);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        return button;
    }

    private static void setSportDetails(Sport sport) throws IOException {
        SportDetailsPageController.setSport(sport);

        Parent root = FXMLLoader.load(SportService.class.getClassLoader().getResource("MovieDetailsPage.fxml"));
        Stage stage=new Stage();
        stage.setTitle("Movies Details Page");
        stage.setScene(new Scene(root, 1366,768));

        stage.show();
        Stage stage1 = (Stage) mpc.getTilePane().getScene().getWindow();
        stage1.close();
    }

    public static void createSportButtons(){
        for (Sport sport : sports) {
            sportButton.add(setSport(sport));

        }
    }

    public static void setSportButtons(){

        for (Button button : sportButton) {

            mpc.getTilePane().getChildren().add(button);

        }
    }

}
