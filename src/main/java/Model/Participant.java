package Model;

import java.util.List;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*
*   This class represents the object participant.
*
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Participant {

    protected String firstName; //First name of the student
    protected String lastName; //Second name of the student
    protected String username; //Student's username
    protected String password; //Student's password
    protected String address; //The address of the student
    protected String university; //The university of the student
    protected String specialization; //Student's specialization
    protected String uniqueID; //Student's unique ID
    protected int studyYear; //The student's study year
    protected boolean healthAppropval; //Healt approval: 1 - apt, 0 -  is not apt
    protected List<Application> applications; //The list of the student's applications
    protected Contract contract; //The student's unique contract

    Participant() {
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.username = "";
        this.password ="";
        this.university = "";
        this.specialization = "";
        this.uniqueID = "";
        this.studyYear = 0;
        this.healthAppropval = false;
    }

    public Participant(String firstName, String lastName, String address, String username, String password, String university, String specialization, String uniqueID, int studyYear, boolean healthAppropval, List<Application> applications, Contract contract) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.university = university;
        this.specialization = specialization;
        this.uniqueID = uniqueID;
        this.studyYear = studyYear;
        this.healthAppropval = healthAppropval;
        if (this.applications != null) {
            this.applications.addAll(applications);
        }
        this.contract = contract;
    }

    Participant(Participant participant) {
        this.firstName = participant.firstName;
        this.lastName = participant.lastName;
        this.address = participant.address;
        this.username = participant.username;
        this.password = participant.password;
        this.university = participant.university;
        this.specialization = participant.specialization;
        this.uniqueID = participant.uniqueID;
        this.studyYear = participant.studyYear;
        this.healthAppropval = participant.healthAppropval;
        if (this.applications != null) {
            this.applications.addAll(participant.applications);
        }
        this.contract = participant.contract;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getUniversity() {
        return university;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public boolean isHealthAppropval() {
        return healthAppropval;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public Contract getContract() {
        return contract;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public void setHealthAppropval(boolean healthAppropval) {
        this.healthAppropval = healthAppropval;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
