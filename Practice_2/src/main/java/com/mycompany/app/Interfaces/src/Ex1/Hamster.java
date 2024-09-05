package Ex1;

public class Hamster extends Rodent{
    @Override
    public void eat() {
        System.out.println("Hamster is munching on vegetables.");
    }

    @Override
    public void sleep() {
        System.out.println("Hamster is sleeping in a burrow.");
    }

    @Override
    public void makeSound() {
        System.out.println("Hamster makes a quiet squeak.");
    }
}
