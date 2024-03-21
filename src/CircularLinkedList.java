import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements Iterable<T> {

   //  main is provided for demo and testing, don't use for your project
    public static void main(String[] args) {
        CircularLinkedList<Integer> circularList = new CircularLinkedList<>();

        // Adding elements to the circular list
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.add(5);

        // Iterating through the circular list using the iterator
        Iterator<Integer> iterator = circularList.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
            if (count++ >= 20)
                break;

        }
    }

    private LinkedList<T> list;

    public CircularLinkedList() {
        list = new LinkedList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public void remove(T element) {
        list.remove(element);
    }


    public T get(int index) {
        int adjustedIndex = index % list.size();
        if (adjustedIndex < 0) {
            adjustedIndex += list.size();
        }
        return list.get(adjustedIndex);
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularIterator();
    }
     class CircularIterator implements Iterator<T> {
        int current;

        public CircularIterator() {
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the circular list.");
            }

            T element = list.get(current);
            current = (current + 1) % list.size();
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }
    }
}
