package Model;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *   This class represents the object application.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import javafx.scene.control.Control;
import javafx.scene.control.SkinBase;

import java.util.Objects;

public class Application {

    protected String participant; //The implied participant
    protected String trainer; //The implied trainer
    protected String sport; //The implied sport
    protected String chosenDate; //The choosen date
    protected int status;

    public Application() {
    }

    public Application(String participant, String trainer, String sport, String chosenDate, int status) {
        this.participant = participant;
        this.trainer = trainer;
        this.sport = sport;
        this.chosenDate = chosenDate;
        this.status = status;
    }

    public String getParticipant() {
        return participant;
    }

    public String getTrainer() {
        return trainer;
    }

    public String getSport() { return sport; }

    public String getChosenDate() {
        return chosenDate;
    }

    public int getStatus() {
        return status;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setChosenDate(String chosenDate) {
        this.chosenDate = chosenDate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return status == that.status &&
                Objects.equals(participant, that.participant) &&
                Objects.equals(trainer, that.trainer) &&
                Objects.equals(sport, that.sport) &&
                Objects.equals(chosenDate, that.chosenDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, trainer, sport, chosenDate, status);
    }

    @Override
    public java.lang.String toString() {
        return "Application{" +
                "participant=" + participant +
                ", trainer=" + trainer +
                ", sport='" + sport + '\'' +
                ", chosenDate=" + chosenDate +
                ", status=" + status +
                '}';
    }

}
