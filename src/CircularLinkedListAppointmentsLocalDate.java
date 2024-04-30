import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;

public class CircularLinkedListAppointmentsLocalDate {
    static final int NUM_CYCLES = 3;

    class Appointment {

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

    CircularLinkedList<Appointment> circularList = new CircularLinkedList<>();

    public void addAppointments() {
        Appointment appt = new Appointment("Appointment ", LocalDate.now());
        for (int i = 0; i <= 7; i++) {
            circularList.add(new Appointment("Appointment " + (i+1), appt.date.plusDays(i)));
        }
    }

    // Not used currently 
    public void testCircularList() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Element at index : " +  i + " " + circularList.get(i));
        }
        System.out.println("Element at index 1 " + circularList.get(1));
        System.out.println("Element at index -1: " + circularList.get(-1));
        System.out.println("Element at index 4: " + circularList.get(4));
        System.out.println("Element at index -16: " + circularList.get(-16));
        System.out.println("Element at index 11" + circularList.get(11));
        /*
        System.out.println("Element at index -1: " + circularList.get(-1));
        System.out.println("Element at index 5: " + circularList.get(5));
        System.out.println("Element at index -2: " + circularList.get(-2));
        System.out.println("Element at index 1: " + circularList.get(1));
        System.out.println("Element at index 0: " + circularList.get(0));
        System.out.println("Element at index 4: " + circularList.get(4));
        System.out.println("Element at index -16: " + circularList.get(-16));

         */
        System.out.println("\nTraversing the circular linked list in a circular manner (several cycles):");
        int numCycles = 0;
        int current = 0;
        for (Object element : circularList.toArray()) {
            System.out.println(element);
            current++;
            if (current % circularList.size() == 0) {
                current = 0;
                numCycles++;
                if (numCycles >= NUM_CYCLES)
                    break;
                System.out.println();
            }
        }
    }

    public void showSingleAppt(Scanner scanner) {
        System.out.println("Enter index to show: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("Element at index : " +  index + " " + circularList.get(index));
        resetIteratorToIndex(index + 1);

    }

    public Appointment showNextAppointment() {
       if (iterator.hasNext())
           return iterator.next();
       return null;
    }

    public void showAllAppts() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Element at index : " +  i + " " + circularList.get(i));
        }
    }

    public void testWithMenu() {
        Scanner scanner = new Scanner(System.in);
        Iterator<Appointment> iterator = circularList.iterator();
        String menuItem ="";
        while (!menuItem.equals("q")) {
            System.out.println("Next appointment(n), Appointment by index(i), all appointments (a), quit(q): ");
            menuItem = scanner.nextLine();
            switch(menuItem ) {
                case "n":
                    Appointment appt = showNextAppointment();
                    System.out.println(appt);
                    break;
                case "i":
                    showSingleAppt(scanner);
                    break;
                case "a": {
                    showAllAppts();
                    break;
                }
            }
        }
        System.out.println("Have a happy week! Goodbye.");
    }

    public void resetIteratorToIndex( int index) {
        // Assuming circularList is the circular linked list
        int size = circularList.size();
        // Normalize the index to prevent IndexOutOfBoundsException
        int normalizedIndex = index % size;

        // Reset the iterator to the beginning of the list
        iterator = circularList.iterator();

        // Advance the iterator to the desired index
        for (int i = 0; i < normalizedIndex; i++) {
            Appointment a = iterator.next();
        }
    }

     Iterator<Appointment> iterator = circularList.iterator();
    public static void main(String[] args) {

        CircularLinkedListAppointmentsLocalDate cl = new CircularLinkedListAppointmentsLocalDate();
        cl.addAppointments();
        cl.testWithMenu();
     }
}
