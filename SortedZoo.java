import java.util.Iterator;
import java.util.NoSuchElementException;

public interface SortedZoo extends Iterable<Animal> {
    public int size();
    boolean isEmpty();
    void clear();
    void add(Animal element) throws IllegalArgumentException;
    Animal remove(Animal element) throws IllegalArgumentException, NoSuchElementException;
    int findFirstOccurrenceIndex(Animal element);
    Iterator<Animal> iterator();
    //extends iterable to use the foreach loop, doesn't need to implement because it extends the class
    //it's not an interface. which requires to use the method

}
