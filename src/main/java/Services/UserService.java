package Services;

import Controllers.ListTrainersController;
import Exceptions.CouldNotWriteUsersException;
import Exceptions.EmptyFieldException;
import Exceptions.IncorrectLoginData;
import Model.*;
import Model.Participant;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class UserService {

    /*List of participants*/
    private static List<Participant> participants;

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
                    if(Objects.equals(password, participant.getPassword()))
                        ListTrainersController.setActiveParticipant(participant);
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
}