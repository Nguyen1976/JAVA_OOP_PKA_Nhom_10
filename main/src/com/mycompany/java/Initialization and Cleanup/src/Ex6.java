class Cho {
    void bark() {
        System.out.println("Default bark!");
    }

    void bark(int times, double to) {
        System.out.println("Barking " + times + " times with loudness: " + to);
    }

    void bark(double to, int times) {
        System.out.println("Barking " + times + " times with reversed loudness: " + to);
    }
}
public class Ex6 {
    public static void main(String[] args) {
        Cho cho = new Cho();
        cho.bark();
        cho.bark(3, 4.5);
        cho.bark(4.5, 3);
    }
}
