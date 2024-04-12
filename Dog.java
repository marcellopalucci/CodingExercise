public class Dog extends Animal{
    String name;
    public Dog(String name) {
        super(name);
    }
    @Override
    public String makeNoise() {
        return "WOOF";
    }
    public int compareTo(Dog dog) {
        return super.compareTo(dog);
    }
}
