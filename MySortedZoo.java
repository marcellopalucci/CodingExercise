import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySortedZoo implements SortedZoo{
    private Animal [] animals;
    private int size;
    private static final int INITIAL_CAPACITY = 3;
    public MySortedZoo() {
        animals = new Animal[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void clear(){
        //two problems, i < size, and size =0
        for(int i = 0; i < size; i++) {
            animals[i] = null;
        }
        size = 0;
    }
    @Override
    public void add(Animal element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Null element can't be added to the zoo");
        }
        if (size == animals.length) {
            expandCapacity();
        }
        int index = findInsertionIndex(element);
        //shift all elements to the right starting from the index
        for(int i = size; i > index; i--) {
            animals[i] = animals[i-1];
        }
        animals[index] = element;
        size++;
    }
    private void expandCapacity() {
        Animal[] temp = new Animal[animals.length * 2];
        for(int i = 0; i < size; i++) {
            temp[i] = animals[i];
        }
        temp = animals;
    }
    private int findInsertionIndex(Animal element) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (animals[i].compareTo(element) >= 0) break;
        }
        return i;
    }
    @Override
    public Animal remove(Animal element) throws IllegalArgumentException, NoSuchElementException {
        if (!(element instanceof Animal)) {
            throw new IllegalArgumentException();
        }
        int decSize = animals.length - 1;
        Animal[] temp = new Animal[decSize];
        int j = 0;
        boolean found = false;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].equals(element)){
                found = true;
            } else {
                temp[j++] = animals[i];
            }
        }
        animals = temp;
        if(found) return element;
        throw new NoSuchElementException();
    }
    @Override
    public int findFirstOccurrenceIndex(Animal element) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].equals(element)) return i;
        }
        throw new NoSuchElementException();
    }
    @Override
    public Iterator<Animal> iterator() {
        return new MySortedZooIterator();
    }
    private class MySortedZooIterator implements Iterator<Animal> {
        private int position = 0;
        public boolean hasNext(){
            return position <= size;
        }
        public Animal next() {
            if (!hasNext()) throw new NoSuchElementException("No more animals in the zoo");
            return animals[position++];
        }
    }
}
