import java.util.Iterator;

public class CircularLinkedListDemo {
    static final int NUM_CYCLES = 3;
    public static void main(String[] args) {
        CircularLinkedList<String> circularList = new CircularLinkedList<>();
        Iterator<String> iterator = circularList.iterator();
        circularList.add("Apple");
        circularList.add("Banana");
        circularList.add("Cherry");
        circularList.add("Durian");
        //circularList.remove("Apple");

        //circularList.printList();

        System.out.println("Element at index 5: " + circularList.get(5));
        System.out.println("Element at index -2: " + circularList.get(-2));
        System.out.println("Element at index 1: " + circularList.get(1));
        System.out.println("Element at index 0: " + circularList.get(0));
        System.out.println("Element at index 4: " + circularList.get(4));
        System.out.println("Element at index -16: " + circularList.get(-16));
        System.out.println("\nTraversing the circular linked list in a circular manner:");
        int numCycles= 0;
        int current = 0;
        for (String element : circularList) {
            System.out.println(element);
            current++;
            if (current % circularList.size() == 0 ) {
                current = 0;
                numCycles ++;
                if (numCycles >= NUM_CYCLES)
                    break;
                System.out.println();
            }
        }
        int x = 1;
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if (x++ >=16)
                 break;
        }


        // System.out.println(circularList.next());
    }
}
