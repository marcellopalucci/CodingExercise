import java.util.Iterator;
import java.util.NoSuchElementException;

public interface SortedZoo extends Iterable<Animal> {
    int size();
    boolean isEmpty();
    void clear();
    void add(Animal element) throws IllegalArgumentException;
    Animal remove(Animal element) throws IllegalArgumentException, NoSuchElementException;
    int findFirstOccurrenceIndex(Animal element);
    Iterator<Animal> iterator();
    //do we need these?
    public boolean hasNext();
    public Animal next();


}
