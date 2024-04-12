public class Cow extends Animal{
    String name;
    public Cow(String name) {
        super(name);
    }
    @Override
    public String makeNoise() {
        return "MUUUU";
    }
    public int compareTo(Cow cow) {
        return super.compareTo(cow);
    }
}
