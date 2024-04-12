public abstract class Animal implements Comparable<Animal> {
    private final String name;
    public Animal (String name) {
        this.name = name;
    }
    public abstract String makeNoise();
    public int compareTo(Animal animal) {
        if(name == null && animal.name == null) return 0;
        if(name == null) return -1;
        if(animal.name == null) return 1;
        return this.name.compareTo(animal.name);
    }
    //no compile error with comparable, does need it because the class is abstract
    //if you never expect to change variable, make it final

    @Override
    public String toString() {
        //dynamic binding
        return "My name is: " + name + ": " + makeNoise();
    }
}
