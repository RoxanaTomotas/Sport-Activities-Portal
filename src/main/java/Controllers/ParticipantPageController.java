package Controllers;

import Model.Application;
import Model.Participant;
import Services.UserService;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class ParticipantPageController {

    public void goToFitness() throws IOException {
        ListTrainersController.setSport("Fitness");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

    public void goToFootball() throws IOException {
        ListTrainersController.setSport("Football");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

    public void goToSwim() throws IOException {
        ListTrainersController.setSport("Swim");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

    public void goToBodybuilding() throws IOException {
        ListTrainersController.setSport("Bodybuilding");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

    public void goToAerobic() throws IOException {
        ListTrainersController.setSport("Aerobic");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

    public void goToJogging() throws IOException {
        ListTrainersController.setSport("Jogging");
        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("ListTrainers.fxml")));
        Stage stage=new Stage();
        stage.setTitle("ListOfTrainerstPage");
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

    private static GridPane addApplication(Application application) {
        GridPane pane=new GridPane();
        pane.setPrefWidth(600);
        pane.setPrefHeight(300);
        pane.setStyle("-fx-background-color: white;");

        Button delete = new Button("Delete");
        delete.setPrefWidth(100);
        delete.setPrefHeight(70);
        delete.setFont(Font.font(24));

        Button edit = new Button("Edit");
        edit.setPrefWidth(100);
        edit.setPrefHeight(70);
        edit.setFont(Font.font(24));


        String participant1="";
        participant1+=application.getParticipant();
        Label participant2= new Label(participant1);
        participant2.setPrefWidth(100);
        participant2.setPrefHeight(70);
        participant2.setFont(Font.font(24));

        String trainer1="";
        trainer1+=application.getTrainer();
        Label trainer2= new Label(trainer1);
        trainer2.setPrefWidth(100);
        trainer2.setPrefHeight(70);
        trainer2.setFont(Font.font(24));

        String sport1="";
        sport1+=application.getSport();
        Label sport2= new Label(sport1);
        sport2.setPrefWidth(100);
        sport2.setPrefHeight(70);
        sport2.setFont(Font.font(24));

        String chosenDate1="";
        chosenDate1+=application.getChosenDate();
        Label chosenDate2= new Label(chosenDate1);
        chosenDate2.setPrefWidth(100);
        chosenDate2.setPrefHeight(70);
        chosenDate2.setFont(Font.font(24));

        String status1="";
        status1+=application.getStatus();
        Label status2= new Label(status1);
        status2.setPrefWidth(100);
        status2.setPrefHeight(70);
        status2.setFont(Font.font(24));


        pane.setHgap(10);

        GridPane.setMargin(participant2, new Insets(15, 15, 5, 15));
        GridPane.setMargin(trainer2, new Insets(5, 15, 5, 15));
        GridPane.setMargin(sport2, new Insets(5, 15, 5, 15));
        GridPane.setMargin(chosenDate2, new Insets(5, 15, 5, 15));
        GridPane.setMargin(status2, new Insets(5, 15, 5, 15));

        pane.setAlignment(Pos.BASELINE_LEFT);
        pane.add(participant2,0,0,1,3);
        pane.add(trainer2,0,1,1,3);
        pane.add(sport2,0,2,1,3);
        pane.add(chosenDate2,0,3,1,1);
        pane.add(status2,0,4,1,1);


        return pane;
    }


    public static void addApplicationAdmin(){
        Participant p=ListTrainersController.setActiveParticipant();
        //parcurgi aplicatiile userului activ
        for (Application app : p.getApplications()) {
            UserService.injecltc(this);
            ltc.getTilepane().getChildren().add(addApplicationAdmin(app)); // adaugi aplicatiile userului in tilepane

    }

}
