public class Cat extends Animal{
    String name;
    public Cat(String name) {
        super(name);
    }
    @Override
    public String makeNoise() {
        return "MIAU";
    }
    public int compareTo(Cat cat) {
        return super.compareTo(cat);
    }
}
