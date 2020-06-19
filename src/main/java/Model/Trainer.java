package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *   This class represents the object trainer.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Trainer {

    protected String firstName; //First name of the trainer
    protected String lastName; //Last name of the trainer
    protected String password; //Trainer's password
    protected String university; //Trainer's university
    protected List<Application> applications; //Trainer's contracts
    protected String sports; //Trainer's assigned sport
    protected List<Date> dates;

    public Trainer() {}

    public Trainer(String firstName, String lastName, String username, String password, String university, List<Application> applications, String sports, List<Date> dates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.university = university;
        this.applications = applications;
        this.sports = sports;
        this.dates = dates;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUniversity() {
        return university;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public String getSports() {
        return sports;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(firstName, trainer.firstName) &&
                Objects.equals(lastName, trainer.lastName) &&
                Objects.equals(username, trainer.username) &&
                Objects.equals(password, trainer.password) &&
                Objects.equals(university, trainer.university) &&
                Objects.equals(applications, trainer.applications) &&
                Objects.equals(sports, trainer.sports) &&
                Objects.equals(dates, trainer.dates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, password, university, applications, sports, dates);
    }

    protected String username; //Trainer's username

    @Override
    public String toString() {
        return "Trainer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", university='" + university + '\'' +
                ", applications=" + applications +
                ", sports='" + sports + '\'' +
                ", dates=" + dates +
                '}';
    }


}
