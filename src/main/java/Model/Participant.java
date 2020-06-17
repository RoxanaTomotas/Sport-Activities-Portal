package Model;

import java.util.List;
import java.util.Objects;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *   This class represents the object participant.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Participant {

    protected java.lang.String firstName; //First name of the student
    protected java.lang.String lastName; //Second name of the student
    protected java.lang.String username; //Student's username
    protected java.lang.String password; //Student's password
    protected java.lang.String university; //The university of the student
    protected java.lang.String specialization; //Student's specialization
    protected java.lang.String uniqueID; //Student's unique ID
    protected java.lang.String studyYear; //The student's study year
    protected boolean healthAppropval; //Healt approval: 1 - apt, 0 -  is not apt
    protected List<Application> applications; //The list of the student's applications

    public Participant() {}

    public Participant(String firstName, String lastName, String username, String password, String university, String specialization, String uniqueID, String studyYear, boolean healthAppropval, List<Application> applications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.university = university;
        this.specialization = specialization;
        this.uniqueID = uniqueID;
        this.studyYear = studyYear;
        this.healthAppropval = healthAppropval;
        this.applications = applications;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(String studyYear) {
        this.studyYear = studyYear;
    }

    public boolean isHealthAppropval() {
        return healthAppropval;
    }

    public void setHealthAppropval(boolean healthAppropval) {
        this.healthAppropval = healthAppropval;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return healthAppropval == that.healthAppropval &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(university, that.university) &&
                Objects.equals(specialization, that.specialization) &&
                Objects.equals(uniqueID, that.uniqueID) &&
                Objects.equals(studyYear, that.studyYear) &&
                Objects.equals(applications, that.applications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, password, university, specialization, uniqueID, studyYear, healthAppropval, applications);
    }


    @Override
    public String toString() {
        return "Participant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", university='" + university + '\'' +
                ", specialization='" + specialization + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                ", studyYear='" + studyYear + '\'' +
                ", healthAppropval=" + healthAppropval +
                ", applications=" + applications +
                '}';
    }



}
