public abstract class Animal implements Comparable<Animal> {
    private String name;
    public Animal (String name) {
        this.name = name;
    }
    public abstract String makeNoise();

    public int compareTo(Animal animal) {
        return this.name.compareTo(animal.name);
    }
}
