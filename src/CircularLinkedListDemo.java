import java.util.ListIterator;

// Example usage
public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList<String> circularList = new CircularLinkedList<>();
        circularList.add("A");
        circularList.add("B");
        circularList.add("C");

        ListIterator<String> iterator = circularList.iterator();
        System.out.println("Forward iteration:");
        for (int i = 0; i < 9; i++) {
            if (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }

        System.out.println("\nBackward iteration:");
        for (int i = 0; i < 9; i++) {
            if (iterator.hasPrevious()) {
                System.out.print(((CircularIterator<String>) iterator).previous() + " ");
            }
        }

        CircularLinkedList<Integer> circularListInt = new CircularLinkedList<>();
        circularListInt.add(1);
        circularListInt.add(2);
        circularListInt.add(3);

        ListIterator<Integer> iterator2 = circularListInt.iterator();


        System.out.println();
        System.out.println("Forward iteration:");
        for (int i = 0; i < 9; i++) {
            if (iterator2.hasNext()) {
                System.out.print(iterator2.next() + " ");
            }
        }

        System.out.println("\nBackward iteration:");
        for (int i = 0; i < 9; i++) {
            if (iterator2.hasPrevious()) {
                System.out.print( iterator2.previous() + " ");
            }
        }
        System.out.println();

        CircularLinkedList<String> fruits = new CircularLinkedList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Durian");

        ListIterator<String> fruitIterator = fruits.iterator();

        int loops = 1;
        System.out.println("\nForward iteration:");
        while (fruitIterator.hasNext()) {
            String element = fruitIterator.next();
            System.out.println(element);
            if (loops++ >=8)
                break;
        }
        System.out.println();
        System.out.println("Element at index 5: " + fruits.get(5));
        System.out.println("Element at index -2: " + fruits.get(-2));
        System.out.println("Element at index 1: " + fruits.get(1));
        System.out.println("Element at index 0: " + fruits.get(0));
        System.out.println("Element at index 4: " + fruits.get(4));
        System.out.println("Element at index -16: " + fruits.get(-16));


        System.out.println("\nBackward iteration:");
        fruitIterator = fruits.iterator();
        for (int i = 0; i < 4; i++) {
            if (fruitIterator.hasPrevious()) {
                System.out.println(((CircularIterator<String>)fruitIterator).previous() + " ");
            }
        }
        loops = 0;
        System.out.println("\nForward iteration:");
        while (fruitIterator.hasNext()) {
            String element = fruitIterator.next();
            System.out.println(element);
            if (loops++ > 2)
                break;
        }

    }
}
