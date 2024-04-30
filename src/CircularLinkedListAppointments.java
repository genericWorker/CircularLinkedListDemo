import java.time.LocalDate;
import java.util.ListIterator;
import java.util.Scanner;

public class CircularLinkedListAppointments {

    CircularLinkedList<Appointment> circularList = new CircularLinkedList<>();
    ListIterator<Appointment> iterator = circularList.iterator();

    public void addAppointments() {
        Appointment appt = new Appointment("Appointment ", LocalDate.now());
        for (int i = 0; i < 7; i++) {
            circularList.add(new Appointment("Appointment " + (i+1), appt.date.plusDays(i)));
        }
    }

    public Appointment showPreviousAppointment() {
        if (iterator.hasPrevious())
            return iterator.previous();
        return null;
    }

    public Appointment showNextAppointment() {
        if (iterator.hasNext())
            return iterator.next();
        return null;
    }

    public void showAllAppointments() {
        for (int i = 0; i < circularList.size(); i++){
            System.out.println("Appointment at index: " + i + "\n" + circularList.get(i));
        }
    }

    public void resetIteratorToIndex(int index) {
        int size = circularList.size();
        int normalizedIndex = index % size;

        iterator = circularList.iterator();

        for(int i = 0; i < normalizedIndex; i++){
            Appointment m = iterator.next();
        }
    }

    public void showSingleAppointment(Scanner in){
        System.out.println("Enter index to show: ");
        int index = Integer.parseInt(in.nextLine());
        System.out.println("Appointment( at index: " + index + " " + circularList.get(index));
        resetIteratorToIndex(index + 1);
    }
    public void testAppointments() {
        Scanner in = new Scanner(System.in);
        iterator = circularList.iterator();
        String menuItem = "";
        while (!menuItem.equals("q")){
            System.out.println("Next Appointment( <n>, Appointment( by index <i>, All Appointments( <a>, Quit <q>: ");
            menuItem = in.nextLine();
            switch ((menuItem)){
                case "n":
                    Appointment sn = showNextAppointment();
                    System.out.println(sn);
                    break;
                case "p":
                    Appointment sp = showPreviousAppointment();
                    System.out.println(sp);
                    break;
                case "i":
                    showSingleAppointment(in);
                    break;
                case "a":
                    showAllAppointments();
                    break;

            }
        }
        System.out.println("******* Have a good day! *******");

    }

    public static void main(String[] args) {
        CircularLinkedListAppointments mp = new CircularLinkedListAppointments();
        mp.addAppointments();
        mp.testAppointments();
    }

}
