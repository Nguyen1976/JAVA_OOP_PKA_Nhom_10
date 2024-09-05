package Ex1;

public class Mouse extends Rodent{
    @Override
    public void eat() {
        System.out.println("Mouse is eating cheese.");
    }

    @Override
    public void sleep() {
        System.out.println("Mouse is sleeping in a small hole.");
    }

    @Override
    public void makeSound() {
        System.out.println("Mouse says squeak!");
    }
}
