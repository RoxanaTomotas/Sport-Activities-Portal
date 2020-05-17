package Model;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *   This class represents the object contract.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Contract {

    protected Participant participant; //The implied participant
    protected Trainer trainer; //The implied trainer
    protected Sport sport; //The implied sport
    protected Date chosenDate; //The choosen date

    Contract() {
        this.participant = null;
        this.trainer = null;
        this.sport = null;
        this.chosenDate = null;
    }

    Contract(Participant participant, Trainer trainer, Sport sport, Date chosenDate) {
        this.participant = participant;
        this.trainer = trainer;
        this.sport = sport;
        this.chosenDate = chosenDate;
    }

    Contract(Contract contract) {
        this.participant = contract.participant;
        this.trainer = contract.trainer;
        this.sport = contract.sport;
        this.chosenDate = contract.chosenDate;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Sport getSport() {
        return sport;
    }

    public Date getChosenDate() {
        return chosenDate;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public void setChosenDate(Date chosenDate) {
        this.chosenDate = chosenDate;
    }
}
