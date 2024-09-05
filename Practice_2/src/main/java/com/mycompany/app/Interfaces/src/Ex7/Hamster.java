package Ex7;

public class Hamster implements Rodent{
    @Override
    public void eat() {
        System.out.println("Hamster is eating carrots.");
    }

    @Override
    public void sleep() {
        System.out.println("Hamster is sleeping in a ball.");
    }

    @Override
    public void run() {
        System.out.println("Hamster is running on its wheel.");
    }
}
