package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.text.html.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TrainerPageController implements Initializable {

    ObservableList list= FXCollections.observableArrayList();


    @FXML
    private ListView sportList;

    public List<Sport> sports  = new ArrayList<Sport>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadData(){

        list.removeAll(list);

        list.addAll(sports);

    }
}
