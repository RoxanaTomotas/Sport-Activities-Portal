package Model;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *   This class represents the object date.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Date {

    protected String day; //The day of the week
    protected int startHour; //The start hour of the sport
    protected int endHour; //The end hour of the sport
    protected int startMinute; //The start minute of the sport
    protected int endMinute; ////The end minute of the sport

    public Date() {
    }

    public Date(String day, int startHour, int endHour, int startMinute, int endMinute) {
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
    }

    public Date(Date date) {
        this.day = date.day;
        this.startHour = date.startHour;
        this.endHour = date.endHour;
        this.startMinute = date.startMinute;
        this.endMinute = date.endMinute;
    }

    public String getDay() {
        return day;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }
}
