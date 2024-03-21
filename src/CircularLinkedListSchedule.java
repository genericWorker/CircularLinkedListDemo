import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CircularLinkedListSchedule{
    enum DayOfWeek {Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday};
    ThreadLocalRandom random = ThreadLocalRandom.current();

     class Activity {
        DayOfWeek weekday;
        String activity;

        public Activity(DayOfWeek weekday, String activity) {
            this.weekday = weekday;
            this.activity = activity;
        }

        @Override
        public String toString() {
            return  weekday + ":" + activity;
        }
    }

    CircularLinkedList<Activity> circularList = new CircularLinkedList<>();

    public void addActivities(List <String> weekmenu) {
            circularList.add(new Activity(DayOfWeek.Sunday, weekmenu.get(0)));
            circularList.add(new Activity(DayOfWeek.Monday, weekmenu.get(1)));
            circularList.add(new Activity(DayOfWeek.Tuesday, weekmenu.get(2)));
            circularList.add(new Activity(DayOfWeek.Wednesday, weekmenu.get(3)));
            circularList.add(new Activity(DayOfWeek.Thursday, weekmenu.get(4)));
            circularList.add(new Activity(DayOfWeek.Friday, weekmenu.get(5)));
            circularList.add(new Activity(DayOfWeek.Saturday,weekmenu.get(6)));
            //     }
        }
        public void testCircularListSchedule(int numWeeks) {
            MenuPlanner mp = new MenuPlanner();
            List<List<String>> weekmenu =  mp.generateMenus(mp.menu, numWeeks);
            int week = 1;
            for (int i=0; i < numWeeks; i++) {
                addActivities(weekmenu.get(i));
            }
            for (int j= 0; j< circularList.size(); j++) {
                if (j % 7 == 0) {
                    System.out.println("\nWeek " + week++);
                }
                System.out.println(circularList.get(j));
            }

            System.out.println("\nIterator Test");
            Iterator<Activity> iterator = circularList.iterator();
            int count = 1;
            while (iterator.hasNext()) {
                Activity element = iterator.next();
                System.out.println(element);
                if (count++ >= 11)
                    break;
            }
        }

    public static void main(String[] args) {

        CircularLinkedListSchedule cl = new CircularLinkedListSchedule();
        cl.testCircularListSchedule(5);
     }
}
