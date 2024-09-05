package Ex7;

public class Mouse implements Rodent{
    @Override
    public void eat() {
        System.out.println("Mouse is eating cheese.");
    }

    @Override
    public void sleep() {
        System.out.println("Mouse is sleeping quietly.");
    }

    @Override
    public void run() {
        System.out.println("Mouse is running fast.");
    }
}
