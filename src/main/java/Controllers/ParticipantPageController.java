package Controllers;

import Services.SportService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class ParticipantPageController {
    @FXML
    private TilePane tilePane;

    @FXML
    private Button Fitness;
    public void goToFitness() {

    }
  //  private void initialize(){
  //      SportService.injectmp(this);
 //   }

    public TilePane getTilePane() {
        return tilePane;
    }
}
