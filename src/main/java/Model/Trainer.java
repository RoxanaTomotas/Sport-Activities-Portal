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
    protected String email; //Trainer's email
    protected String address; //Trainer's address
    protected String university; //Trainer's university
    protected List<Contract> contracts; //Trainer's contracts
    protected List<Sport> sports; //Trainer's assigned sports

    Trainer() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.address = "";
        this.university = "";
    }

    Trainer(String firstName, String lastName, String email, String address, String university, List<Contract> contracts, List<Sport> sports) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.university = university;
        if (this.contracts != null) {
            this.contracts.addAll(contracts);
        }
        if (this.sports != null) {
            this.sports.addAll(sports);
        }
    }

    Trainer(Trainer trainer) {
        this.firstName = trainer.firstName;
        this.lastName = trainer.lastName;
        this.email = trainer.email;
        this.address = trainer.address;
        this.university = trainer.university;
        if (this.contracts != null) {
            this.contracts.addAll(trainer.contracts);
        }
        if (this.sports != null) {
            this.sports.addAll(trainer.sports);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
