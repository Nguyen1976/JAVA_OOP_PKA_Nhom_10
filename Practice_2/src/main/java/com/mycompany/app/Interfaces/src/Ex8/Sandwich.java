package Ex8;

public class Sandwich extends PortableLunch implements FastFood{
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public Sandwich(){
        System.out.println("Sandwich()");
    }

    @Override
    public void eat() {
        System.out.println("Eating the sandwich.");
    }

    @Override
    public void serve() {
        System.out.println("Serving the sandwich.");
    }

    public static void main(String[] args) {
        Sandwich s = new Sandwich();
        s.eat();
        s.serve();
    }
}
