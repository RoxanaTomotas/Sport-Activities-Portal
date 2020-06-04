package Services;

import Exceptions.CouldNotWriteUsersException;
import Exceptions.EmptyFieldException;
import Exceptions.IncorrectLoginData;
import Model.*;
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
    public static void addParticipant(String firstName, String lastName, String address, String username, String password, String university, String specialization, String uniqueID, String studyYear, boolean healthAppropval, List<Application> applications, Contract contract)throws Exception {

        checkEmptyField(username,password);
        checkUsernameAlreadyExist(username);
        participants.add(new Participant(firstName, lastName,  address,  username,  encodePassword(username, password),  university,  specialization,  uniqueID,  studyYear,  healthAppropval, null,null));
        persistParticipants();
    }
    

    /* *********************************************
     *
     *   This method adds the trainer.
     *
     * **********************************************/
    public static void addTrainer(String firstName, String lastName, String address, String username, String password, String university, List<Contract> contracts, List<Sport> sports)throws Exception {

        checkEmptyField(username,password);
        checkUsernameAlreadyExist(username);
        trainers.add(new Trainer(firstName, lastName,  username,   encodePassword(username, password),  address,  university, null,null,null));
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
    private static void checkUsernameAlreadyExist(String username) throws Exception {

        /*Participants' usernames are checked.*/
     /*   for (Participant participant : participants) {
            System.out.println("Faci?");
            if (Objects.equals(username, participant.getUsername()))
                throw new CouldNotWriteUsersException();//change exception
        }*/
        System.out.println("Faci2?");
        /*Trainers' usernames are checked.*/
        for (Trainer trainer : trainers) {
            if (Objects.equals(username, trainer.getUsername()))
                throw new CouldNotWriteUsersException();//change exception
        }
    }


    /**********************************************
    *
    *  This method checks if an attribute is empty.
    *
    * **********************************************/
    private static void checkEmptyField(String username, String password) throws EmptyFieldException {

        if(username.equals("") || password.equals("")) throw new EmptyFieldException();
    }


    /********************************************************
     *
     *  This method checks if the login credentials are correct.
     *
     * ********************************************************/
    public static void checkLoginCredentials(String username,String password, String role) throws IncorrectLoginData {

//      System.out.println("aaaaaaaaaa 1");
//        String encodePassword = encodePassword(username, password);
//        System.out.println("aaaaaaaaaa 2");
//        /*The participants' usernames and passwords are checked*/
//        int correct=0;
//        System.out.println("aaaaaaaaaa 3");
//        for (Participant participant : participants) {
//            System.out.println("aaaaaaaaaa 4");
//            if (Objects.equals(username, participant.getUsername())) {
//                correct=1;
//                System.out.println("aaaaaaaaaa 5");
//                if (!Objects.equals(encodePassword, participant.getPassword()))
//                    throw new IncorrectLoginData();
//            }
//        }
//        System.out.println("aaaaaaaaaa 6");
//        /*The trainers' usernames and passwords are checked*/
//        for (Trainer trainer : trainers) {
//            if (Objects.equals(username, trainer.getUsername())) {
//                correct=1;
//                if (!Objects.equals(encodePassword, trainer.getPassword()))
//                    throw new IncorrectLoginData();
//            }
//        }
//
//        /*The inexistance of the username and password leads to an exception.*/
//        if(correct==0) throw new IncorrectLoginData();
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
    private static String encodePassword(String salt, String password) {

        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        /*This is the way a password should be encoded when checking the credentials*/
        return new String(hashedPassword, StandardCharsets.UTF_8)
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

}
