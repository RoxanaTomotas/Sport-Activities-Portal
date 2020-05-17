package Model;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *   This class represents the object sport.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import java.util.List;

public class Sport {

    protected String name; //The name of the sport
    protected String description; //The description of the sport
    protected List<Date> dates; //The sport's available dates
    protected List<Trainer> trainers; //The sport's trainers

    public Sport() {
        this.name = "";
        this.description = "";
        this.dates = null;
        this.trainers = null;
    }

    public Sport(String name, String description, List<Date> dates, List<Trainer> trainers) {
        this.name = name;
        this.description = description;
        this.dates = dates;
        this.trainers = trainers;
    }

    public Sport(Sport sport) {
        this.name = sport.name;
        this.description = sport.description;
        this.dates = sport.dates;
        this.trainers = sport.trainers;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Date> getDates() {
        return dates;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }
}
