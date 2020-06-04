package Model;

import java.util.List;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *   This class represents the object trainer.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Trainer {

    protected String firstName; //First name of the trainer
    protected String lastName; //Last name of the trainer
    protected String username; //Trainer's username
    protected String password; //Trainer's password
    protected String address; //Trainer's address
    protected String university; //Trainer's university
    protected List<Contract> contracts; //Trainer's contracts
    protected List<Sport> sports; //Trainer's assigned sports
    protected List<Date> dates;

    Trainer() {
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.address = "";
        this.university = "";
    }

    public Trainer(String firstName, String lastName, String username, String password, String address, String university, List<Contract> contracts, List<Sport> sports, List<Date> dates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.university = university;
        if (this.contracts != null) {
            this.contracts.addAll(contracts);
        }
        if (this.sports != null) {
            this.sports.addAll(sports);
        }
        if (this.dates != null) {
            this.dates.addAll(dates);
        }
    }

    Trainer(Trainer trainer) {
        this.firstName = trainer.firstName;
        this.lastName = trainer.lastName;
        this.username = trainer.username;
        this.password = trainer.password;
        this.address = trainer.address;
        this.university = trainer.university;
        if (this.contracts != null) {
            this.contracts.addAll(trainer.contracts);
        }
        if (this.sports != null) {
            this.sports.addAll(trainer.sports);
        }
        if (this.dates != null) {
            this.dates.addAll(trainer.dates);
        }
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

    public String getAddress() {
        return address;
    }

    public String getUniversity() {
        return university;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public List<Sport> getSports() {
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
