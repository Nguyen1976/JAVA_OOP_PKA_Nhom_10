package Ex7;

public class Gerbil implements Rodent{
    @Override
    public void eat() {
        System.out.println("Gerbil is eating seeds.");
    }

    @Override
    public void sleep() {
        System.out.println("Gerbil is sleeping in its burrow.");
    }

    @Override
    public void run() {
        System.out.println("Gerbil is running energetically.");
    }
}
