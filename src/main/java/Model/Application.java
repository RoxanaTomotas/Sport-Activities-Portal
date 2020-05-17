package Model;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *   This class represents the object application.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Application {

    protected Participant participant; //The implied participant
    protected Trainer trainer; //The implied trainer
    protected Sport sport; //The implied sport
    protected Date chosenDate; //The choosen date

    Application() {
        this.participant = null;
        this.trainer = null;
        this.sport = null;
        this.chosenDate = null;
    }

    Application(Participant participant, Trainer trainer, Sport sport, Date chosenDate) {
        this.participant = participant;
        this.trainer = trainer;
        this.sport = sport;
        this.chosenDate = chosenDate;
    }

    Application(Application application) {
        this.participant = application.participant;
        this.trainer = application.trainer;
        this.sport = application.sport;
        this.chosenDate = application.chosenDate;
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
