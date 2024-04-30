import java.time.DayOfWeek;
import java.time.LocalDate;

public class Appointment {

    String apptDescription;
    LocalDate date;

    public Appointment(String apptDescription, LocalDate date) {
        this.apptDescription = apptDescription;
        this.date = date;
    }

    public DayOfWeek getApptDescription() {
        return date.getDayOfWeek();
    }

    @Override
    public String toString() {
        return date.toString() + " " +  date.getDayOfWeek() + " " + apptDescription ;
    }
}