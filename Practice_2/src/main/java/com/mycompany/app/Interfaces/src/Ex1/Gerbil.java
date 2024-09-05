package Ex1;

public class Gerbil extends Rodent{
    @Override
    public void eat() {
        System.out.println("Gerbil is eating seeds.");
    }

    @Override
    public void sleep() {
        System.out.println("Gerbil is sleeping in a cozy nest.");
    }

    @Override
    public void makeSound() {
        System.out.println("Gerbil makes a soft chirping sound.");
    }
}
