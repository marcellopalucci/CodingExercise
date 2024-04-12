import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySortedZoo implements SortedZoo{
    Animal [] sortedAnimals;

    @Override
    public int size(){
        return sortedAnimals.length;
    }
    @Override
    public boolean isEmpty() {
        return sortedAnimals.length > 0;
    }
    @Override
    public void clear(){
        sortedAnimals = null;
    }
    @Override
    public void add(Animal element) throws IllegalArgumentException {
        if (!(element instanceof Animal)) {
            throw new IllegalArgumentException();
        }
        int sizeInc = sortedAnimals.length + 1;
        Animal[] temp = new Animal[sizeInc];
        for (int i = 0; i < sortedAnimals.length; i++) {
            temp[i] = sortedAnimals[i];
        }
        temp[sizeInc - 1] = element;
        sortedAnimals = temp;
    }
    @Override
    public Animal remove(Animal element) throws IllegalArgumentException, NoSuchElementException {
        if (!(element instanceof Animal)) {
            throw new IllegalArgumentException();
        }
        int decSize = sortedAnimals.length - 1;
        Animal[] temp = new Animal[decSize];
        int j = 0;
        boolean found = false;
        for (int i = 0; i < sortedAnimals.length; i++) {
            if (sortedAnimals[i].equals(element)){
                found = true;
            } else {
                temp[j++] = sortedAnimals[i];
            }
        }
        sortedAnimals = temp;
        if(found) return element;
        throw new NoSuchElementException();
    }
    @Override
    public int findFirstOccurrenceIndex(Animal element) {
        for (int i = 0; i < sortedAnimals.length; i++) {
            if (sortedAnimals[i].equals(element)) return i;
        }
        throw new NoSuchElementException();
    }
    @Override
    public Iterator<Animal> iterator() {
        return new ZooIterator<Animal>(this);
    }
}
