package Ex13;

public class Main {
    public static void main(String[] args) {
        Derived derived = new Derived();

        derived.display();
        derived.display(10);
        derived.display(10, "Hello");
        derived.display("Hello");
    }
}
