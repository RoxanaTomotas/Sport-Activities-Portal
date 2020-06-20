package Services;

import Controllers.ListTrainersController;
import Controllers.ParticipantPageController;
import Exceptions.CouldNotWriteUsersException;
import Exceptions.EmptyFieldException;
import Exceptions.IncorrectLoginData;
import Model.Application;
import Model.Date;
import Model.Participant;
import Model.Trainer;
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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/* ******************************************************************
 *
 *   User Service manages the users: both participants and trainers
 *
 * *******************************************************************/
public class UserService<JSONArray> {

    /*List of participants*/

    private static List<Participant> participants;
    private static Participant part,part1;

    static {
        participants=new ArrayList<Participant>();
    }

    /*List of trainers*/
    private static List<Trainer> trainers;

    static {
        trainers=new ArrayList<Trainer>();
    }

    /*Path for participants: participants_PATH*/
    private static final Path participants_PATH = FileSystemService.getPathToFile("config", "participants.json");

    /*Path for trainers: trainers_PATH*/
    private static final Path trainers_PATH = FileSystemService.getPathToFile("config", "trainers.json");
    int sw;
    public static ListTrainersController ltc;
    public static ParticipantPageController ppc;



    /*********************************************************************************************
     *
     *
     * This method loads the users: both participants and trainers, from the corresponding files.
     *
     *
     *
     * *********************************************************************************************/
    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(participants_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(UserService.class.getClassLoader().getResource("participants.json")), participants_PATH.toFile());
        }

        ObjectMapper objectMapperparticipants = new ObjectMapper();

        participants = objectMapperparticipants.readValue(participants_PATH.toFile(), new TypeReference<List<Participant>>() {
        });

        if (!Files.exists(trainers_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(UserService.class.getClassLoader().getResource("trainers.json")), trainers_PATH.toFile());
        }

        ObjectMapper objectMappertrainers = new ObjectMapper();

        trainers = objectMappertrainers.readValue(trainers_PATH.toFile(), new TypeReference<List<Trainer>>() {
        });
    }


    /* *********************************************
     *
     *   This method adds the participant.
     *
     * **********************************************/
    public static void addParticipant(String firstName, String lastName, String username, String password, String university, String specialization, String uniqueID, String studyYear , boolean healthAppropval)throws Exception {

        checkEmptyField(username,password);
        checkUsernameAlreadyExist(username);
        participants.add(new Participant(firstName, lastName,  username,  encodePassword(username, password),  university,  specialization,  uniqueID,  studyYear,  healthAppropval,null));
        persistParticipants();
    }


    /* *********************************************
     *
     *   This method adds the trainer.
     *
     * **********************************************/
    public static void addTrainer(java.lang.String firstName, java.lang.String lastName, java.lang.String username, java.lang.String password, java.lang.String university, List<Application> application, java.lang.String sports, List<Date> dates)throws Exception {

        checkEmptyField(username,password);
        checkUsernameAlreadyExist(username);
        trainers.add(new Trainer(firstName, lastName,  username,   encodePassword(username, password),  university, application, sports, dates));
        persistTrainers();
    }


    /****************************************
     *
     *
     *  This method persists the participants.
     *
     * ****************************************/
    private static void persistParticipants() {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(participants_PATH.toFile(), participants);

        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }


    /****************************************
     *
     *
     *  This method persists the trainers.
     *
     * ****************************************/
    private static void persistTrainers() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(trainers_PATH.toFile(), trainers);

        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }


    /*****************************************************
     *
     *
     *  This method checks if an username already exists.
     *
     *
     * *****************************************************/
    private static void checkUsernameAlreadyExist(java.lang.String username) throws Exception {
        for (Trainer trainer : trainers) {
            if (Objects.equals(username, trainer.getUsername())) {
                throw new CouldNotWriteUsersException();//change exception
            }
            }
        }


    /**********************************************
     *
     *  This method checks if an attribute is empty.
     *
     * **********************************************/
    private static void checkEmptyField(java.lang.String username, java.lang.String password) throws EmptyFieldException {

        if(username.equals("") || password.equals("")) throw new EmptyFieldException();
    }


    /********************************************************
     *
     *  This method checks if the login credentials are correct.
     *
     * ********************************************************/
    public static void checkLoginCredentials(java.lang.String username, java.lang.String password, java.lang.String role) throws IncorrectLoginData {
        int sw=0;
        if(role.equals("Trainer")) {
            for (Trainer trainer : trainers) {
                if (Objects.equals(username, trainer.getUsername())) {
                    sw=1;
                    if (!Objects.equals(password, trainer.getPassword()))
                        throw new IncorrectLoginData();
                }
            }
            if(sw==0) //n-am gassit user ul
                throw new IncorrectLoginData();
        }
        else
        if(role.equals("Participant")) {
            for (Participant participant : participants) {
                if (Objects.equals(username, participant.getUsername())) {
                    if(Objects.equals(password, participant.getPassword())) {
                        ListTrainersController.setActiveParticipant(participant);
                        part = participant;
                    }
                    sw=1;
                    if (!Objects.equals(password, participant.getPassword()))
                        throw new IncorrectLoginData();
                }
            }
            if(sw==0) //n-am gassit user ul
                throw new IncorrectLoginData();
        }

    }


    /********************************************************
     *
     *  This method encodes the password
     *
     * ********************************************************/
    private static java.lang.String encodePassword(java.lang.String salt, java.lang.String password) {

        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        /*This is the way a password should be encoded when checking the credentials*/
        return new java.lang.String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); /*to be able to save in JSON format*/
    }


    private static MessageDigest getMessageDigest() {

        MessageDigest md;
        try {

            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {

            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static void setTrainers(java.lang.String sport) {
        for (Trainer trainer : trainers) {
            System.out.println(sport+" "+trainer.getSports().toString());
            if(trainer.getSports().equals(sport)) {
                System.out.println("lsa vedem");
                ltc.getTrainer().getItems().add(trainer.getFirstName());
            }
        }
    }
    public static void setDate(java.lang.String name_trainer) {
        for (Trainer trainer : trainers) {
            if(name_trainer.equals(trainer.getFirstName())) {
                java.lang.String date="";
                for(Date date1:trainer.getDates() ) {
                    date = date1.getDay() + "-" + date1.getStartHour() + ":" + date1.getStartMinute() + "-" + date1.getEndHour() + ":" + date1.getEndMinute();
                    ltc.getDate().getItems().add(date);
                    date = "";
                }
            }
        }
    }

    public static Trainer setByTrainer(java.lang.String firstName) {
        for(Trainer trainer:trainers) {
            if(trainer.getFirstName().equals(firstName))
                return trainer;
        }
        return null;
    }

    public static void injecltc(ListTrainersController u) {
        ltc= u;
    }


    public static void sentParticiapnt(String participant, Application application) {
        for(Participant participant1:participants) {
            String name=participant1.getFirstName()+" "+participant1.getLastName();
            if(name.equals(participant)) {
                System.out.println("intra in if");
                participant1.getApplications().add(application);
            }
        }
        persistParticipants();
    }

    public static void injectppc(ParticipantPageController participantPageController) {
        ppc=participantPageController;
    }

    private static GridPane addApplication(Application application) {
        GridPane pane = new GridPane();
        pane.setPrefWidth(600);
        pane.setPrefHeight(300);
        pane.setStyle("-fx-background-color: #FFFF99;");

        Button delete = new Button("Delete");
        delete.setPrefWidth(400);
        delete.setPrefHeight(70);
        delete.setFont(Font.font(24));
        delete.setOnAction(e-> {
            handleDeleteButton(application);
            System.out.println("removed");
        });

        Button edit = new Button("Edit");
        edit.setPrefWidth(200);
        edit.setPrefHeight(70);
        edit.setFont(Font.font(24));


        String participant1 = "";
        participant1 += application.getParticipant();
        Label participant2 = new Label("Participant: "+participant1);
        participant2.setPrefWidth(400);
        participant2.setPrefHeight(55);
        participant2.setFont(Font.font(17));

        String trainer1 = "";
        trainer1 += application.getTrainer();
        Label trainer2 = new Label("Trainer: "+trainer1);
        trainer2.setPrefWidth(400);
        trainer2.setPrefHeight(55);
        trainer2.setFont(Font.font(17));

        String sport1 = "";
        sport1 += application.getSport();
        Label sport2 = new Label("Sport: "+sport1);
        sport2.setPrefWidth(400);
        sport2.setPrefHeight(55);
        sport2.setFont(Font.font(17));

        String chosenDate1 = "";
        chosenDate1 += application.getChosenDate();
        Label chosenDate2 = new Label("Date: "+chosenDate1);
        chosenDate2.setPrefWidth(500);
        chosenDate2.setPrefHeight(55);
        chosenDate2.setFont(Font.font(17));

        String status1 = "";
        status1 += application.getStatus();
        Label status2 = new Label("Status: "+status1);
        status2.setPrefWidth(400);
        status2.setPrefHeight(55);
        status2.setFont(Font.font(17));


        pane.setHgap(30);

        GridPane.setMargin(participant2, new Insets(15, 15, 5, 15));
        GridPane.setMargin(trainer2, new Insets(5, 15, 5, 15));
        GridPane.setMargin(sport2, new Insets(5, 15, 5, 15));
        GridPane.setMargin(chosenDate2, new Insets(5, 15, 5, 15));
        GridPane.setMargin(status2, new Insets(5, 15, 5, 15));
        GridPane.setMargin(delete, new Insets(0,200,0,0));
        pane.setPadding(new Insets(10,10,10,10));

        pane.setAlignment(Pos.BASELINE_LEFT);
        pane.add(participant2, 0, 0);
        pane.add(trainer2, 0, 1);
        pane.add(sport2, 0, 2);
        pane.add(chosenDate2, 0, 3);
        pane.add(status2, 0, 4);

        pane.add(edit, 0, 5);
        pane.add(delete, 1, 5);


        return pane;
    }

    public static void addApplicationAdmin() {
        for (Application app : part.getApplications()) {
            ppc.getTilePane().getChildren().add(addApplication(app));
        }
    }

    public static void handleDeleteButton(Application application) {
        ArrayList<Application> appl= (ArrayList<Application>) part.getApplications();
        appl.remove(application);
    }

}